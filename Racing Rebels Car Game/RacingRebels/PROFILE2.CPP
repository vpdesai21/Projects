#include<graphics.h>
#include<iostream.h>
#include<string.h>
#include<conio.h>
#include<stdio.h>
#include<stdlib.h>
#include<fstream.h>
#include"ttrack.cpp"
class prof
{

public:
char na[15];
char ti[9];
char no[2];


public:
prof();

prof(prof &p1);

void input();

char * getna()
{
return na;
}


friend void write(prof);
friend void read(int);
friend int compare(prof &);
friend int total();
};        //prof class ends//



void prof:: input()
{
int i;
fstream fp;
fp.open("DATA.TXT",ios::in | ios::out | ios::app);
	setcolor(RED);
	settextstyle(10,0,1);
	outtextxy(400,15,"PROFILE");	//heading
	outtextxy(380,40,"--------");

	settextstyle(2,0,5);
	outtextxy(300,95,"1.PROFILE NAME :");   //1st input
	setcolor(WHITE);


	gotoxy(56,7);
	cin.width(80);
	for(i=0;i<15;i++)
	{
	na[i]='\0';
	}

	cin>>na;
	fp<<na;
	//fp<<'\n';
	fp.close();
}


prof::prof(prof &p1)
{

int i;
for(i=0;i<15;i++)
{
na[i]='\0';
}
for(i=0;i<9;i++)
{
ti[i]='\0';
}
for(i=0;i<2;i++)
{
no[i]='\0';
}


strcpy(na,p1.na);
strcpy(ti,p1.ti);
strcpy(no,p1.no);
}


prof::prof()
{
int i;
for(i=0;i<15;i++)
{
na[i]='\0';
}
for(i=0;i<9;i++)
{
ti[i]='\0';
}
for(i=0;i<2;i++)
{
no[i]='\0';
}
}



prof p1;

void write(prof p1)
{
prof p(p1);
fstream fp;
fp.open("SCORECARD.TXT",ios::in | ios::out | ios::app);
fp.write((char*)&p,sizeof(p));
fp.close();
}

int total(prof p)                           //total numbers of users
{
fstream fp;
fp.open("SCORECARD.TXT",ios::in);
int no=0,num=0;
fp.seekg(0,ios::beg);

while(fp)
{
fp.read((char*)&p,sizeof(char));
num++;
if(num%27==0)
no++;
}
fp.close();
return(no-1);


}




				    //scorecard
void read(int x)
{
int i;
fstream f;
f.open("SCORECARD.TXT",ios:: in);

cleardevice();
setcolor(GREEN);
settextstyle(10,1,5);
outtextxy(0,10,"SCORE-CARD");
setcolor(BROWN);
rectangle(90,10,620,460);

prof pu;
int number=100;
int j;
if(x<4)
{
i=1;
while(i<=x+2)
{
++i;
f.read((char*)&pu,sizeof(pu));
setcolor(RED);
settextstyle(3,0,4);
outtextxy(100,number+i*15,pu.na);
outtextxy(290,number+i*15,pu.ti);
outtextxy(550,number+i*15,pu.no);
number=number+20;
}
}
else if(x>=4)
{
for(i=5,j=0;i>0,j<5;i--,j++)
{
f.seekg((x+2-i)*(sizeof(pu)),ios::beg);

f.read((char*)&pu,sizeof(pu));

setcolor(RED);
settextstyle(3,0,4);
outtextxy(100,number+j*15,pu.na);
outtextxy(290,number+j*15,pu.ti);
outtextxy(550,number+j*15,pu.no);
number=number+20;
}
}
f.close();
}





//mainmenu final//

char m[2][20]={"START GAME","EXIT GAME"};
int i,rr,ch,br=55,ele=0;
int c;
int ccc;



