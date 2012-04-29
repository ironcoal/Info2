#include <stdio.h>
#include <stdlib.h>
int maxsegsum(int b[],int n);
void pluseins(int a);
int main(int argc, char* argv[]){
if (argc!=11) {
printf("Aufruf mit 10 ganzen Zahlen!\n");
}
else {
int i,wert=1,folge[10];
for(i=0;i<argc-1;i++)
folge[i]=atoi(argv[i+1]);
printf("Wert vor erstem Funktionsaufruf: %i\n",argc);
pluseins(wert);
printf("Wert nach erstem Funktionsaufruf: %i\n",wert);
wert=maxsegsum(folge,argc-1);
printf("Maximale Segmentsumme: %i\n",wert);
}
return 0;
}
void pluseins(int a){
a=a+1;
}
int maxsegsum(int b[], int n){
int s=0,h=0,c=0;
while(h!=n)
{
if(c+b[h]>0)
c+=b[h];
else c=0;
if(c>s)
s=c;
h++;
}
return s;
}
