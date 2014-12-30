/* REFERENCES
 * http://www.emgu.com/wiki/index.php/Working_with_Images
 */

using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using Emgu.CV.Structure;
using Emgu.CV;
using HandGestureRecognition.SkinDetector;
using Emgu.CV.UI;
using Emgu.CV.CvEnum;

namespace HandGestureRecognition
{
    public partial class Form1 : Form
    {

        IColorSkinDetector skinDetector;  ////has an abstract method detectSkin

        Image<Bgr, Byte> currentFrame;  ////bgr - blue green red //It is advantegeous over using CvInvoke.cvCreateImage
        Image<Bgr, Byte> currentFrameCopy;
        Image<Bgr, Byte> result;
                
        Capture grabber;    ////creates a camera capture
        AdaptiveSkinDetector detector;
        
        int frameWidth;
        int frameHeight;
        
        Hsv hsv_min;
        Hsv hsv_max;
        Ycc YCrCb_min;
        Ycc YCrCb_max;
        
        Seq<Point> hull;
        Seq<Point> filteredHull;
        Seq<MCvConvexityDefect> defects;       ////MCvConvexityDefect: Managed structure equivalent to CvConvexityDefect
        MCvConvexityDefect[] defectArray;
        Rectangle handRect;
        MCvBox2D box;
        Ellipse ellip;

        Capture _capture;
        HaarCascade _faces;
        HaarCascade _eyes;
        HaarCascade face;
        Image<Gray, byte> gray = null;

        int flag=0,eflag=0;
        int fingercount=0;
        int extragestures = 0;
        // 1 - C
        // 2 - CUT
        // 3 - GUN
        
        public Form1()
        {
            InitializeComponent();
            ImageViewer viewer = new ImageViewer(); ////create an image viewer
            Capture capture = new Capture(); ////create a camera captue
            Application.Idle += new EventHandler(delegate(object sender, EventArgs e)
            {  ////run this until application closed (close button click on image viewer)
                viewer.Image = capture.QueryFrame(); ////draw the image obtained from camera
            });
            

         //   grabber = new Emgu.CV.Capture(@".\..\..\..\M2U00253.MPG");
            grabber = capture;
            grabber.QueryFrame();
            frameWidth = grabber.Width;
            frameHeight = grabber.Height;
            detector = new AdaptiveSkinDetector(1, AdaptiveSkinDetector.MorphingMethod.NONE);
            hsv_min = new Hsv(0, 45, 0);
            hsv_max = new Hsv(20, 255, 255);
            YCrCb_min = new Ycc(0, 131, 80);
            YCrCb_max = new Ycc(255, 185, 135);
            box = new MCvBox2D();
            ellip = new Ellipse();
            

            face = new HaarCascade("haarcascade_frontalface_default.xml");
 
            Application.Idle += new EventHandler(FrameGrabber);                        
        }

        void FrameGrabber(object sender, EventArgs e)
        {
            currentFrame = grabber.QueryFrame();
            gray = currentFrame.Convert<Gray, Byte>();
            if (currentFrame != null)
            {
                currentFrameCopy = currentFrame.Copy();
                
                // Uncomment if using opencv adaptive skin detector
                //Image<Gray,Byte> skin = new Image<Gray,byte>(currentFrameCopy.Width,currentFrameCopy.Height);                
                //detector.Process(currentFrameCopy, skin);                

                skinDetector = new YCrCbSkinDetector();
                
                Image<Gray, Byte> skin = skinDetector.DetectSkin(currentFrameCopy,YCrCb_min,YCrCb_max);
                Image<Gray, Byte> resultface = null;

                MCvAvgComp[][] facesDetected = gray.DetectHaarCascade(face, 1.4, 4, Emgu.CV.CvEnum.HAAR_DETECTION_TYPE.DO_CANNY_PRUNING, new Size(20, 20));

                //Action for each element detected
                foreach (MCvAvgComp f in facesDetected[0])
                {
                    result = currentFrame.Copy(f.rect);//.Convert<Gray, byte>().Resize(100, 100, Emgu.CV.CvEnum.INTER.CV_INTER_CUBIC);
                    //draw the face detected in the 0th (gray) channel with blue color
                    currentFrame.Draw(f.rect, new Bgr(Color.Red), 2);
                    resultface = skinDetector.DetectSkin(result, YCrCb_min, YCrCb_max);
                }

                ExtractContourAndHull(skin,resultface);
                                
                DrawAndComputeFingersNum();

                imageBoxSkin.Image = skin;
                imageBoxFrameGrabber.Image = currentFrame;
            }
        }

