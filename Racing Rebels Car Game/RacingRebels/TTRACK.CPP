#include<iostream.h>
#include"newobstacle.cpp"
#include"horizon.cpp"
#include"stopwatc.cpp"
#include<dos.h>
#include<time.h>
#include"obstacle.cpp"

int flag=0;



/*class of boxes*/



class obstaclebox
{
int i,color;
public:

obstaclebox();
void movel(int c);
void move(int c,int a);
};

obstaclebox::obstaclebox()
{
color=1;
}



/*defined function of class obstaclebox*/




void obstaclebox:: movel(int c)   //BLUE BOX
{
switch(c)
{
case 1:
setcolor(BLACK);
setfillstyle(1,color);
bar3d(280,155,300,165,10/4,1);
break;

case 2:
setcolor(BLACK);
setfillstyle(1,color);
bar3d(280,155,300,165,12/4,1);
break;

case 3:
 setcolor(BLACK);
 setfillstyle(1,8);
 bar(278,152,305,165);
 setfillstyle(1,color);
 bar3d(265,175,290,190,15/4,1);
break;

case 4:
 setcolor(BLACK);
 setfillstyle(1,8);
 bar(278,152,305,165);
 setfillstyle(1,color);
 bar3d(265,175,290,190,15/4,1);
break;

case 5:
 setcolor(BLACK);
 setfillstyle(1,8);
  bar(265,170,295,190);
 setfillstyle(1,color);
 bar3d(250,200,280,220,20/4,1);
break;

case 6:
 setcolor(BLACK);
 setfillstyle(1,8);
  bar(265,170,295,190);
 setfillstyle(1,color);
 bar3d(250,200,280,220,20/4,1);
break;

case 7:
setcolor(BLACK);
setfillstyle(1,8);
 bar(250,194,286,220);
setfillstyle(1,color);
bar3d(235,230,270,255,25/4,1);
break;

case 8:
setcolor(BLACK);
setfillstyle(1,8);
 bar(250,194,286,220);
setfillstyle(1,color);
bar3d(235,230,270,255,25/4,1);
break;

case 9:
 setcolor(BLACK);
 setfillstyle(1,8);
 bar(235,223,277,255);
setfillstyle(1,color);
bar3d(210,265,255,295,30/4,1);
break;

case 10:
 setcolor(BLACK);
 setfillstyle(1,8);
 bar(235,223,277,255);
setfillstyle(1,color);
bar3d(210,265,255,295,30/4,1);
break;

case 11:
 setcolor(BLACK);
 setfillstyle(1,8);
 bar(210,257,263,295);
setfillstyle(1,color);
bar3d(185,305,240,340,35/4,1);
break;

case 12:
 setcolor(BLACK);
 setfillstyle(1,8);
 bar(210,257,263,295);
setfillstyle(1,color);
bar3d(185,305,240,340,35/4,1);
break;

case 13:
setcolor(BLACK);
setfillstyle(1,8);
 bar(185,296,249,340);
setfillstyle(1,color);
bar3d(150,350,220,390,40/4,1);
break;

case 14:
setcolor(BLACK);
setfillstyle(1,8);
 bar(185,296,249,340);
setfillstyle(1,color);
bar3d(150,350,220,390,40/4,1);
break;

case 15:
 setcolor(BLACK);
 setfillstyle(1,8);
 bar(150,340,230,420);
setfillstyle(1,color);
bar3d(120,410,200,455,45/4,1);

break;

case 16:
 setcolor(BLACK);
setfillstyle(1,8);
 bar(119,379,212,477);
break;

}
}




void obstaclebox:: move(int c,int a)    //RED BOX
{
switch(c)
{
case 1:
setcolor(BLACK);
setfillstyle(1,RED);
bar3d(300+a,160,335+a,185,25/4,1);
break;

case 2:
 setcolor(BLACK);
 setfillstyle(1,RED);
 bar3d(300+a,160,335+a,185,25/4,1);

break;

case 3:
 setcolor(BLACK);
 setfillstyle(1,8);
 bar(300+a,155,345+a,190);
 setfillstyle(1,RED);
 bar3d(300+a,185,335+a,210,25/4,1);

break;


case 4:
 setcolor(BLACK);
 setfillstyle(1,RED);
 bar3d(300+a,185,335+a,210,25/4,1);

break;

case 5:
 setcolor(BLACK);
 setfillstyle(1,8);
 bar(300+a,155,345+a,215);
 setfillstyle(1,RED);
 bar3d(300+a,210,335+a,235,25/4,1);

break;

case 6:
 setcolor(BLACK);
 setfillstyle(1,RED);
 bar3d(300+a,210,335+a,235,25/4,1);

break;

case 7:
setcolor(BLACK);
setfillstyle(1,8);
bar(300+a,185,345+a,245);
setfillstyle(1,RED);
bar3d(300+a,235,335+a,260,25/4,1);
break;

case 8:
setcolor(BLACK);
setfillstyle(1,RED);
bar3d(300+a,235,335+a,260,25/4,1);

break;

case 9:
setcolor(BLACK);
setfillstyle(1,8);
 bar(300+a,225,345+a,265);
setfillstyle(1,RED);
bar3d(300+a,260,335+a,285,25/4,1);
break;

 case 10:
 setcolor(BLACK);
 setfillstyle(1,RED);
 bar3d(300+a,260,335+a,285,25/4,1);

break;

case 11:
 setcolor(BLACK);
 setfillstyle(1,8);
 bar(300+a,250,345+a,290);
 setfillstyle(1,RED);
 bar3d(300+a,285,335+a,310,25/4,1);
 break;

case 12:
 setcolor(BLACK);
 setfillstyle(1,RED);
 bar3d(300+a,285,335+a,310,25/4,1);
 break;

case 13:
 setcolor(BLACK);
 setfillstyle(1,8);
 bar(300+a,275,345+a,315);
 setfillstyle(1,RED);
 bar3d(300+a,310,335+a,335,25/4,1);
 break;

case 14:
 setcolor(BLACK);
 setfillstyle(1,RED);
 bar3d(300+a,310,335+a,335,25/4,1);
 break;

case 15:
 setcolor(BLACK);
 setfillstyle(1,8);
 bar(300+a,300,345+a,340);
 setfillstyle(1,RED);
 bar3d(300+a,335,335+a,360,25/4,1);
break;

case 16:
 setcolor(BLACK);
 setfillstyle(1,RED);
 bar3d(300+a,335,335+a,360,25/4,1);
 break;

case 17:
 setcolor(BLACK);
 setfillstyle(1,8);
 bar(300+a,325,345+a,365);
 setfillstyle(1,RED);
 bar3d(300+a,360,335+a,385,25/4,1);
 break;

case 18:
 setcolor(BLACK);
 setfillstyle(1,RED);
 bar3d(300+a,360,335+a,385,25/4,1);
 break;

case 19:
 setcolor(BLACK);
 setfillstyle(1,8);
 bar(300+a,350,345+a,420);
 setfillstyle(1,RED);
 bar3d(300+a,385,335+a,410,30/4,1);
 break;

case 20:
 setcolor(BLACK);
 setfillstyle(1,RED);
 bar3d(300+a,385,335+a,410,30/4,1);
 break;

case 21:
 setcolor(BLACK);
 setfillstyle(1,8);
 bar(300+a,375,345+a,415);
 setfillstyle(1,RED);
 bar3d(300+a,440,335+a,465,25/4,1);
 break;

case 22:
 setcolor(BLACK);
 setfillstyle(1,RED);
 bar3d(300+a,440,335+a,465,30/4,0);
 setfillstyle(1,8);
 bar(300+a,430,345+a,470);
 break;
}
}



