#include<iostream.h>
#include<graphics.h>
#include<conio.h>
#include"car.cpp"
int countt;
int p=290,q=175;
int r=290,s=175;
float w=1.6,v=1.6;
car o1;
class opponent
{
public:
void small()
{
setfillstyle(1,8);
 floodfill(p,q,BROWN);

setcolor(GREEN);

rectangle(p+24+w,q-30+v,r+30-w,s-16-v);     //front tyre left
rectangle(p+55-3*w,q-16-v,r+61-5*w,s-30+v);
setfillstyle(2,RED);				     //front tyre right
floodfill(p+25+w,q-29+v,GREEN);
floodfill(p+58.2-3*w,q-20+v,GREEN);
rectangle(p+w,q+v,r+15-w,s+30-v);            //back tyre left
floodfill(p+5+w,q+5+v,GREEN);
rectangle(p+70-3*w,q+v,r+85-5*w,s+30-v);         //back tyre right
floodfill(p+75-3*w,q+5+v,GREEN);
setcolor(RED);
rectangle(p+15-w,q-5+v,r+70-3*w,s+15-v);        //rear look
setfillstyle(1,YELLOW);
floodfill(p+25-w,q+5+v,RED);
setcolor(YELLOW);
setfillstyle(1,CYAN);
line(p+20-w,q-5-v,r+30-w,s-25+v);
line(p+65-3*w,q-5-v,r+55-3*w,s-25+v);
line(p+30-w,q-25+v,r+55-3*w,s-25+v);
line(p+20-w,q-5-v,r+65-3*w,s-5-v);
floodfill(p+22-w,q-6-v,YELLOW);
setcolor(RED);
line(p+20-w,q-5+v,r+65-3*w,s-5+v);
rectangle(p+20-w,q+v,r+27-3*w,s+7-v);         //rear light red
setfillstyle(1,RED);
floodfill(p+22-w,q+2+v,RED);
rectangle(p+58-w,q+v,r+65-3*w,s+7-v);       //rear light red
floodfill(p+59-w,q+2+v,RED);
rectangle(p+7-w,q-15-v/2,r+78-3*w,s-20+v/2);
setfillstyle(1,YELLOW);
floodfill(p+8+w,q-17-v,RED);
floodfill(p+35-w,q-17+v,RED);
floodfill(p+65-w,q-17+v,RED);


line(p+20-w,q+12+v/2,r+65-3*w,s+12+v/2);
line(p+20-w,q+9+v,r+65-3*w,s+9+v);
line(p+15-3*w,q-15,r+25-3*w,s-5);
line(p+20-3*w,q-15,r+30-3*w,s-5);
line(p+70-2*w,q-15,r+60-2*w,s-5);
line(p+55-3*w,q-5,r+65-3*w,s-15);
floodfill(p+22-w,q-10+v,RED);
floodfill(p+64-3*w,q-10+v,RED);
setcolor(BLACK);
rectangle(p+30-w,q+v,r+55-3*w,s+8-v);
setfillstyle(1,WHITE);
floodfill(p+32-w,q+1+v,BLACK);
}
void vsmall()
{
setfillstyle(1,8);
 floodfill(p,q,BROWN);

setcolor(GREEN);
setfillstyle(2,RED);				     //front tyre right
rectangle(p+w,q+v,r+15-w,s+30-v);            //back tyre left
floodfill(p+5+w,q+5+v,GREEN);
rectangle(p+70-3*w,q+v,r+85-5*w,s+30-v);         //back tyre right
floodfill(p+75-3*w,q+5+v,GREEN);
setcolor(RED);
rectangle(p+15-w,q-5+v,r+70-3*w,s+15-v);        //rear look
setfillstyle(1,YELLOW);
floodfill(p+25-w,q+5+v,RED);
setcolor(YELLOW);
setfillstyle(1,CYAN);
setcolor(RED);
line(p+20-w,q-5+v,r+65-3*w,s-5+v);
rectangle(p+20-w,q+v,r+27-3*w,s+7-v);         //rear light red
setfillstyle(1,RED);
floodfill(p+22-w,q+2+v,RED);
rectangle(p+58-w,q+v,r+65-3*w,s+7-v);       //rear light red
floodfill(p+59-w,q+2+v,RED);
rectangle(p+7-w,q-15-v/2,r+78-3*w,s-20+v/2);
setfillstyle(1,YELLOW);
floodfill(p+8+w,q-17-v,RED);
floodfill(p+35-w,q-17+v,RED);
line(p+20-w,q+12+v/2,r+65-3*w,s+12+v/2);
line(p+20-w,q+9+v,r+65-3*w,s+9+v);
line(p+15-3*w,q-15,r+25-3*w,s-5);
line(p+20-3*w,q-15,r+30-3*w,s-5);
line(p+70-2*w,q-15,r+60-2*w,s-5);
line(p+55-3*w,q-5,r+65-3*w,s-15);
floodfill(p+22-w,q-10+v,RED);
floodfill(p+64-3*w,q-10+v,RED);
setcolor(BLACK);
rectangle(p+30-w,q+v,r+55-3*w,s+8-v);
setfillstyle(1,WHITE);
floodfill(p+32-w,q+1+v,BLACK);
}

};

