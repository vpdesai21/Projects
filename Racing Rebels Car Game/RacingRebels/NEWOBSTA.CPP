#include<iostream.h>
#include<graphics.h>
#include<conio.h>
#include<dos.h>





/*CLASS HAVING BOX HORDING & COUNTDOWN*/




class obstacle
{
int i;
public:

void movel(int c);

void hordingr(int c);

void hordingl(int c);

void countdown1();

void countdown2();

void countdown3();

void movear_l(int c);
};




/*FUNCTION OF OBSTACLE*/




void obstacle:: hordingl(int c)
{
 switch(c)
 {
  case 1:
  setcolor(BLACK);                      	//board
  setfillstyle(1,15);
  bar3d(30,200,130,250,10/4,1);

  setfillstyle(1,BLACK);                 //standies
  bar3d(50,250,60,275,10/4,0);
  bar3d(100,250,110,275,10/4,0);

  setfillstyle(1,BLACK);                 //arrow
  bar(70,217.5,105,233.5);
  line(69,210,69,240);
  line(69,210,50,225);
  line(69,240,50,225);
  floodfill(63,225,BLACK);
  break;

  case 21:
  setfillstyle(1,GREEN);
  bar(30,218,140,275);
  break;
 }

}






void obstacle:: countdown3()
{
settextstyle(10,0,10);
setcolor(CYAN);
outtextxy(280,140,"3");
setfillstyle(1,RED);
floodfill(335,230,CYAN);
setcolor(BROWN);
delay(1000);
}




void obstacle:: countdown2()
{
setfillstyle(1,8);
bar(275,200,390,390);
settextstyle(10,0,10);
setcolor(CYAN);
outtextxy(280,140,"2");
setfillstyle(1,YELLOW);
floodfill(335,230,CYAN);
setcolor(BROWN);
delay(1000);
}




void obstacle:: countdown1()
{
setfillstyle(1,8);
bar(275,200,390,390);
settextstyle(10,0,10);
setcolor(CYAN);
outtextxy(280,140,"1");
setfillstyle(1,GREEN);
floodfill(335,230,CYAN);
setcolor(BROWN);
delay(1000);
setfillstyle(1,8);
bar(275,200,390,400);
}







void obstacle:: movear_l(int c)
{
switch(c)
{
case 1:
setfillstyle(1,RED);
bar3d(350,155,362,165,10/4,0);
break;

case 2:
setfillstyle(1,RED);
bar3d(350,155,362,165,10/4,0);
break;

case 3:
 setfillstyle(1,8);
 bar(350,152,365,165);
 setfillstyle(1,RED);
 bar3d(345,175,360,190,15/4,0);
break;

case 4:
 setfillstyle(1,8);
 bar(278,152,305,165);
 setfillstyle(1,RED);
 bar3d(265,175,290,190,15/4,0);
break;

case 5:
 setfillstyle(1,8);
  bar(265,170,295,190);
 setfillstyle(1,RED);
 bar3d(250,200,280,220,20/4,0);
break;

case 6:
 setfillstyle(1,8);
  bar(265,170,295,190);
 setfillstyle(1,RED);
 bar3d(250,200,280,220,20/4,0);
break;

case 7:
setfillstyle(1,8);
 bar(250,194,286,220);
setfillstyle(1,RED);
bar3d(235,230,270,255,25/4,0);
break;

case 8:
setfillstyle(1,8);
 bar(250,194,286,220);
setfillstyle(1,RED);
bar3d(235,230,270,255,25/4,0);
break;

case 9:
 setfillstyle(1,8);
 bar(235,223,277,255);
setfillstyle(1,RED);
bar3d(210,265,255,295,30/4,0);
break;

case 10:
 setfillstyle(1,8);
 bar(235,223,277,255);
setfillstyle(1,RED);
bar3d(210,265,255,295,30/4,0);
break;

case 11:
 setfillstyle(1,8);
 bar(210,257,263,295);
setfillstyle(1,RED);
bar3d(185,305,240,340,35/4,0);
break;

case 12:
 setfillstyle(1,8);
 bar(210,257,263,295);
setfillstyle(1,RED);
bar3d(185,305,240,340,35/4,0);
break;

case 13:
setfillstyle(1,8);
 bar(185,296,249,340);
setfillstyle(1,RED);
bar3d(150,350,220,390,40/4,0);
break;

case 14:
setfillstyle(1,8);
 bar(185,296,249,340);
setfillstyle(1,RED);
bar3d(150,350,220,390,40/4,0);
break;

case 15:
 setfillstyle(1,8);
 bar(150,340,230,390);
setfillstyle(1,RED);
bar3d(120,410,200,455,45/4,0);
break;

case 16:
 setfillstyle(1,8);
 bar(150,340,230,390);
setfillstyle(1,RED);
bar3d(120,410,200,455,45/4,0);
break;

case 17:
 setfillstyle(1,8);
 bar(120,399,212,455);
break;
}
}






