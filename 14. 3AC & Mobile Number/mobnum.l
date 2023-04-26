%option noyywrap

%{
#include<stdio.h>
%}

%%
[1-9][0-9]{9} {printf("Valid mobile number\n");}
.+ {printf("Invalid mobile number\n");}
%%

int main()
{
printf("Enter mobile number\n");
yylex();
return 0;
}