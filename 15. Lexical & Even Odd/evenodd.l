%option  noyywrap
%{
#include<stdio.h>
int i;
%}

%%
[0-9]+ {i=atoi(yytext);
if(i%2==0)
printf("Even");
else
printf("Odd");}
%%

int main()
{
printf("Enter number\n");
yylex();
return 0;
}