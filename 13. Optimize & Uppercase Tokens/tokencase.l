%option noyywrap
%{
#include<stdio.h>
int count=0;
%}

%%
[a-zA-Z]*[A-Z][a-zA-Z]* {count++;}
\n {printf("\nTokens with uppercase: %d\n",count);}
. {}
%%

int main()
{
printf("Enter\n");
yylex();
return 0;
}