void obstacle:: movel(int c)
{
switch(c)
{
case 1:
setfillstyle(1,RED);bar3d(280,155,300,165,10/4,0);
break;

case 2:
setfillstyle(1,RED);
bar3d(280,155,300,165,10/4,0);
break;

case 3:
 setfillstyle(1,8);
 bar(278,152,305,165);
 setfillstyle(1,RED);
 bar3d(265,175,290,190,15/4,0);
break;

case 4:
 setfillstyle(1,8);
 bar(278,152,305,165);
 setfillstyle(1,RED);
 bar3d(265,175,290,190,15/4,0);
break;

case 5:
 setfillstyle(1,8);
  bar(265,170,295,190);
 setfillstyle(1,RED);
 bar3d(250,200,280,220,20/4,0);
break;

case 6:
 setfillstyle(1,8);
  bar(265,170,295,190);
 setfillstyle(1,RED);
 bar3d(250,200,280,220,20/4,0);
break;

case 7:
setfillstyle(1,8);
 bar(250,194,286,220);
setfillstyle(1,RED);
bar3d(235,230,270,255,25/4,0);
break;

case 8:
setfillstyle(1,8);
 bar(250,194,286,220);
setfillstyle(1,RED);
bar3d(235,230,270,255,25/4,0);
break;

case 9:
 setfillstyle(1,8);
 bar(235,223,277,255);
setfillstyle(1,RED);
bar3d(210,265,255,295,30/4,0);
break;

case 10:
 setfillstyle(1,8);
 bar(235,223,277,255);
setfillstyle(1,RED);
bar3d(210,265,255,295,30/4,0);
break;

case 11:
 setfillstyle(1,8);
 bar(210,257,263,295);
setfillstyle(1,RED);
bar3d(185,305,240,340,35/4,0);
break;

case 12:
 setfillstyle(1,8);
 bar(210,257,263,295);
setfillstyle(1,RED);
bar3d(185,305,240,340,35/4,0);
break;

case 13:
setfillstyle(1,8);
 bar(185,296,249,340);
setfillstyle(1,RED);
bar3d(150,350,220,390,40/4,0);
break;

case 14:
setfillstyle(1,8);
 bar(185,296,249,340);
setfillstyle(1,RED);
bar3d(150,350,220,390,40/4,0);
break;

case 15:
 setfillstyle(1,8);
 bar(150,340,230,390);
setfillstyle(1,RED);
bar3d(120,410,200,455,45/4,0);
break;

case 16:
 setfillstyle(1,8);
 bar(150,340,230,390);
setfillstyle(1,RED);
bar3d(120,410,200,455,45/4,0);
break;

case 17:
 setfillstyle(1,8);
 bar(119,399,212,457);
break;

case 18:
 setfillstyle(1,8);
 bar(120,399,212,455);
break;

}
}





void obstacle:: hordingr(int c)
{
 switch(c)
 {
  case 1:
  setcolor(BLACK);	//board
  setfillstyle(1,15);
  bar3d(30,200,130,250,10/4,1);

  setfillstyle(1,BLACK);           //standies
  bar3d(50,250,60,275,10/4,0);
  bar3d(100,250,110,275,10/4,0);

  setfillstyle(1,BLACK);        //arrow
  bar(60,217.5,95,232.5);
  line(96,210,96,240);
  line(96,210,110,225);
  line(96,240,110,225);
  floodfill(105,225,BLACK);
  break;

  case 21:
  setfillstyle(1,GREEN);
  bar(30,218,140,275);
  break;
 }

}