class obstacle1:public opponent
{
int i;
public:

void cometlr(int c);

void cometrl(int c);

void come(int c);

void comer(int c);

void comel(int c);

void cometr(int c);

void cometl(int c);
};



void obstacle1:: cometlr(int c)
{
switch(c)
{
case 1:
setfillstyle(1,8);
 floodfill(p,q,BROWN);
p=250;q=175;
r=250;s=175;
v=1.6;w=1.6;
vsmall();
break;

case 2:
 setfillstyle(1,8);
 setfillstyle(1,8);
 q+=8;
 s+=8;
 p+=5;
 r+=5;
 v=1.5;w=1.5;

 floodfill(p,q,BROWN);
 vsmall();
break;

case 3:
setfillstyle(1,8);
q+=10;
s+=10;
 p+=5;
 r+=5;
floodfill(p,q,BROWN);
v=1.4;w=1.4;
vsmall();
break;

case 4:
 setfillstyle(1,8);
q+=10;
s+=10;
 p+=5;
 r+=5;
floodfill(p,q,BROWN);
v=1.3;w=1.3;
vsmall();
break;

case 5:
setfillstyle(1,8);
q+=10;
s+=10;
 p+=5;
 r+=5;
floodfill(p,q,BROWN);
v=1.2;w=1.2;
small();
break;
case 6:
setfillstyle(1,8);
 floodfill(p,q,BROWN);
o1.design();
q+=15;
s+=15;
 p+=7;
 r+=7;
v=1.1;w=1.1;
small();

break;

case 7:
setfillstyle(1,8);
floodfill(p,q,BROWN);
o1.design();
q+=15;
s+=15;
 p+=7;
 r+=7;
v=1;w=1;
small();

break;
case 8:
 setfillstyle(1,8);
  floodfill(p,q,BROWN);
o1.design();
 q+=20;
s+=20;
 p+=7;
 r+=7;
 v=0.9;w=0.9;
small();
break;
case 9:
setfillstyle(1,8);
q=263;
s=263;
q+=20;
s+=20;
p=331;
r=331;
 p+=10;
 r+=10;
floodfill(p,q,BROWN);
o1.design();
v=0.8;w=0.8;
small();

break;
case 10:
 setfillstyle(1,8);
 q+=20;
s+=20;
 p+=10;
 r+=10;
floodfill(p,q,BROWN);
 o1.design();
 v=0.7;w=0.7;
small();

break;

case 11:
setfillstyle(1,8);
q+=25;
s+=25;
 p+=10;
 r+=10;
floodfill(290,400,BROWN);
o1.design();
v=0.6;w=0.6;
small();

break;
case 12:
setfillstyle(1,8);
q+=25;
s+=25;
 p+=10;
 r+=10;
floodfill(290,400,BROWN);
o1.design();
 v=0.5;w=0.5;
small();


 break;

case 13:
setfillstyle(1,8);
q+=25;
s+=25;
 p+=10;
 r+=10;
floodfill(290,400,BROWN);
o1.design();
v=0.4;w=0.4;
small();

break;
case 14:
 setfillstyle(1,8);
 q+=30;
s+=30;
 p+=12;
 r+=12;
floodfill(p,q,BROWN);
o1.design();

v=0.2;w=0.2;
small();

break;

case 15:
setfillstyle(1,8);
q+=30;
s+=30;
 p+=12;
 r+=12;
floodfill(290,400,BROWN);
o1.design();


v=0;w=0;
small();

break;
case 16:
 setfillstyle(1,8);
 q+=30;
s+=30;
 p+=12;
 r+=12;
floodfill(290,400,BROWN);
o1.design();

v=0;w=0;
small();

break;
}
}