obstacle1 o;
obstaclebox obbox;
int opp=100;
int opp1=100;
int opp2=100;





/*CLASS OF FINISHLINE */





class finishline
{

public:

void finish();
};




/*FUNCTIONS OF FINISHLINE*/




void finishline:: finish()
{
int i,j=0;
char na[2];
na[0]=0;
na[1]=15;
setcolor(BLACK);
setfillstyle(1,WHITE);
bar(119,105,509,150);

setcolor(BROWN);
line(120,150,510,150);
setcolor(BLACK);
settextstyle(10,0,3);
outtextxy(262,95,"FINISH");
setfillstyle(1,RED);
floodfill(265,126,BLACK);
floodfill(284,126,BLACK);
floodfill(295,126,BLACK);
floodfill(320,126,BLACK);
floodfill(338,126,BLACK);
floodfill(355,126,BLACK);





//BLOCKS




for(i=0;i<9;i++)
{
setfillstyle(1,na[j]);
bar(119+(15*i),105,119+15+(15*i),120);
if(j==0){j=1;}
else if(j==1){j=0;}
}
j=1;
for(i=0;i<9;i++)
{
setfillstyle(1,na[j]);
bar(119+(15*i),120,119+15+(15*i),135);
if(j==0){j=1;}
else if(j==1){j=0;}
}
j=0;
for(i=0;i<9;i++)
{

setfillstyle(1,na[j]);
bar(119+(15*i),135,119+15+(15*i),150);
if(j==0){j=1;}
else if(j==1){j=0;}
}
j=0;
for(i=0;i<9;i++)
{
setfillstyle(1,na[j]);
bar(374+(15*i),105,374+15+(15*i),120);
if(j==0){j=1;}
else if(j==1){j=0;}
}
j=1;
for(i=0;i<9;i++)
{
setfillstyle(1,na[j]);
bar(374+(15*i),120,374+15+(15*i),135);
if(j==0){j=1;}
else if(j==1){j=0;}
}
j=0;
for(i=0;i<9;i++)
{
setfillstyle(1,na[j]);
bar(374+(15*i),135,374+15+(15*i),150);
if(j==0){j=1;}
else if(j==1){j=0;}
}
setcolor(BLACK);
setfillstyle(1,8);
bar3d(100,130,115,320,15/4,1);
setfillstyle(1,8);
floodfill(102,140,BLACK);
setfillstyle(1,BLACK);
floodfill(117,140,BLACK);
floodfill(105,129,BLACK);

setcolor(BLACK);
setfillstyle(1,8);
bar3d(510,130,525,320,15/4,1);
setfillstyle(1,8);
floodfill(512,140,BLACK);
setfillstyle(1,BLACK);
floodfill(527,140,BLACK);
floodfill(515,129,BLACK);

setcolor(BROWN);
}




/*CLASS TRACK*/





