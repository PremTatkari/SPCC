%{
#include<stdio.h>
int lines=1;
int nums=0;
int spaces=0;
%}

%%
[0-9]+ {nums++;}
[ ] {spaces++;}
\n {lines++;}
"$" {printf("Numbers:%d\nSpaces:%d\nLines:%d",nums,spaces,lines);}
. {}
%%

int yywrap(){return 1;}

int main(){
printf("Enter\n");
yylex();
return 0;
}