void obstacle1:: comer(int c)
{
switch(c)
{
case 1:
setfillstyle(1,8);
 floodfill(p,q,BROWN);
p=290;q=175;
r=290;s=175;
v=1.6;w=1.6;

vsmall();

break;

case 2:
 setfillstyle(1,8);
 setfillstyle(1,8);
 q+=8;
 s+=8;
 p+=5;
 r+=5;
 v=1.5;w=1.5;

 floodfill(p,q,BROWN);
 vsmall();
break;

case 3:
setfillstyle(1,8);
q+=10;
s+=10;
 p+=5;
 r+=5;
floodfill(p,q,BROWN);
v=1.4;w=1.4;
vsmall();
break;

case 4:
 setfillstyle(1,8);
q+=10;
s+=10;
 p+=5;
 r+=5;
floodfill(p,q,BROWN);
v=1.3;w=1.3;
vsmall();
break;

case 5:
setfillstyle(1,8);
q+=10;
s+=10;
 p+=5;
 r+=5;
floodfill(p,q,BROWN);
v=1.2;w=1.2;
small();
break;
case 6:
setfillstyle(1,8);
 floodfill(p,q,BROWN);
o1.design();
q+=15;
s+=15;
 p+=7;
 r+=7;
v=1.1;w=1.1;
small();

break;

case 7:
setfillstyle(1,8);
floodfill(p,q,BROWN);
o1.design();
q+=15;
s+=15;
 p+=7;
 r+=7;
v=1;w=1;
small();

break;
case 8:
 setfillstyle(1,8);
  floodfill(p,q,BROWN);
o1.design();
 q+=20;
s+=20;
 p+=7;
 r+=7;
 v=0.9;w=0.9;
small();
break;
case 9:
setfillstyle(1,8);
q=263;
s=263;
q+=20;
s+=20;
p=331;
r=331;
 p+=10;
 r+=10;
floodfill(p,q,BROWN);
o1.design();
v=0.8;w=0.8;
small();

break;
case 10:
 setfillstyle(1,8);
 q+=20;
s+=20;
 p+=10;
 r+=10;
floodfill(p,q,BROWN);
 o1.design();
 v=0.7;w=0.7;
small();

break;

case 11:
setfillstyle(1,8);
q+=25;
s+=25;
 p+=10;
 r+=10;
floodfill(290,400,BROWN);
o1.design();
v=0.6;w=0.6;
small();

break;
case 12:
setfillstyle(1,8);
q+=25;
s+=25;
 p+=10;
 r+=10;
floodfill(290,400,BROWN);
o1.design();
 v=0.5;w=0.5;
small();


 break;

case 13:
setfillstyle(1,8);
q+=25;
s+=25;
 p+=10;
 r+=10;
floodfill(290,400,BROWN);
o1.design();
v=0.4;w=0.4;
small();

break;
case 14:
 setfillstyle(1,8);
 q+=30;
s+=30;
 p+=12;
 r+=12;
floodfill(p,q,BROWN);
o1.design();

v=0.2;w=0.2;
small();

break;

case 15:
setfillstyle(1,8);
q+=30;
s+=30;
 p+=12;
 r+=12;
floodfill(290,400,BROWN);
o1.design();


v=0;w=0;
small();

break;
case 16:
 setfillstyle(1,8);
 q+=30;
s+=30;
 p+=12;
 r+=12;
floodfill(290,400,BROWN);
o1.design();

v=0;w=0;
small();

break;
}
}


