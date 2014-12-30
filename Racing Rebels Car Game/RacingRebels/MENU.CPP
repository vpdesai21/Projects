#include<iostream.h>
#include<graphics.h>
#include<conio.h>
#include<stdlib.h>
#include<dos.h>
#include"profile2.cpp"


void menu()
{

cleardevice();
setcolor(BROWN);
rectangle(1,1,639,479);

setcolor(CYAN);
line(40+25,89,65+25,89);
line(32+25,101,62+25,101);
line(24+25,117,59+25,117);
line(16+25,133,56+25,133);
line(8+25,155,53+25,155);
line(2+25,174,47+25,174);
line(40+25,89+150,65+25,89+150);
line(32+25,101+150,62+25,101+150);
line(24+25,117+150,59+25,117+150);
line(16+25,133+150,56+25,133+150);
line(8+25,155+150,53+25,155+150);
line(2+25,174+150,47+25,174+150);







//first page





setcolor(BLUE);
settextstyle(7,0,75)   ;
outtextxy(75,50,"RACING");
outtextxy(75,200,"REBELS");
ch=getch();

setcolor(GREEN);
settextstyle(3,0,5);
outtextxy(50,400,"PRESS ENTER TO CONTINUE...");
ch=getch();





//second page





cleardevice();
setcolor(BROWN);
rectangle(1,1,639,479);

settextstyle(1,0,8);
setcolor(RED);
outtextxy(50,25,"INSTRUCTIONS");
settextstyle(3,0,4);
setcolor(WHITE);
outtextxy(15,140,"UP ARROW-ACCELERATE")  ;
outtextxy(15,180,"LEFT ARROW-TURN LEFT")  ;
outtextxy(15,220,"RIGHT ARROW-TURN RIGHT") ;
outtextxy(15,260,"COMPLETE LAP IN TIME LESS THAN YOUR OPPONENTS") ;
outtextxy(15,300,"THERE ARE 13 OPPONENTS");
outtextxy(15,380,"ESC TO GO TO MAIN MENU");

ch=getch();

setcolor(GREEN);
settextstyle(3,0,5);
outtextxy(50,400,"PRESS ENTER TO CONTINUE...");
ch=getch();

profile();
getch();
}

