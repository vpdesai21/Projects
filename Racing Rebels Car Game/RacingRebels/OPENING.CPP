#include<iostream.h>
#include<graphics.h>
#include<conio.h>
#include<stdlib.h>
#include<dos.h>
#include<stdio.h>
#include"menu.cpp"





void main()
{
int gd=DETECT,gm;
initgraph(&gd,&gm,"..//bgi");

menu();
}