void obstacle1:: comel(int c)
{
switch(c)
{
case 1:
setfillstyle(1,8);
 floodfill(p,q,BROWN);
 o1.design();
//setfillstyle(1,RED);
p=290;q=175;
r=290;s=175;
v=1.6;w=1.6;

vsmall();

break;

case 2:
 setfillstyle(1,8);
 setfillstyle(1,8);
 q+=8;
 s+=8;
 p-=5;
 r-=5;
 v=1.5;w=1.5;

 floodfill(p,q,BROWN);
 vsmall();
break;

case 3:
setfillstyle(1,8);
q+=10;
s+=10;
 p-=5;
 r-=5;
floodfill(p,q,BROWN);
v=1.4;w=1.4;
vsmall();
break;

case 4:
 setfillstyle(1,8);
q+=10;
s+=10;
 p-=5;
 r-=5;
floodfill(p,q,BROWN);
v=1.3;w=1.3;
vsmall();
break;

case 5:
setfillstyle(1,8);
q+=10;
s+=10;
 p-=5;
 r-=5;
floodfill(p,q,BROWN);
v=1.2;w=1.2;
small();
break;
case 6:
setfillstyle(1,8);
 floodfill(p,q,BROWN);
 o1.design();
 q+=15;
s+=15;
 p-=7;
 r-=7;
v=1.1;w=1.1;
small();

break;

case 7:
setfillstyle(1,8);
floodfill(p,q,BROWN);
  o1.design();
q+=15;
s+=15;
 p-=7;
 r-=7;
v=1;w=1;
small();

break;
case 8:
 setfillstyle(1,8);
  floodfill(p,q,BROWN);
  o1.design();
 q+=20;
s+=20;
 p-=7;
 r-=7;
 v=0.9;w=0.9;
small();
break;
case 9:
setfillstyle(1,8);
q=263;
s=263;
q+=20;
s+=20;
p=249;
r=249;
 p-=10;
 r-=10;
floodfill(p,q,BROWN);
o1.design();
v=0.8;w=0.8;
small();

break;
case 10:
 setfillstyle(1,8);
 q+=20;
s+=20;
 p-=10;
 r-=10;
floodfill(p,q,BROWN);
 o1.design();
 v=0.7;w=0.7;
small();

break;

case 11:
setfillstyle(1,8);
q+=25;
s+=25;
 p-=10;
 r-=10;
floodfill(290,400,BROWN);
o1.design();
v=0.6;w=0.6;
small();

break;
case 12:
setfillstyle(1,8);
q+=25;
s+=25;
 p-=10;
 r-=10;
floodfill(290,400,BROWN);
o1.design();
 v=0.5;w=0.5;
small();


 break;

case 13:
setfillstyle(1,8);
q+=25;
s+=25;
 p-=10;
 r-=10;
floodfill(290,400,BROWN);
o1.design();
v=0.4;w=0.4;
small();

break;
case 14:
 setfillstyle(1,8);
 q+=30;
s+=30;
 p-=12;
 r-=12;
floodfill(p,q,BROWN);
o1.design();

v=0.2;w=0.2;
small();

break;

case 15:
setfillstyle(1,8);
q+=30;
s+=30;
 p-=12;
 r-=12;
floodfill(290,400,BROWN);
o1.design();


v=0;w=0;
small();

break;
case 16:
 setfillstyle(1,8);
 q+=30;
s+=30;
 p-=12;
 r-=12;
floodfill(290,400,BROWN);
o1.design();

v=0;w=0;
small();

break;
}
}


