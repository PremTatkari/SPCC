%{
#include<stdio.h>
int op=0;
int id=0;
int b=0;
%}

%%
[0-9][0-9]* {id++;printf("\nIdentifier:");ECHO;}
[\+\-\*\/\=]  {op++;printf("\nOperator:");ECHO;}
"(" {b++;}
")" {b--;}
.|\n {return 0;}
%%

int main()
{
printf("Enter expression\n");
yylex();
if((op+1) == id && b==0)
{
printf("\n\nIdentfiers are %d and Operators are %d\n",id,op);
printf("\nExpression is valid\n");
}

else
printf("\nExpression is invalid\n");

return 1;
}

int yywrap()
{
return 1;
}