void mainmenu(prof p1,int std)
{

  int i,j;
  char xyz,mm[2];

cleardevice();


while(ch!=27)
{

cleardevice();

setcolor(BROWN);
rectangle(1,1,639,479);


car v1;
v1.design();


settextstyle(3,0,20);
setcolor(GREEN);
rectangle(200,br,400,br+30);
setcolor(BLUE);
for(i=0,rr=50;i<2;i++,rr+=30)
{
setcolor(RED);
settextstyle(9,0,3);

//names
outtextxy(20,320,"CREDITS:");
line(20,368,180,368);
settextstyle(6,0,3);
outtextxy(20,370,"ANIKET BHARATI");
outtextxy(20,390,"SAUMIL PANDYA");
outtextxy(20,410,"SOHAM VAGHELA");
outtextxy(20,430,"VISHWA DESAI");

//LOGO
circle(600,440,33);
settextstyle(5,0,1);
outtextxy(570,425,"A.S.S.V");
settextstyle(3,0,4);
outtextxy(210,rr,m[i]);
}
//ch=getch();
ch=getch();
switch(ch)
{

case 72: if(br>=85)
	{br=br-30;ele--;}
	else
	{br=85;ele=20;}
	break;
case 80: if(br<=55)
	{
	br=br+30;
	ele--;
	}
	else
	{
	br=55;
	ele=0;
	}
	break;
case 13: if(br==55)              //case13 starts
	{
		ccc++;
		cleardevice();
		i=0;
		settextstyle(9,0,3);               //loading..
			for(c=101;c<=499;c++)
			{
			setcolor(3);
			rectangle(100,100,500,130);
			setfillstyle(1,CYAN);
			bar(101,101,c,129);
			settextstyle(8,0,10);
			setcolor(RED);
			outtextxy(10,230,"LOADING..");

				if(c%45==0)
				{
				setfillstyle(1,BLACK);
				bar(220,150,250,180);
				i++;
				}
				delay(10);
			}                        //loading ends
			cleardevice();
			track tt;
			tt.levelcenter();




	getch();

	}
	else if(br==85)
	{
	time_t t;
	char na[20],m[9];

	time(&t);
	strcpy(na,ctime(&t));
	for(i=11,j=0;i<=18;i++,j++)
	{
	m[j]=na[i];
	}
	m[j]='\0';

	strcpy(p1.ti,m);
	itoa(ccc,mm,2);

	strcpy(p1.no,mm);

	if(std==1)
	{write(p1);}

	int p=total(p1);
	read(p);
	getch();

	exit(0);
	}
	break;

}

}

}




int compare(prof &p1)
{
     char una[10];



		setcolor(RED);
		settextstyle(10,0,1);
		outtextxy(400,15,"PROFILE");	//heading
		outtextxy(380,40,"--------");

		settextstyle(2,0,5);
		outtextxy(300,95,"1.PROFILE NAME :");   //1st input
		setcolor(WHITE);

		gotoxy(56,7);
		cin.width(80);
		cin>>una;

		getch();

prof p(p1);

fstream f;

f.open("DATA.TXT",ios::out | ios::in );


char temp[10];
while(f)
{

	if(strcmp(una,p.na)==0)
	{
	mainmenu(p1,1);
	   return 0;

	}
	else
	{

	settextstyle(3,0,2);
	outtextxy(300,150,"PLEASE ENTER AGAIN...");
	outtextxy(300,200,"NO SUCH PROFILE FOUND...");
	getch();
	return 1;
	}
}
f.close();
return 0;
}


//layout of profile page --profile function//


char n[3][30]={"CREATE PROFILE","LOGIN PROFILE","DELETE "};
int b=11;

void profile()
{

while(ch!=27)
{
cleardevice();
setcolor(LIGHTGREEN);
rectangle(10,10,275,470);
rectangle(290,10,630,470);
setfillstyle(1,BLUE);
bar(11,b,274,b+30);

for(i=0,rr=6;i<3;i++,rr+=30)
{



setcolor(RED);
settextstyle(3,0,4);
outtextxy(15,rr,n[i]);
}

vi:
ch=getch();
switch(ch)
{

case 72: if(b>=41)
	{b=b-30;ele--;}
	else
	{b=71;ele=2;}
	break;
case 80: if(b<=41)
	{
	b=b+30;
	ele++;
	}
	else
	{
	b=11;
	ele=0;
	}
	break;

case 13:        if(b==11)
		{
		p1.input();
		getch();
		goto vi;

		}
		else if(b==41)
		{
		int yy;
		yy=compare(p1);
		getch();
		if(yy==1)
		goto vi;
		}
	       //	mainmenu(p1,flag);

		break;

}
}
getch();
}