void obstacle1:: cometrl(int c)
{
switch(c)
{
case 1:
setfillstyle(1,8);
 floodfill(p,q,BROWN);
 o1.design();
p=350;q=175;
r=350;s=175;
v=1.6;w=1.6;

vsmall();

break;

case 2:
 setfillstyle(1,8);
 setfillstyle(1,8);
 q+=8;
 s+=8;
 p-=5;
 r-=5;
 v=1.5;w=1.5;

 floodfill(p+100,q,BROWN);
 vsmall();
break;

case 3:
setfillstyle(1,8);
q+=10;
s+=10;
 p-=5;
 r-=5;
floodfill(p,q,BROWN);
v=1.4;w=1.4;
vsmall();
break;

case 4:
 setfillstyle(1,8);
q+=10;
s+=10;
 p-=5;
 r-=5;
floodfill(p+100,q,BROWN);
v=1.3;w=1.3;
vsmall();
break;

case 5:
setfillstyle(1,8);
q+=10;
s+=10;
 p-=5;
 r-=5;
floodfill(p+100,q,BROWN);
v=1.2;w=1.2;
small();
break;
case 6:
setfillstyle(1,8);
 floodfill(p,q,BROWN);
 o1.design();
 q+=15;
s+=15;
 p-=7;
 r-=7;
v=1.1;w=1.1;
small();

break;

case 7:
setfillstyle(1,8);
floodfill(p+100,q,BROWN);
  o1.design();
q+=15;
s+=15;
 p-=7;
 r-=7;
v=1;w=1;
small();

break;
case 8:
 setfillstyle(1,8);
  floodfill(p+100,q,BROWN);
  o1.design();
 q+=20;
s+=20;
 p-=7;
 r-=7;
 v=0.9;w=0.9;
small();
break;
case 9:
setfillstyle(1,8);
q=263;
s=263;
q+=20;
s+=20;
p=249;
r=249;
 p-=10;
 r-=10;
floodfill(p+100,q,BROWN);
o1.design();
v=0.8;w=0.8;
small();

break;
case 10:
 setfillstyle(1,8);
 q+=20;
s+=20;
 p-=10;
 r-=10;
floodfill(p+100,q,BROWN);
 o1.design();
 v=0.7;w=0.7;
small();

break;

case 11:
setfillstyle(1,8);
q+=25;
s+=25;
 p-=10;
 r-=10;
floodfill(290,400,BROWN);
o1.design();
v=0.6;w=0.6;
small();

break;
case 12:
setfillstyle(1,8);
q+=25;
s+=25;
 p-=10;
 r-=10;
floodfill(290,400,BROWN);
o1.design();
 v=0.5;w=0.5;
small();


 break;

case 13:
setfillstyle(1,8);
q+=25;
s+=25;
 p-=10;
 r-=10;
floodfill(290,400,BROWN);
o1.design();
v=0.4;w=0.4;
small();

break;
case 14:
 setfillstyle(1,8);
 q+=30;
s+=30;
 p-=12;
 r-=12;
floodfill(p,q,BROWN);
o1.design();

v=0.2;w=0.2;
small();

break;

case 15:
setfillstyle
(1,8);
q+=30;
s+=30;
 p-=12;
 r-=12;
floodfill(290,400,BROWN);
o1.design();


v=0;w=0;
small();

break;
case 16:
 setfillstyle(1,8);
 q+=30;
s+=30;
 p-=12;
 r-=12;
floodfill(290,400,BROWN);
o1.design();

v=0;w=0;
small();

break;
}
}

