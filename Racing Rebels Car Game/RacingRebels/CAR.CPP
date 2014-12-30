#include<iostream.h>
#include<graphics.h>
#include<conio.h>

//int a=265;
//int b=425;

class car
{
public:
int a,b;

car();

/*POLYMORPHISM AND FUNCTION OVERLOADING*/


void design();

void design(int c)
{
setcolor(GREEN);

rectangle(a+24,b-30,a+30,b-16);     //front tyre left
rectangle(a+55,b-16,a+61,b-30);
setfillstyle(2,BLUE);				     //front tyre right
floodfill(a+25,b-29,GREEN);
floodfill(a+56,b-19,GREEN);
rectangle(a,b,a+15,b+30);            //back tyre left
floodfill(a+5,b+5,GREEN);
rectangle(a+70,b,a+85,b+30);         //back tyre right
floodfill(a+75,b+5,GREEN);
setcolor(RED);
rectangle(a+15,b-5,a+70,b+15);        //rear look
setfillstyle(1,YELLOW);
floodfill(a+25,b+5,RED);
setcolor(YELLOW);
setfillstyle(1,LIGHTRED);
line(a+20,b-5,a+30,b-25);
line(a+65,b-5,a+55,b-25);
line(a+30,b-25,a+55,b-25);
line(a+20,b-5,a+65,b-5);
floodfill(a+22,b-6,YELLOW);
setcolor(RED);
line(a+20,b-5,a+65,b-5);
rectangle(a+20,b,a+27,b+7);         //rear light red
setfillstyle(1,RED);
floodfill(a+22,b+2,RED);
rectangle(a+58,b,a+65,b+7);       //rear light red
floodfill(a+59,b+2,RED);
rectangle(a+7,b-15,a+78,b-20);
setfillstyle(1,YELLOW);
floodfill(a+8,b-17,RED);
floodfill(a+35,b-17,RED);
floodfill(a+65,b-17,RED);


line(a+20,b+12,a+65,b+12);
line(a+20,b+9,a+65,b+9);
line(a+15,b-15,a+25,b-5);
line(a+20,b-15,a+30,b-5);
line(a+70,b-15,a+60,b-5);
line(a+65,b-15,a+55,b-5);
floodfill(a+22,b-10,RED);
floodfill(a+64,b-10,RED);
setcolor(BLACK);
rectangle(a+30,b,a+55,b+8);
setfillstyle(1,WHITE);
floodfill(a+32,b+1,BLACK);

}


//void design(int c);

};



car:: car()
{
 a=265;
 b=425;
}


void car:: design()
{
setcolor(GREEN);

rectangle(a+24,b-30,a+30,b-16);     //front tyre left
rectangle(a+55,b-16,a+61,b-30);
setfillstyle(2,BLUE);				     //front tyre right
floodfill(a+25,b-29,GREEN);
floodfill(a+56,b-19,GREEN);
rectangle(a,b,a+15,b+30);            //back tyre left
floodfill(a+5,b+5,GREEN);
rectangle(a+70,b,a+85,b+30);         //back tyre right
floodfill(a+75,b+5,GREEN);
setcolor(RED);
rectangle(a+15,b-5,a+70,b+15);        //rear look
setfillstyle(1,YELLOW);
floodfill(a+25,b+5,RED);
setcolor(YELLOW);
setfillstyle(1,LIGHTRED);
line(a+20,b-5,a+30,b-25);
line(a+65,b-5,a+55,b-25);
line(a+30,b-25,a+55,b-25);
line(a+20,b-5,a+65,b-5);
floodfill(a+22,b-6,YELLOW);
setcolor(RED);
line(a+20,b-5,a+65,b-5);
rectangle(a+20,b,a+27,b+7);         //rear light red
setfillstyle(1,RED);
floodfill(a+22,b+2,RED);
rectangle(a+58,b,a+65,b+7);       //rear light red
floodfill(a+59,b+2,RED);
rectangle(a+7,b-15,a+78,b-20);
setfillstyle(1,YELLOW);
floodfill(a+8,b-17,RED);
floodfill(a+35,b-17,RED);
floodfill(a+65,b-17,RED);


line(a+20,b+12,a+65,b+12);
line(a+20,b+9,a+65,b+9);
line(a+15,b-15,a+25,b-5);
line(a+20,b-15,a+30,b-5);
line(a+70,b-15,a+60,b-5);
line(a+65,b-15,a+55,b-5);
floodfill(a+22,b-10,RED);
floodfill(a+64,b-10,RED);
setcolor(BLACK);
rectangle(a+30,b,a+55,b+8);
setfillstyle(1,WHITE);
floodfill(a+32,b+1,BLACK);
}