        private void ExtractContourAndHull(Image<Gray, byte> skin, Image<Gray, byte> resultface)
        {
            using (MemStorage storage = new MemStorage())
            {
             //   Contour<Point> contoursface = null;
                Contour<Point> contours = skin.FindContours(Emgu.CV.CvEnum.CHAIN_APPROX_METHOD.CV_CHAIN_APPROX_SIMPLE, Emgu.CV.CvEnum.RETR_TYPE.CV_RETR_LIST, storage);
             //   if (resultface != null)
             //   {   contoursface = resultface.FindContours(Emgu.CV.CvEnum.CHAIN_APPROX_METHOD.CV_CHAIN_APPROX_SIMPLE, Emgu.CV.CvEnum.RETR_TYPE.CV_RETR_LIST, storage); }
                Contour<Point> biggestContour = null;

                Double Result1 = 0;
                Double Result2 = 0;
            
                while (contours != null)         ////to find the biggest contours
                {
                    Result1 = contours.Area;
         //           if (contoursface != null && (contoursface.Area / Result1 * 100) >= 95)
         //           { continue; }                     
                       
               if (Result1 > Result2)
                        {
                            Result2 = Result1;
                            biggestContour = contours;
                        }
                    
                    contours = contours.HNext;
                }

                if (biggestContour != null)
                {
                    //currentFrame.Draw(biggestContour, new Bgr(Color.DarkViolet), 2);
                    Contour<Point> currentContour = biggestContour.ApproxPoly(biggestContour.Perimeter * 0.0025, storage);
                    currentFrame.Draw(currentContour, new Bgr(Color.LimeGreen), 2);
                    biggestContour = currentContour;
                

                    hull = biggestContour.GetConvexHull(Emgu.CV.CvEnum.ORIENTATION.CV_CLOCKWISE);
                    box = biggestContour.GetMinAreaRect();
                    PointF[] points = box.GetVertices();
                    //handRect = box.MinAreaRect();
                    //currentFrame.Draw(handRect, new Bgr(200, 0, 0), 1);

                    Point[] ps = new Point[points.Length];
                    for (int i = 0; i < points.Length; i++)
                        ps[i] = new Point((int)points[i].X, (int)points[i].Y);

                    currentFrame.DrawPolyline(hull.ToArray(), true, new Bgr(200, 125, 75), 2);
                    currentFrame.Draw(new CircleF(new PointF(box.center.X, box.center.Y), 3), new Bgr(200, 125, 75), 2);
                    ////draws and finds the CENTER of the box

                    //ellip.MCvBox2D= CvInvoke.cvFitEllipse2(biggestContour.Ptr);
                    //currentFrame.Draw(new Ellipse(ellip.MCvBox2D), new Bgr(Color.LavenderBlush), 3);

                    PointF center;
                    float radius;
                    //CvInvoke.cvMinEnclosingCircle(biggestContour.Ptr, out  center, out  radius);
                    //currentFrame.Draw(new CircleF(center, radius), new Bgr(Color.Gold), 2);

                    //currentFrame.Draw(new CircleF(new PointF(ellip.MCvBox2D.center.X, ellip.MCvBox2D.center.Y), 3), new Bgr(100, 25, 55), 2);
                    //currentFrame.Draw(ellip, new Bgr(Color.DeepPink), 2);

                    //CvInvoke.cvEllipse(currentFrame, new Point((int)ellip.MCvBox2D.center.X, (int)ellip.MCvBox2D.center.Y), new System.Drawing.Size((int)ellip.MCvBox2D.size.Width, (int)ellip.MCvBox2D.size.Height), ellip.MCvBox2D.angle, 0, 360, new MCvScalar(120, 233, 88), 1, Emgu.CV.CvEnum.LINE_TYPE.EIGHT_CONNECTED, 0);
                    //currentFrame.Draw(new Ellipse(new PointF(box.center.X, box.center.Y), new SizeF(box.size.Height, box.size.Width), box.angle), new Bgr(0, 0, 0), 2);


                    filteredHull = new Seq<Point>(storage);
                    for (int i = 0; i < hull.Total; i++)
                    {
                        if (Math.Sqrt(Math.Pow(hull[i].X - hull[i + 1].X, 2) + Math.Pow(hull[i].Y - hull[i + 1].Y, 2)) > box.size.Width / 10)
                        {
                            filteredHull.Push(hull[i]);
                        }
                    }

                    defects = biggestContour.GetConvexityDefacts(storage, Emgu.CV.CvEnum.ORIENTATION.CV_CLOCKWISE);

                    defectArray = defects.ToArray();
                }
            }
        }