void obstacle1:: come(int c)
{
switch(c)
{
case 1:
setfillstyle(1,8);
 floodfill(p,q,BROWN);
p=290;q=175;
r=290;s=175;
v=1.6;w=1.6;

vsmall();

break;

case 2:
 setfillstyle(1,8);
 setfillstyle(1,8);
 q+=8;
 s+=8;
 v=1.5;w=1.5;

 floodfill(p,q,BROWN);
 vsmall();
break;

case 3:
setfillstyle(1,8);
q+=10;
s+=10;
floodfill(p,q,BROWN);
v=1.4;w=1.4;
vsmall();
break;

case 4:
 setfillstyle(1,8);
q+=10;
s+=10;
floodfill(p,q,BROWN);
v=1.3;w=1.3;
vsmall();
break;

case 5:
setfillstyle(1,8);
q+=10;
s+=10;
floodfill(p,q,BROWN);
v=1.2;w=1.2;
small();
break;
case 6:
setfillstyle(1,8);
 floodfill(p,q,BROWN);
 o1.design();
 q+=15;
s+=15;
v=1.1;w=1.1;
small();

break;

case 7:
setfillstyle(1,8);
floodfill(p,q,BROWN);
 o1.design();
q+=15;
s+=15;
v=1;w=1;
small();

break;
case 8:
 setfillstyle(1,8);
  floodfill(p,q,BROWN);
 o1.design();
 q+=20;
s+=20;
 v=0.9;w=0.9;
small();
break;
case 9:
setfillstyle(1,8);
q=263;
s=263;
q+=30;
s+=30;
shift:
floodfill(p,q,BROWN);
o1.design();
v=0.8;w=0.8;
small();

break;
case 10:
 setfillstyle(1,8);
 q+=20;
s+=20;
floodfill(p,q,BROWN);

o1.design();
 v=0.7;w=0.7;
small();

break;

case 11:
setfillstyle(1,8);
q+=25;
s+=25;
floodfill(290,400,BROWN);
o1.design();
v=0.6;w=0.6;
small();

break;
case 12:
setfillstyle(1,8);
q+=25;
s+=25;
floodfill(290,400,BROWN);
o1.design();
 v=0.5;w=0.5;
small();


 break;

case 13:
setfillstyle(1,8);
q+=25;
s+=25;
floodfill(290,400,BROWN);
o1.design();
v=0.4;w=0.4;
small();

break;
case 14:
 setfillstyle(1,8);
 q+=30;
s+=30;
floodfill(p,q,BROWN);
o1.design();

v=0.2;w=0.2;
small();

break;

case 15:
setfillstyle(1,8);
q+=30;
s+=30;
floodfill(290,400,BROWN);
o1.design();


v=0;w=0;
small();

break;
case 16:
 setfillstyle(1,8);
q+=30;
s+=30;
floodfill(290,400,BROWN);
o1.design();

v=0;w=0;
small();

break;
}
}


void obstacle1:: cometr(int c)
{
switch(c)
{
case 1:
setfillstyle(1,8);
 floodfill(p,q,BROWN);
p=350;q=175;
r=350;s=175;
v=1.6;w=1.6;

vsmall();

break;

case 2:
 setfillstyle(1,8);
setfillstyle(1,8);
 q+=8;
 s+=8;
 v=1.5;w=1.5;

 floodfill(p,q,BROWN);
 vsmall();
break;

case 3:
setfillstyle(1,8);
q+=10;
s+=10;
floodfill(p,q,BROWN);
v=1.4;w=1.4;
vsmall();
break;

case 4:
 setfillstyle(1,8);
q+=10;
s+=10;
floodfill(p,q,BROWN);
v=1.3;w=1.3;
vsmall();
break;

case 5:
setfillstyle(1,8);
q+=10;
s+=10;
floodfill(p,q,BROWN);
v=1.2;w=1.2;
small();
break;
case 6:
setfillstyle(1,8);
 floodfill(p,q,BROWN);
 o1.design();
 q+=15;
s+=15;
v=1.1;w=1.1;
small();

break;

case 7:
setfillstyle(1,8);
floodfill(p,q,BROWN);
 o1.design();
q+=15;
s+=15;
v=1;w=1;
small();

break;
case 8:
 setfillstyle(1,8);
  floodfill(p,q,BROWN);
 o1.design();
 q+=20;
s+=20;
 v=0.9;w=0.9;
small();
break;
case 9:
setfillstyle(1,8);
q=263;
s=263;
q+=30;
s+=30;
shift:
floodfill(p,q,BROWN);
o1.design();
v=0.8;w=0.8;
small();

break;
case 10:
 setfillstyle(1,8);
 q+=20;
s+=20;
floodfill(p,q,BROWN);

o1.design();
 v=0.7;w=0.7;
small();

break;

case 11:
setfillstyle(1,8);
q+=25;
s+=25;
floodfill(290,400,BROWN);
o1.design();
v=0.6;w=0.6;
small();

break;
case 12:
setfillstyle(1,8);
q+=25;
s+=25;
floodfill(290,400,BROWN);
o1.design();
 v=0.5;w=0.5;
small();


 break;

case 13:
setfillstyle(1,8);
q+=25;
s+=25;
floodfill(290,400,BROWN);
o1.design();
v=0.4;w=0.4;
small();

break;
case 14:
 setfillstyle(1,8);
 q+=30;
s+=30;
floodfill(p,q,BROWN);
o1.design();

v=0.2;w=0.2;
small();

break;

case 15:
setfillstyle(1,8);
q+=30;
s+=30;
floodfill(290,400,BROWN);
o1.design();


v=0;w=0;
small();

break;
case 16:
 setfillstyle(1,8);
 q+=30;
s+=30;
floodfill(290,400,BROWN);
o1.design();

v=0;w=0;
small();

break;
}
}

