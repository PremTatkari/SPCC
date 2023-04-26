%{
#include<stdio.h>
int upper=0;
int lower=0;
%}

%%
[A-Z] {printf("Upper\n");upper++;}
[a-z] {printf("Lower\n");lower++;}
\n {printf("Uppercase=%d and Lowercase=%d",upper,lower);}
%%

int main()
{
printf("Enter string\n");
yylex();
}
int yywrap()
{
return 1;
}