class track: public finishline
{
public:
int polyl[10],polyr[10];
int na[2],j,c,cl,cr,m,i,hc;
char ch,cd,press;

track()
{
na[0]=0;
na[1]=15;
c=100,cl=100,cr=100,hc=1,cd=1,m=1,i=1;
i=0;j=1,countt=0;

setcolor(BROWN);
line(0,150,640,150);



horizon hr;    //objects of the horizon & cloud
hr.cloud();




setfillstyle(1,GREEN);                     //GRASS
floodfill(2,152,BROWN);
floodfill(620,152,BROWN);
}




/*MAIN FUNCTION*/




void levelcenter()
{
 while(countt<=1230)
 {
  if(countt<300)
  {
  obstacle ob;

  o1.design();

  polyl[0]=20;       polyr[0]=600;            //COORDINATES OF TRACK
  polyl[1]=480;      polyr[1]=480;
  polyl[2]=40;       polyr[2]=620;
  polyl[3]=480;      polyr[3]=480;
  polyl[4]=275;      polyr[4]=370;
  polyl[5]=150;      polyr[5]=150;
  polyl[6]=270;      polyr[6]=365;
  polyl[7]=150;      polyr[7]=150;
  polyl[8]=20;       polyr[8]=600;
  polyl[9]=480;      polyr[9]=480;
  setcolor(BROWN);

  drawpoly(5,polyl);                                //2 tracks
  drawpoly(5,polyr);

line(225,210,233,210);                              //TRACK divider
line(408,210,416,210);
line(172,280,183,280);
line(457,280,468,280);
line(103,370,117,370);
line(523,370,538,370);


setfillstyle(1,8);                                  //ROAD
floodfill(340,152,BROWN);

o1.design();
ob.countdown3();
ob.countdown2();
ob.countdown1();






struct time t;
gettime(&t);
t.ti_min=0;
t.ti_sec=0;
t.ti_hour=0;
settime(&t);

stopwatch();




/*FIRST PART : STRAIGHT TRACK*/




 while(countt<300)
 {
  ch=getch();                        //FORWARD KEY

  if(ch==72)
  {
	stopwatch();

    if(countt==120||countt==180)          //OBSTACLE
    opp=1;
    if(countt==60||countt==240)
    opp1=1;
    o.comer(opp1);
    o.come(opp);
    o1.design();
    opp++;
    opp1++;


    if(countt==210||countt==90)
    c=1;
    else if(countt==150||countt==270)
    cl=1;

	 obbox.move(c,0);
	 c++;

	 obbox.movel(cl);
	 cl++;

	  if(c==19)                      //RED
	  {
	    if((o1.a>=280 && o1.a<=370)||(o1.a+85>=280 && o1.a+85<=370))
	    {
	       c=9;
		setfillstyle(1,8);
		setfillstyle(1,8);
		bar(300,350,345,400);
		obbox.move(c,0);
		countt-=10;
	    }
	  }

    if(cl==15)                           //BLUE
	  {
	    if((o1.a>=130 && o1.a<=220)||(o1.a+85>=130 && o1.a+85<=220))
	    {
	       cl=9;
	       obbox.movel(cl);
	       setfillstyle(1,8);
	       bar(150,340,230,490);
	       countt-=6;
	    }

	  }





    if(opp==14 || opp==15)
    {
    if(((o1.a>=p)&&(o1.a<=p+85))||((o1.a+85>=p)&&(o1.a+85<=p+85)))
    {
    setfillstyle(1,8);
    bar(p,348,p+85,420);

    countt-=5;
    opp=9;
    setfillstyle(1,8);
    floodfill(290,478,BROWN);
    o.come(opp);
    }
    }


    if(opp1==14 || opp1==15)
    {
    if(((o1.a>=p)&&(o1.a<=p+85))||((o1.a+85>=p)&&(o1.a+85<=p+85)))
    {
    setfillstyle(1,8);
    bar(p,348,p+85,420);

    countt-=5;
    opp1=9;
    setfillstyle(1,8);
    floodfill(290,478,BROWN);
    o.comer(opp1);
    }
    }

    if(opp==18)
    {
    setfillstyle(1,8);
    floodfill(290,478,BROWN);
    o1.design();
    }
    if(opp==17||opp1==17)
    {
    setfillstyle(1,8);
    floodfill(p,q,BROWN);
    o1.design();
     }
   countt++;

	if(i==0 && j==1)
	{
	setfillstyle(1,na[i]);
	floodfill(272,152,BROWN);         //first 2 blocks
	floodfill(367,152,BROWN);
	 floodfill(174,282,BROWN);
	 floodfill(460,282,BROWN);

	 setfillstyle(1,na[j]);
	 floodfill(175,278,BROWN);
	 floodfill(460,278,BROWN);
	 floodfill(40,475,BROWN);
	 floodfill(600,475,BROWN);
	 i++;j--;
	 if(countt>=280)
	 {
	 ob.hordingr(hc);
	 hc++;
	 }



	 o1.design();


	}
	else if(i==1 && j==0)
	{
	 setfillstyle(1,na[i]);
	 floodfill(272,152,BROWN);   //first 2 blocks
	 floodfill(367,152,BROWN);
	 floodfill(174,282,BROWN);
	 floodfill(460,282,BROWN);

	 setfillstyle(1,na[j]);
	 floodfill(175,278,BROWN);  // next 2 blocks
	 floodfill(460,278,BROWN);
	 floodfill(40,475,BROWN);
	 floodfill(600,475,BROWN);
	 i--;j++;
	}
  }







  else if(ch==77)                  //RIGHT KEY
  {
  stopwatch();

    if(countt==120||countt==180)
    opp=1;
    if(countt==60||countt==240)
    opp1=1;
    o.comer(opp1);
    o.come(opp);
      o1.design();
    opp++;
    opp1++;

    if(countt==210||countt==90)
    c=1;
    else if(countt==150||countt==270||countt==230)
    cl=1;
	 obbox.move(c,0);
	 c++;

	 obbox.movel(cl);
	 cl++;




	  if(c==19)      //RED
	  {
	    if((o1.a>=280 && o1.a<=370)||(o1.a+85>=280 && o1.a+85<=370))
	    {
	       c=9;
	       setfillstyle(1,8);
		setfillstyle(1,8);
		bar(300,350,345,400);
		obbox.move(c,0);
		countt-=10;
	    }
	  }





    if(cl==14)                         //BLUE
	  {
	    if((o1.a>=100 && o1.a<=220)||(o1.a+85>=100 && o1.a+85<=220))
	    {
	       cl=9;
	       setfillstyle(1,8);
	       bar(150,340,230,390);
	       obbox.movel(cl);
	       countt-=5;
	    }

	  }




    if(opp==14 || opp==15)
    {
    if(((o1.a>=p)&&(o1.a<=p+85))||((o1.a+85>=p)&&(o1.a+85<=p+85)))
    {
    countt-=5;
    opp=9;
    setfillstyle(1,8);
    bar(p,348,p+85,420);

    floodfill(290,478,BROWN);
    o.come(opp);
    }
    }




    if(opp1==14 || opp1==15)
    {
    if(((o1.a>=p)&&(o1.a<=p+85))||((o1.a+85>=p)&&(o1.a+85<=p+85)))
    {
    setfillstyle(1,8);
    countt-=5;
    opp1=9;
    setfillstyle(1,8);
    bar(p,348,p+85,420);

    floodfill(290,478,BROWN);
    o.comer(opp1);
    }
    }



    if(opp==18)
    {
    setfillstyle(1,8);
    floodfill(290,478,BROWN);
    o1.design();
    }
    if(opp==17||opp1==17)
    {
    setfillstyle(1,8);
    floodfill(p,q,BROWN);
    o1.design();
    }
 countt++;
 if(o1.a<=400 )
 o1.a+=40;
  setfillstyle(1,8);
 floodfill(o1.a,o1.b,BROWN);




 o1.design();





 if(i==0 && j==1 )
 {

 setfillstyle(1,na[i]);
 floodfill(272,152,BROWN);   //first 2 blocks
 floodfill(367,152,BROWN);
 floodfill(174,282,BROWN);
 floodfill(460,282,BROWN);
 setfillstyle(1,na[j]);

 floodfill(175,278,BROWN);
 floodfill(460,278,BROWN);
 floodfill(40,475,BROWN);
 floodfill(600,475,BROWN);
 i++;j--;
 setfillstyle(1,8);
 floodfill(o1.a,o1.b,BROWN);
 o1.design();

 }
 else if(i==1 && j==0)
 {
 setfillstyle(1,na[i]);
 floodfill(272,152,BROWN);   //first 2 blocks
 floodfill(367,152,BROWN);
 floodfill(174,282,BROWN);
 floodfill(460,282,BROWN);
 setfillstyle(1,na[j]);

 floodfill(175,278,BROWN);  // next 2 blocks
 floodfill(460,278,BROWN);
 floodfill(40,475,BROWN);
 floodfill(600,475,BROWN);
 i--;j++;

 }
 }






  else if(ch==75)                   //LEFT KEY
 {
  stopwatch();

    if(countt==120||countt==180)
    opp=1;
    if(countt==60||countt==240)
    opp1=1;
    o.comer(opp1);
    o.come(opp);
      o1.design();
    opp++;
    opp1++;


    if(countt==210||countt==90)
    c=1;
    else if(countt==150||countt==270||countt==230)
    cl=1;

	 obbox.move(c,0);
	 c++;

	 obbox.movel(cl);
	 cl++;





	  if(c==19)      //RED
	  {
	    if((o1.a>=280 && o1.a<=370)||(o1.a+85>=280 && o1.a+85<=370)) //150 220
	    {
	       c=9;
	       setfillstyle(1,8);
		setfillstyle(1,8);
		bar(300,350,345,400);
		obbox.move(c,0);
		countt-=10;
	    }
	  }





	  if(cl==14)      //BLUE
	  {
	    if((o1.a>=100 && o1.a<=220)||(o1.a+85>=100 && o1.a+85<=220)) //150 220
	    {
	       cl=9;
	       setfillstyle(1,8);
	       bar(150,340,230,390);
	       obbox.movel(cl);
	       countt-=5;
	    }

	  }







    if(opp==14 || opp==15)
    {
    if(((o1.a>=p)&&(o1.a<=p+85))||((o1.a+85>=p)&&(o1.a+85<=p+85)))
    {
    countt-=5;
    opp=9;
    setfillstyle(1,8);
    bar(p,348,p+85,420);

    floodfill(290,478,BROWN);
    o.come(opp);
    }
    }





    if(opp1==14 || opp1==15)
    {
    if(((o1.a>=p)&&(o1.a<=p+85))||((o1.a+85>=p)&&(o1.a+85<=p+85)))
    {
    setfillstyle(1,8);
    bar(p,348,p+85,420);
    countt-=5;
    opp1=9;
    setfillstyle(1,8);
    floodfill(290,478,BROWN);
    o.comer(opp1);
    }
    }


    if(opp==18)
    {
    setfillstyle(1,8);
    floodfill(290,478,BROWN);
    o1.design();
    }
    if(opp==17||opp1==17/*||opp2==17*/)
    {
    setfillstyle(1,8);
    floodfill(p,q,BROWN);
    o1.design();

    }
  countt++;
 if(o1.a>=150)
 o1.a-=40;
  setfillstyle(1,8);
 floodfill(o1.a,o1.b,BROWN);


 o1.design();
 if(i==0 && j==1 )
 {

 setfillstyle(1,na[i]);
 floodfill(272,152,BROWN);   //first 2 blocks
 floodfill(367,152,BROWN);
 floodfill(174,282,BROWN);
 floodfill(460,282,BROWN);
 setfillstyle(1,na[j]);

 floodfill(175,278,BROWN);
 floodfill(460,278,BROWN);
 floodfill(40,475,BROWN);
 floodfill(600,475,BROWN);
 i++;j--;
 setfillstyle(1,8);
 floodfill(o1.a,o1.b,BROWN);




 o1.design();





 }

 else if(i==1 && j==0)
 {
 setfillstyle(1,na[i]);
 floodfill(272,152,BROWN);   //first 2 blocks
 floodfill(367,152,BROWN);
 floodfill(174,282,BROWN);
 floodfill(460,282,BROWN);
 setfillstyle(1,na[j]);

 floodfill(175,278,BROWN);  // next 2 blocks
 floodfill(460,278,BROWN);
 floodfill(40,475,BROWN);
 floodfill(600,475,BROWN);
 i--;j++;
 }
 }





 else if(ch==27)             // ESC
  {
 mainmenu(p1,flag);
  }



 }
}

hc=1;





/* SECOND PART : RIGHT TURN */





if(countt>=300 && countt<600)
{
setfillstyle(1,GREEN);
bar(0,151,640,480);


setcolor(BROWN);

obstacle ob;

o1.a=265;
 o1.b=425;
setfillstyle(1,GREEN);       //GRASS
floodfill(2,152,BROWN);
floodfill(620,152,BROWN);

setcolor(BROWN);
arc(640,667,120,165,600);
arc(620,630,115,235,550);

arc(1080,400,155,290,600);
arc(1060,420,150,290,600);

setfillstyle(1,8);           //ROAD
floodfill(360,152,BROWN);

line(265,210,250,210);   //divider
line(510,210,498,210);
line(182,280,195,280);
line(477,280,493,280);
line(118,370,134,370);
line(462,370,480,370);






 while(countt<600)
 {
 ch=getch();






  if(ch==72)                      //forward key
  {
  stopwatch();

    if(countt==430||countt==520)
	opp2=1;

    o.cometrl(opp2);

    o1.design();
    opp2++;



    if(countt==340||countt==380||countt==480||countt==560)
    c=1;

    obbox.move(c,50);
    c++;
    putpixel(o1.a,140,CYAN);
    putpixel(330,130,MAGENTA);
    putpixel(480,130,MAGENTA);





    if(c==19)      //RED
	  {

	    if(((o1.a>=320) && (o1.a<=420))||((o1.a+85>=320) && (o1.a+85<=420))) //150 220
	    {
	       c=9;

	       setfillstyle(1,8);
		setfillstyle(1,8);
		bar(350,350,395,400);
	       obbox.move(c,50);
	       countt-=10;
	    }
	  }






    if(opp2==14 || opp2==15)
    {
    if(((o1.a>=p)&&(o1.a<=p+85))||((o1.a+85>=p)&&(o1.a+85<=p+85)))
    {
    setfillstyle(1,8);
    bar(p,348,p+85,420);

    countt-=5;
    opp2=9;
    setfillstyle(1,8);
    floodfill(350,378,BROWN);
    o.cometrl(opp2);
    }
    }
  countt++;





	if(i==0 && j==1)
	{
	setfillstyle(1,na[i]);
	floodfill(340,152,BROWN);   //first 2 blocks
	floodfill(505,207,BROWN);
	floodfill(123,367,BROWN);
	floodfill(472,367,BROWN);

	setfillstyle(1,na[j]);
	floodfill(188,278,BROWN);
	floodfill(490,278,BROWN);
	floodfill(90,475,BROWN);
	floodfill(480,475,BROWN);
	i++;j--;
	if(countt>=580)
	 {
	 ob.hordingl(hc);
	 hc++;
	 }

	o1.design();
	}




	else if(i==1 && j==0)
	{
	 setfillstyle(1,na[i]);
	 floodfill(340,152,BROWN);   //first 2 blocks
	 floodfill(505,207,BROWN);
	 floodfill(123,367,BROWN);
	 floodfill(472,367,BROWN);

	 setfillstyle(1,na[j]);
	 floodfill(188,278,BROWN);
	 floodfill(490,278,BROWN);
	 floodfill(90,475,BROWN);
	 floodfill(480,475,BROWN);
	 i--;j++;

	}
  }




  else if(ch==77)                    //RIGHT KEY
  {
  stopwatch();

   if(countt==430||countt==520)
	opp2=1;

    o.cometrl(opp2);
    o1.design();
    opp2++;




    if(countt==340||countt==380||countt==480||countt==560)
    c=1;

    obbox.move(c,50);
    c++;
    putpixel(o1.a,140,CYAN);
    putpixel(330,130,MAGENTA);
    putpixel(480,130,MAGENTA);





    if(c==19)      //RED
	  {

	    if(((o1.a>=320) && (o1.a<=420))||((o1.a+85>=320) && (o1.a+85<=420))) //150 220
	    {
	       c=9;

	       setfillstyle(1,8);
		setfillstyle(1,8);
		bar(350,350,395,400);
	       obbox.move(c,50);
	       countt-=10;
	    }
	  }







    if(opp2==14 || opp2==15)
    {
    if(((o1.a>=p)&&(o1.a<=p+85))||((o1.a+85>=p)&&(o1.a+85<=p+85)))
    {
    setfillstyle(1,8);
    bar(p,348,p+85,420);

    countt-=5;
    opp2=9;
    setfillstyle(1,8);
    floodfill(350,378,BROWN);
    o.cometrl(opp2);
    }
    }
 countt++;




 if(o1.a<=340 )
 o1.a+=40;
  setfillstyle(1,8);
 floodfill(o1.a,o1.b,BROWN);




 o1.design();






 if(i==0 && j==1 )
 {

 setfillstyle(1,na[i]);
	floodfill(340,152,BROWN);   //first 2 blocks
	floodfill(505,207,BROWN);
	floodfill(123,367,BROWN);
	floodfill(472,367,BROWN);

	setfillstyle(1,na[j]);
	floodfill(188,278,BROWN);
	floodfill(490,278,BROWN);
	floodfill(90,475,BROWN);
	floodfill(480,475,BROWN);

 i++;j--;
 setfillstyle(1,8);
 floodfill(o1.a,o1.b,BROWN);



 o1.design();



 }
 else if(i==1 && j==0)
 {
 setfillstyle(1,na[i]);
	floodfill(340,152,BROWN);   //first 2 blocks
	floodfill(505,207,BROWN);
	floodfill(123,367,BROWN);
	floodfill(472,367,BROWN);

	setfillstyle(1,na[j]);
	floodfill(188,278,BROWN);
	floodfill(490,278,BROWN);
	floodfill(90,475,BROWN);
	floodfill(480,475,BROWN);

 i--;j++;


 }
 }






  else if(ch==75)                           //LEFT KEY
 {
  stopwatch();

    if(countt==430||countt==520)
	opp2=1;

    o.cometrl(opp2);
    o1.design();
    opp2++;
    if(countt==340||countt==380||countt==480||countt==560)
    c=1;

    obbox.move(c,50);
    c++;
    putpixel(o1.a,140,CYAN);
    putpixel(330,130,MAGENTA);
    putpixel(480,130,MAGENTA);






    if(c==19)      //RED
	  {

	    if(((o1.a>=320) && (o1.a<=420))||((o1.a+85>=320) && (o1.a+85<=420))) //150 220
	    {
	       c=9;

	       setfillstyle(1,8);
		setfillstyle(1,8);
		bar(350,350,395,400);
	       obbox.move(c,50);
	       countt-=10;
	    }
	  }






    if(opp2==14 || opp2==15)
    {
    if(((o1.a>=p)&&(o1.a<=p+85))||((o1.a+85>=p)&&(o1.a+85<=p+85)))
    {
    setfillstyle(1,8);
    bar(p,348,p+85,420);

    countt-=5;
    opp2=9;
    setfillstyle(1,8);
    floodfill(350,378,BROWN);
    o.cometrl(opp2);
    }
    }
  countt++;
 if(o1.a>=170)
 o1.a-=40;
  setfillstyle(1,8);
 floodfill(o1.a,o1.b,BROWN);




 o1.design();




 if(i==0 && j==1 )
 {

 setfillstyle(1,na[i]);
	floodfill(340,152,BROWN);   //first 2 blocks
	floodfill(505,207,BROWN);
	floodfill(123,367,BROWN);
	floodfill(472,367,BROWN);

	setfillstyle(1,na[j]);
	floodfill(188,278,BROWN);
	floodfill(490,278,BROWN);
	floodfill(90,475,BROWN);
	floodfill(480,475,BROWN);

 i++;j--;
 setfillstyle(1,8);
 floodfill(o1.a,o1.b,BROWN);


 o1.design();


 }




 else if(i==1 && j==0)
 {
 setfillstyle(1,na[i]);
	floodfill(340,152,BROWN);   //first 2 blocks
	floodfill(505,207,BROWN);
	floodfill(123,367,BROWN);
	floodfill(472,367,BROWN);

	setfillstyle(1,na[j]);
	floodfill(188,278,BROWN);
	floodfill(490,278,BROWN);
	floodfill(90,475,BROWN);
	floodfill(480,475,BROWN);

 i--;j++;


 }
 }




  else if(ch==27)             // ESC
  {
  mainmenu(p1,flag);
  }
}
}





/*THIRD PART : LEFT TURN*/






else if(countt>=600 && countt<900)
  {
  setfillstyle(1,GREEN);
  bar(0,151,640,480);
  setcolor(BROWN);
  obstacle ob;
  //car o1;
  o1.a=265;
  o1.b=425;

setfillstyle(1,GREEN);       //GRASS
floodfill(2,152,BROWN);
floodfill(620,152,BROWN);

setcolor(BROWN);
arc(10,498,300,43,510);
arc(30,510,300,45,510);

arc(-300,150,300,0,510);
arc(-310,131,300,-2,510);

setfillstyle(1,8);           //ROAD
floodfill(340,152,BROWN);

line(194,210,206,210);   //divider
line(429,210,443,210);
line(178,280,193,280);
line(470,280,485,280);
line(141,370,159,370);
line(503,370,519,370);


while(countt<900)
{
ch=getch();                        //forward KEY
  if(ch==72)
  {
   stopwatch();
   if(countt==820)
    opp=1;
    if(countt==690)
    opp2=1;

    o.cometlr(opp2);
    o.cometl(opp);
    o1.design();
    opp++;

    opp2++;

    if(countt==740||countt==640||countt==860)
    c=1;

    obbox.move(c,30);
    c++;





    if(c==19)      //RED
	  {

	    if(((o1.a>=320) && (o1.a<=420))||((o1.a+85>=320) && (o1.a+85<=420))) //150 220
	    {
	       c=9;

	       setfillstyle(1,8);
		setfillstyle(1,8);
		bar(320,350,395,400);
	       obbox.move(c,30);
	       countt-=10;
	    }
	  }





    if(opp==14 || opp==15)
    {
    if(((o1.a>=p)&&(o1.a<=p+85))||((o1.a+85>=p)&&(o1.a+85<=p+85)))
    {
    setfillstyle(1,8);
    bar(p,348,p+85,420);

    countt-=5;
    opp=9;
    setfillstyle(1,8);
    floodfill(290,478,BROWN);
    o.cometl(opp);
    }
    }
    if(opp2==14 || opp2==15)
    {
    if(((o1.a>=p)&&(o1.a<=p+85))||((o1.a+85>=p)&&(o1.a+85<=p+85)))
    {
    setfillstyle(1,8);
    bar(p,348,p+85,420);

    countt-=5;
    opp2=9;
    setfillstyle(1,8);
    floodfill(310,478,BROWN);
    o.cometlr(opp2);
    }
    }
   countt++;
	if(i==0 && j==1)
	{
	setfillstyle(1,na[i]);
	floodfill(196,208,BROWN);   //first 2 blocks
	floodfill(431,208,BROWN);
	 floodfill(143,368,BROWN);
	 floodfill(505,368,BROWN);

	 setfillstyle(1,na[j]);
	 floodfill(180,278,BROWN);
	 floodfill(472,278,BROWN);
	 floodfill(140,372,BROWN);
	 floodfill(505,372,BROWN);
	 i++;j--;
	   o1.design();

	 }





	else if(i==1 && j==0)
	{
	 setfillstyle(1,na[i]);
	floodfill(196,208,BROWN);   //first 2 blocks
	floodfill(431,208,BROWN);
	 floodfill(143,368,BROWN);
	 floodfill(505,368,BROWN);

	 setfillstyle(1,na[j]);
	 floodfill(180,278,BROWN);
	 floodfill(472,278,BROWN);
	 floodfill(140,372,BROWN);
	 floodfill(505,372,BROWN);
	 i--;j++;
	}
  }





else if(ch==77)                         //RIGHT KEY
 {
 stopwatch();
 if(countt==820)
    opp=1;
    if(countt==690)
    opp2=1;

    o.cometlr(opp2);
    o.cometl(opp);
    o1.design();
    opp++;

    opp2++;

    if(countt==740||countt==640||countt==860)
    c=1;

    obbox.move(c,30);
    c++;





    if(c==19)      //RED
	  {

	    if(((o1.a>=320) && (o1.a<=420))||((o1.a+85>=320) && (o1.a+85<=420))) //150 220
	    {
	       c=9;

	       setfillstyle(1,8);
		setfillstyle(1,8);
		bar(320,350,395,400);
	       obbox.move(c,30);
	       countt-=10;
	    }
	  }




    if(opp==14 || opp==15)
    {
    if(((o1.a>=p)&&(o1.a<=p+85))||((o1.a+85>=p)&&(o1.a+85<=p+85)))
    {
    setfillstyle(1,8);
    bar(p,348,p+85,420);

    countt-=5;
    opp=9;
    setfillstyle(1,8);
    floodfill(290,478,BROWN);
    o.cometl(opp);
    }
    }
    if(opp2==14 || opp2==15)
    {
    if(((o1.a>=p)&&(o1.a<=p+85))||((o1.a+85>=p)&&(o1.a+85<=p+85)))
    {
    setfillstyle(1,8);
    bar(p,348,p+85,420);

    countt-=5;
    opp2=9;
    setfillstyle(1,8);
    floodfill(310,478,BROWN);
    o.cometlr(opp2);
    }
    }
 countt++;
 if(o1.a<=380 )
 o1.a+=40;
  setfillstyle(1,8);
 floodfill(o1.a,o1.b,BROWN);




 o1.design();




 if(i==0 && j==1)
	{
	setfillstyle(1,na[i]);
	floodfill(196,208,BROWN);   //first 2 blocks
	floodfill(431,208,BROWN);
	 floodfill(143,368,BROWN);
	 floodfill(505,368,BROWN);

	 setfillstyle(1,na[j]);
	 floodfill(180,278,BROWN);
	 floodfill(472,278,BROWN);
	 floodfill(140,372,BROWN);
	 floodfill(505,372,BROWN);
	 i++;j--;
	  if(countt>=880)
	  {

	  hc++;
	   }



	   o1.design();



	 }




	else if(i==1 && j==0)
	{
	 setfillstyle(1,na[i]);
	floodfill(196,208,BROWN);   //first 2 blocks
	floodfill(431,208,BROWN);
	 floodfill(143,368,BROWN);
	 floodfill(505,368,BROWN);

	 setfillstyle(1,na[j]);
	 floodfill(180,278,BROWN);
	 floodfill(472,278,BROWN);
	 floodfill(140,372,BROWN);
	 floodfill(505,372,BROWN);
	 i--;j++;
	}

 }





  else if(ch==75)                        //LEFT KEY
 {
 stopwatch();
 if(countt==820)
    opp=1;
    if(countt==690)
    opp2=1;

    o.cometlr(opp2);
    o.cometl(opp);
    o1.design();
    opp++;

    opp2++;

    if(countt==740||countt==640||countt==860)
    c=1;

    obbox.move(c,30);
    c++;





    if(c==19)      //RED
	  {

	    if(((o1.a>=320) && (o1.a<=420))||((o1.a+85>=320) && (o1.a+85<=420))) //150 220
	    {
	       c=9;

	       setfillstyle(1,8);
		setfillstyle(1,8);
		bar(320,350,395,400);
	       obbox.move(c,30);
	       countt-=10;
	    }
	  }





    if(opp==14 || opp==15)
    {
    if(((o1.a>=p)&&(o1.a<=p+85))||((o1.a+85>=p)&&(o1.a+85<=p+85)))
    {
    setfillstyle(1,8);
    bar(p,348,p+85,420);

    countt-=5;
    opp=9;
    setfillstyle(1,8);
    floodfill(290,478,BROWN);
    o.cometl(opp);
    }
    }






    if(opp2==14 || opp2==15)
    {
    if(((o1.a>=p)&&(o1.a<=p+85))||((o1.a+85>=p)&&(o1.a+85<=p+85)))
    {
    setfillstyle(1,8);
    bar(p,348,p+85,420);

    countt-=5;
    opp2=9;
    setfillstyle(1,8);
    floodfill(290,478,BROWN);
    o.cometlr(opp2);
    }
    }
 countt++;
 if(o1.a>=160)
 o1.a-=40;
  setfillstyle(1,8);
 floodfill(o1.a,o1.b,BROWN);




 o1.design();




 if(i==0 && j==1)
	{
	setfillstyle(1,na[i]);
	floodfill(196,208,BROWN);   //first 2 blocks
	floodfill(431,208,BROWN);
	 floodfill(143,368,BROWN);
	 floodfill(505,368,BROWN);

	 setfillstyle(1,na[j]);
	 floodfill(180,278,BROWN);
	 floodfill(472,278,BROWN);
	 floodfill(140,372,BROWN);
	 floodfill(505,372,BROWN);
	 i++;j--;
	  if(countt>=880)
	  {

	  hc++;
	   }


	   o1.design();


	 }





	else if(i==1 && j==0)
	{
	 setfillstyle(1,na[i]);
	floodfill(196,208,BROWN);   //first 2 blocks
	floodfill(431,208,BROWN);
	 floodfill(143,368,BROWN);
	 floodfill(505,368,BROWN);

	 setfillstyle(1,na[j]);
	 floodfill(180,278,BROWN);
	 floodfill(472,278,BROWN);
	 floodfill(140,372,BROWN);
	 floodfill(505,372,BROWN);
	 i--;j++;
	 }
 }





  else if(ch==27)             // ESC
  {
  mainmenu(p1,flag);
  }

 }
 }







 /*FOURTH PART: STRAIGHT TRACK */






 else if( countt>=900 && countt<1200)
  {
  setfillstyle(1,GREEN);
  bar(0,151,640,480);
  obstacle ob;
 // car o1;
 o1.a=265;
 o1.b=425;

  polyl[0]=20;       polyr[0]=600;       //co-ordinates of the tracks footpath
  polyl[1]=480;      polyr[1]=480;
  polyl[2]=40;       polyr[2]=620;
  polyl[3]=480;      polyr[3]=480;
  polyl[4]=275;      polyr[4]=370;
  polyl[5]=150;      polyr[5]=150;
  polyl[6]=270;      polyr[6]=365;
  polyl[7]=150;      polyr[7]=150;
  polyl[8]=20;       polyr[8]=600;
  polyl[9]=480;      polyr[9]=480;
  setcolor(BROWN);

  drawpoly(5,polyl);       //2 tracks
  drawpoly(5,polyr);

line(225,210,233,210);   //divider
line(408,210,416,210);
line(172,280,183,280);
line(457,280,468,280);
line(103,370,117,370);
line(523,370,538,370);


setfillstyle(1,8);           //ROAD
floodfill(340,152,BROWN);

o1.design();
stopwatch();

 while(countt<1200)
 {
  ch=getch();





  if(ch==72)                         //FORWARD KEY
  {
   stopwatch();
   if(countt==1020||countt==1080)
    opp=1;
    if(countt==960||countt==1140)
    opp1=1;

    o.comer(opp1);

    o.come(opp);
      o1.design();
    opp++;
    opp1++;


    if(countt==1110)
    c=1;
    else if(countt==1050)
    cl=1;

	 obbox.move(c,0);
	 c++;

	 obbox.movel(cl);
	 cl++;







	  if(c==19)      //RED
	  {
	    if((o1.a>=280 && o1.a<=370)||(o1.a+85>=280 && o1.a+85<=370)) //150 220
	    {
	       c=9;
	       setfillstyle(1,8);
		setfillstyle(1,8);
		bar(300,350,345,400);
	       obbox.move(c,0);
	       countt-=10;
	    }
	  }





	 if(cl==15)      //BLUE
	  {
	    if((o1.a>=130 && o1.a<=220)||(o1.a+85>=130 && o1.a+85<=220)) //150 220
	    {
	       cl=9;
	       obbox.movel(cl);
	       setfillstyle(1,8);
	       bar(150,340,230,490);
	       countt-=6;
	    }

	  }




    if(opp==14 || opp==15)
    {
    if(((o1.a>=p)&&(o1.a<=p+85))||((o1.a+85>=p)&&(o1.a+85<=p+85)))
    {
    setfillstyle(1,8);
    bar(p,348,p+85,420);

    countt-=5;
    opp=9;
    setfillstyle(1,8);
    floodfill(290,478,BROWN);
    o.come(opp);
    }
    }





    if(opp1==14 || opp1==15)
    {
    if(((o1.a>=p)&&(o1.a<=p+85))||((o1.a+85>=p)&&(o1.a+85<=p+85)))
    {
    setfillstyle(1,8);
    bar(p,348,p+85,420);

    countt-=5;
    opp1=9;
    setfillstyle(1,8);
    floodfill(290,478,BROWN);
    o.comer(opp1);
    }
    }




    if(opp==18)
    {
    setfillstyle(1,8);
    floodfill(290,478,BROWN);
    o1.design();
    }



    if(opp==17||opp1==17)
    {
    setfillstyle(1,8);
    floodfill(p,q,BROWN);
    o1.design();
    }


    countt++;




	if(i==0 && j==1)
	{
	setfillstyle(1,na[i]);
	floodfill(272,152,BROWN);   //first 2 blocks
	floodfill(367,152,BROWN);
	 floodfill(174,282,BROWN);
	 floodfill(460,282,BROWN);

	 setfillstyle(1,na[j]);
	 floodfill(175,278,BROWN);
	 floodfill(460,278,BROWN);
	 floodfill(40,475,BROWN);
	 floodfill(600,475,BROWN);
	 i++;j--;




	 o1.design();



	 }




	else if(i==1 && j==0)
	{
	 setfillstyle(1,na[i]);
	 floodfill(272,152,BROWN);   //first 2 blocks
	 floodfill(367,152,BROWN);
	 floodfill(174,282,BROWN);
	 floodfill(460,282,BROWN);

	 setfillstyle(1,na[j]);
	 floodfill(175,278,BROWN);  // next 2 blocks
	 floodfill(460,278,BROWN);
	 floodfill(40,475,BROWN);
	 floodfill(600,475,BROWN);
	 i--;j++;
	 }
  }





else if(ch==77)                      //RIGHT KEY
 {
 stopwatch();
if(countt==1020||countt==1080)
    opp=1;
    if(countt==960||countt==1140)
    opp1=1;
    o.comer(opp1);
    o.come(opp);
      o1.design();
    opp++;
    opp1++;


    if(countt==1110)
    c=1;
    else if(countt==1050)
    cl=1;

	 obbox.move(c,0);
	 c++;

	 obbox.movel(cl);
	 cl++;





	  if(c==19)      //RED
	  {
	    if((o1.a>=280 && o1.a<=370)||(o1.a+85>=280 && o1.a+85<=370)) //150 220
	    {
	       c=9;
	       setfillstyle(1,8);
		setfillstyle(1,8);
		bar(300,350,345,400);
		obbox.move(c,0);
		countt-=10;
	    }
	  }





	 if(cl==15)      //BLUE
	  {
	    if((o1.a>=130 && o1.a<=220)||(o1.a+85>=130 && o1.a+85<=220)) //150 220
	    {
	       cl=9;

	       obbox.movel(cl);
	       setfillstyle(1,8);
	       bar(150,340,230,490);
	       countt-=6;
	    }

	  }



    if(opp==14 || opp==15)
    {
    if(((o1.a>=p)&&(o1.a<=p+85))||((o1.a+85>=p)&&(o1.a+85<=p+85)))
    {
    setfillstyle(1,8);
    bar(p,348,p+85,420);

    countt-=5;
    opp=9;
    setfillstyle(1,8);
    floodfill(290,478,BROWN);
    o.come(opp);
    }
    }
    if(opp1==14 || opp1==15)
    {
    if(((o1.a>=p)&&(o1.a<=p+85))||((o1.a+85>=p)&&(o1.a+85<=p+85)))
    {
    setfillstyle(1,8);
    bar(p,348,p+85,420);

    countt-=5;
    opp1=9;
    setfillstyle(1,8);
    floodfill(290,478,BROWN);
    o.comer(opp1);
    }
    }





    if(opp==18)
    {
    setfillstyle(1,8);
    floodfill(290,478,BROWN);
    o1.design();
    }
    if(opp==17||opp1==17)
    {
    setfillstyle(1,8);
    floodfill(p,q,BROWN);
    o1.design();

    }
   countt++;



 if(o1.a<=400 )
 o1.a+=40;
  setfillstyle(1,8);
 floodfill(o1.a,o1.b,BROWN);




 o1.design();





 if(i==0 && j==1 )
 {
 setfillstyle(1,na[i]);
 floodfill(272,152,BROWN);                   //first 2 blocks
 floodfill(367,152,BROWN);
 floodfill(174,282,BROWN);
 floodfill(460,282,BROWN);
 setfillstyle(1,na[j]);

 floodfill(175,278,BROWN);
 floodfill(460,278,BROWN);
 floodfill(40,475,BROWN);
 floodfill(600,475,BROWN);
 i++;j--;
 setfillstyle(1,8);
 floodfill(o1.a,o1.b,BROWN);

 o1.design();
 }





 else if(i==1 && j==0)
 {
 setfillstyle(1,na[i]);
 floodfill(272,152,BROWN);              //first 2 blocks
 floodfill(367,152,BROWN);
 floodfill(174,282,BROWN);
 floodfill(460,282,BROWN);
 setfillstyle(1,na[j]);

 floodfill(175,278,BROWN);            // next 2 blocks
 floodfill(460,278,BROWN);
 floodfill(40,475,BROWN);
 floodfill(600,475,BROWN);
 i--;j++;

 }
 }





  else if(ch==75)                   //LEFT KEY
 {
  stopwatch();
if(countt==1020||countt==1080)
    opp=1;
    if(countt==960||countt==1140)
    opp1=1;
    o.comer(opp1);
    o.come(opp);
      o1.design();
    opp++;
    opp1++;


    if(countt==1110)
    c=1;
    else if(countt==1050)
    cl=1;

	 obbox.move(c,0);
	 c++;

	 obbox.movel(cl);
	 cl++;






	  if(c==19)      //RED
	  {
	    if((o1.a>=280 && o1.a<=370)||(o1.a+85>=280 && o1.a+85<=370)) //150 220
	    {
	       c=9;
	       setfillstyle(1,8);
		setfillstyle(1,8);
		bar(300,350,345,400);
	       obbox.move(c,0);
	       countt-=10;
	    }
	  }





	  if(cl==15)      //BLUE
	  {
	    if((o1.a>=130 && o1.a<=220)||(o1.a+85>=130 && o1.a+85<=220)) //150 220
	    {
	       cl=9;
	       obbox.movel(cl);
	       setfillstyle(1,8);
	       bar(150,340,230,490);
	       countt-=6;
	    }

	  }





    if(opp==14 || opp==15)
    {
    if(((o1.a>=p)&&(o1.a<=p+85))||((o1.a+85>=p)&&(o1.a+85<=p+85)))
    {
    setfillstyle(1,8);
    bar(p,348,p+85,420);

    countt-=5;
    opp=9;
    setfillstyle(1,8);
    floodfill(290,478,BROWN);
    o.come(opp);
    }
    }
    if(opp1==14 || opp1==15)
    {
    if(((o1.a>=p)&&(o1.a<=p+85))||((o1.a+85>=p)&&(o1.a+85<=p+85)))
    {
    setfillstyle(1,8);
    bar(p,348,p+85,420);

    countt-=5;
    opp1=9;
    setfillstyle(1,8);
    floodfill(290,478,BROWN);
    o.comer(opp1);
    }
    }



    if(opp==18)
    {
    setfillstyle(1,8);
    floodfill(290,478,BROWN);
    o1.design();
    }
    if(opp==17||opp1==17)
    {
    setfillstyle(1,8);
    floodfill(p,q,BROWN);
    o1.design();
    }
   countt++;




 if(o1.a>=150)
 o1.a-=40;
  setfillstyle(1,8);
 floodfill(o1.a,o1.b,BROWN);





 o1.design();





 if(i==0 && j==1 )
 {
 setfillstyle(1,na[i]);
 floodfill(272,152,BROWN);   //first 2 blocks
 floodfill(367,152,BROWN);
 floodfill(174,282,BROWN);
 floodfill(460,282,BROWN);
 setfillstyle(1,na[j]);

 floodfill(175,278,BROWN);
 floodfill(460,278,BROWN);
 floodfill(40,475,BROWN);
 floodfill(600,475,BROWN);
 i++;j--;
 setfillstyle(1,8);
 floodfill(o1.a,o1.b,BROWN);

 o1.design();
 }






 else if(i==1 && j==0)
 {
 setfillstyle(1,na[i]);
 floodfill(272,152,BROWN);   //first 2 blocks
 floodfill(367,152,BROWN);
 floodfill(174,282,BROWN);
 floodfill(460,282,BROWN);
 setfillstyle(1,na[j]);

 floodfill(175,278,BROWN);  // next 2 blocks
 floodfill(460,278,BROWN);
 floodfill(40,475,BROWN);
 floodfill(600,475,BROWN);
 i--;j++;

 }
 }





 else if(ch==27)             // ESC
  {
 mainmenu(p1,flag);
  }

 }




// TRACK COMPLETE




}


countt++;



}
if(countt>=1200)
 {
 flag=1;
 }




int naa[2];
naa[0]=0;
naa[1]=15;
int iii,jjj;
 setfillstyle(1,8);
 floodfill(290,400,BROWN);
 finish();
   setcolor(BROWN);
   line(182,280,460,280);
   line(225,220,415,220);


  jjj=1;
  for(iii=0;iii<7;iii++)
  {
   line(207+(iii*25),280,250+(iii*25),220);
   setfillstyle(1,na[jjj]);
   floodfill(194+(iii*25),278,BROWN);
   if(jjj==1)
   jjj=0;
   else if(jjj==0)
   jjj=1;
  }
  line(382,280,420,228.5);
  setfillstyle(1,0);
  floodfill(398,230,BROWN);
  line(407,280,437,242);
  setfillstyle(1,0);
  floodfill(411,278,BROWN);
  setfillstyle(1,15);
  floodfill(403,278,BROWN);


 ch=getch();
 o1.a=265;
 o1.b=410;
 int pre=0;




	     /*ZEBRA CROSSING*/




	     if(ch==72||ch==77||ch==75)
	     {
	       for(pre=0;pre<6;pre++)
	       {
	       setfillstyle(1,8);

		bar(o1.a-5,o1.b,o1.a+85,o1.b+60);
		o1.design();
		o1.b-=25;

		 delay(200);
	       }
	       }



while(1)
{
ch=getch();
if(ch==27)
mainmenu(p1,flag);
}



}

};




	   /* ********************************************* */