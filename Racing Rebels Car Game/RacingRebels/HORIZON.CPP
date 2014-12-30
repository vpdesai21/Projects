
class horizon
{
int i,j;
public:
horizon()
{       setfillstyle(10,9);
	floodfill(50,50,BROWN);


	setcolor(BROWN);
	line (0,150,65,100);
	line (150,150,85,100);
	arc(75,118,60,120,20);
	setfillstyle(1,BROWN);
	floodfill(75,118,BROWN);


setcolor(BROWN);
line (150,150,215,100);
line (300,150,235,100);
arc(225,118,60,120,20);
setfillstyle(1,BROWN);
floodfill(225,118,BROWN);

setcolor(BROWN);
line (350,150,415,100);
line (500,150,435,100);
arc(425,118,60,120,20);
setfillstyle(1,BROWN);
floodfill(425,118,BROWN);

setcolor(BROWN);
line (500,150,565,100);
line (650,150,585,100);
arc(575,118,60,120,20);
setfillstyle(1,BROWN);
floodfill(575,118,BROWN);

}

void cloud()
{
setcolor(BLUE);
line(8,95,149,95);
arc(35,45,20,195,25);
arc(30,75,120,220,30);
arc(88,45,20,170,30);
arc(126,67,310,110,34);

line(220,50,300,50);
arc(240,40,60,210,20);
arc(260,40,30,120,23);
arc(280,45,340,100,20);

line(410,80,540,80);
arc(435,64,80,210,30);
arc(470,60,30,140,38);
arc(510,70,340,100,30);
setfillstyle(9,LIGHTGRAY);
setcolor(7);

//MOON

arc(590,40,260,93,25);
arc(580,40,280,72,25);
floodfill(610,40,LIGHTGRAY);
setfillstyle(9,LIGHTBLUE);
floodfill(50,90,BLUE);
floodfill(270,40,BLUE);
floodfill(469,60,BLUE);

setcolor(BROWN);
}
};