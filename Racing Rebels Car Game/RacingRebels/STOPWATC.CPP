#include <graphics.h>
#include <time.h>
#include <conio.h>
#include<string.h>


void stopwatch(void)
{  //int gd=DETECT,gm;
   //initgraph(&gd,&gm,"..//bgi");
   time_t t;
    int i,j;
   //while(1)
   //{
   //cleardevice();
   //setcolor(GREEN);
   setfillstyle(10,BLUE);
   bar(240,75,400,102);
   time(&t);
   char na[20],m[10];
   strcpy(na,ctime(&t));
   for(i=11,j=0;i<=18;i++,j++)
   {
   m[j]=na[i];
   }
   m[j]='\0';
   setcolor(WHITE);
   settextstyle(10,0,1);
   outtextxy(250,65,m);
   getch();
   //}
   //return 0;
   //getch();
}