        public void movemouse(int x, int y)
        {
            int X,Y,Maxx,Maxy;

            Maxx = 1366;
            Maxy = 768;
            X = (x * Maxx) / (imageBoxFrameGrabber.Size.Width-100);
            Y = (y * Maxy) / (imageBoxFrameGrabber.Size.Height-100);
            Cursor.Position = new Point(X,Y);
            label1.Text = x + " " + y;

        }


        private void DrawAndComputeFingersNum()
        {
            int fingerNum = 0;

            #region hull drawing
          /*  for (int j = 0; j < filteredHull.Total; j++)
            {
                PointF hullPoint = new PointF((float)filteredHull[j].X,
                                              (float)filteredHull[j].Y);
                CircleF hullCircle = new CircleF(hullPoint, 4);
                currentFrame.Draw(hullCircle, new Bgr(Color.Aquamarine), 2);
            }*/
            #endregion

            #region defects drawing
            for (int i = 0; i < defects.Total; i++)
          //  int i = 0;
            {
                PointF startPoint = new PointF((float)defectArray[i].StartPoint.X,
                                                (float)defectArray[i].StartPoint.Y);

                PointF depthPoint = new PointF((float)defectArray[i].DepthPoint.X,
                                                (float)defectArray[i].DepthPoint.Y);

                PointF endPoint = new PointF((float)defectArray[i].EndPoint.X,
                                                (float)defectArray[i].EndPoint.Y);

                LineSegment2D startDepthLine = new LineSegment2D(defectArray[i].StartPoint, defectArray[i].DepthPoint);

                LineSegment2D depthEndLine = new LineSegment2D(defectArray[i].DepthPoint, defectArray[i].EndPoint);

                CircleF startCircle = new CircleF(startPoint, 5f);

                CircleF depthCircle = new CircleF(depthPoint, 5f);

                CircleF endCircle = new CircleF(endPoint, 5f);

                ////Finger Counting
                //Custom heuristic based on some experiment, double check it before use
            //    if ((startCircle.Center.Y < box.center.Y || depthCircle.Center.Y < box.center.Y) && (startCircle.Center.Y < depthCircle.Center.Y) && (Math.Sqrt(Math.Pow(startCircle.Center.X - depthCircle.Center.X, 2) + Math.Pow(startCircle.Center.Y - depthCircle.Center.Y, 2)) > box.size.Height / 4))
                if (startCircle.Center.Y > box.center.Y && endCircle.Center.Y < box.center.Y && endCircle.Center.Y < startCircle.Center.Y && Math.Abs(startCircle.Center.X - endCircle.Center.X) < 25 && Math.Abs(startCircle.Center.Y - endCircle.Center.Y) > box.size.Height/2 && Math.Abs(startCircle.Center.X-depthCircle.Center.X) > box.size.Width/3 && depthCircle.Center.X < startCircle.Center.X && depthCircle.Center.X < endCircle.Center.X)
                {
                    eflag = 1;
                    extragestures = 1;
                }
                else if (startCircle.Center.Y > box.center.Y && endCircle.Center.Y < box.center.Y && endCircle.Center.Y < startCircle.Center.Y && Math.Abs(startCircle.Center.X - endCircle.Center.X) < 25 && Math.Abs(startCircle.Center.Y - endCircle.Center.Y) > box.size.Height / 5 && Math.Abs(startCircle.Center.X - depthCircle.Center.X) > box.size.Width / 2.5 && depthCircle.Center.X < startCircle.Center.X && depthCircle.Center.X < endCircle.Center.X)
                {
                    eflag = 1;
                    extragestures = 2;
                }
                else if (depthCircle.Center.X > box.center.X && endCircle.Center.X > box.center.X && Math.Abs(depthCircle.Center.Y - endCircle.Center.Y) < 30 && Math.Abs(depthCircle.Center.X - endCircle.Center.X) > box.size.Width/2 && startCircle.Center.Y>endCircle.Center.Y)
                {
                    eflag = 1;
                    extragestures = 3;
                }
                
                else if ((startCircle.Center.Y < box.center.Y || depthCircle.Center.Y < box.center.Y) && (Math.Abs(depthCircle.Center.Y-box.center.Y)<box.size.Height/5 || Math.Abs(depthCircle.Center.X-box.center.X)<box.size.Height/5) && (Math.Sqrt(Math.Pow(startCircle.Center.X - depthCircle.Center.X, 2) + Math.Pow(startCircle.Center.Y - depthCircle.Center.Y, 2)) > box.size.Height / 4))
                {
                    fingerNum++;
                    currentFrame.Draw(startDepthLine, new Bgr(Color.Magenta), 2);
                    //currentFrame.Draw(depthEndLine, new Bgr(Color.Magenta), 2);
                }

                currentFrame.Draw(startCircle, new Bgr(Color.Red), 2);
                currentFrame.Draw(depthCircle, new Bgr(Color.Yellow), 5);
                currentFrame.Draw(endCircle, new Bgr(Color.DarkBlue), 4);
            }
            #endregion

            if (eflag == 1)
            {
                if (extragestures == 1)
                {
                    MCvFont font = new MCvFont(Emgu.CV.CvEnum.FONT.CV_FONT_HERSHEY_DUPLEX, 5d, 5d);
                    currentFrame.Draw("C", ref font, new Point(50, 150), new Bgr(Color.White));
                }
                else if (extragestures == 2)
                {
                    MCvFont font = new MCvFont(Emgu.CV.CvEnum.FONT.CV_FONT_HERSHEY_DUPLEX, 5d, 5d);
                    currentFrame.Draw("Cut", ref font, new Point(50, 150), new Bgr(Color.White));
                }
                else if (extragestures == 3)
                {
                    MCvFont font = new MCvFont(Emgu.CV.CvEnum.FONT.CV_FONT_HERSHEY_DUPLEX, 5d, 5d);
                    currentFrame.Draw("Gun", ref font, new Point(50, 150), new Bgr(Color.White));
                }
                eflag = 0;
            }
            else if (fingerNum == 0)
            {
                MCvFont font = new MCvFont(Emgu.CV.CvEnum.FONT.CV_FONT_HERSHEY_DUPLEX, 5d, 5d);
                currentFrame.Draw(fingerNum.ToString(), ref font, new Point(50, 150), new Bgr(Color.White));
                font = new MCvFont(Emgu.CV.CvEnum.FONT.CV_FONT_HERSHEY_DUPLEX, 1d, 1d);
                currentFrame.Draw(box.center.X.ToString() +","+ box.center.Y.ToString(), ref font, new Point(250, 150), new Bgr(Color.White));
                movemouse((int)box.center.X, (int)box.center.Y);
                
                flag = 0;
            }
            else
            {
                if (flag == 0)
                {
                    fingercount = fingerNum;
                    flag = 1;
                }
                else if (fingercount == fingerNum && flag<10)
                {
                    flag++;
                }
                else if (flag == 10 && fingercount == fingerNum)
                {
                    MCvFont font = new MCvFont(Emgu.CV.CvEnum.FONT.CV_FONT_HERSHEY_DUPLEX, 5d, 5d);
                    currentFrame.Draw(fingerNum.ToString(), ref font, new Point(50, 150), new Bgr(Color.White));
                    flag = 0;
                }
                else
                {
                    flag = 0;
                }
            }
        }
      
                                      
    }
}