void obstacle1:: cometl(int c)
{
switch(c)
{
case 1:
setfillstyle(1,8);
 floodfill(p,q,BROWN);
p=250;q=175;
r=250;s=175;
v=1.6;w=1.6;

vsmall();
break;

case 2:
 setfillstyle(1,8);
 setfillstyle(1,8);
 q+=8;
 s+=8;
 v=1.5;w=1.5;
 floodfill(p,q,BROWN);
 vsmall();
break;

case 3:
setfillstyle(1,8);
q+=10;
s+=10;
floodfill(p,q,BROWN);
v=1.4;w=1.4;
vsmall();
break;

case 4:
 setfillstyle(1,8);
q+=10;
s+=10;
floodfill(p,q,BROWN);
v=1.3;w=1.3;
vsmall();
break;

case 5:
setfillstyle(1,8);
q+=10;
s+=10;
floodfill(p,q,BROWN);
v=1.2;w=1.2;
small();
break;
case 6:
setfillstyle(1,8);
 floodfill(p,q,BROWN);
 o1.design();
 q+=15;
s+=15;
v=1.1;w=1.1;
small();

break;

case 7:
setfillstyle(1,8);
floodfill(p,q,BROWN);
 o1.design();
q+=15;
s+=15;
v=1;w=1;
small();

break;
case 8:
 setfillstyle(1,8);
  floodfill(p,q,BROWN);
 o1.design();
 q+=20;
s+=20;
 v=0.9;w=0.9;
small();
break;
case 9:
setfillstyle(1,8);
q=263;
s=263;
q+=30;
s+=30;
shift:
floodfill(p,q,BROWN);
o1.design();
v=0.8;w=0.8;
small();

break;
case 10:
 setfillstyle(1,8);
 q+=20;
s+=20;
floodfill(p,q,BROWN);

o1.design();
 v=0.7;w=0.7;
small();

break;

case 11:
setfillstyle(1,8);
q+=25;
s+=25;
floodfill(290,400,BROWN);
o1.design();
v=0.6;w=0.6;
small();

break;
case 12:
setfillstyle(1,8);
q+=25;
s+=25;
floodfill(290,400,BROWN);
o1.design();
 v=0.5;w=0.5;
small();


 break;

case 13:
setfillstyle(1,8);
q+=25;
s+=25;
floodfill(290,400,BROWN);
o1.design();
v=0.4;w=0.4;
small();

break;
case 14:
 setfillstyle(1,8);
 q+=30;
s+=30;
floodfill(p,q,BROWN);
o1.design();

v=0.2;w=0.2;
small();

break;

case 15:
setfillstyle(1,8);
q+=30;
s+=30;
floodfill(290,400,BROWN);
o1.design();


v=0;w=0;
small();

break;
case 16:
 setfillstyle(1,8);
 q+=30;
s+=30;
floodfill(290,400,BROWN);
o1.design();

v=0;w=0;
small();

break;
}
}
