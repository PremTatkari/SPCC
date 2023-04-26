%{
#include<stdio.h>
#include<stdlib.h>
%}

%token A B NL

%%
stmt: A S B NL {printf("Valid string\n");exit(0);}
;
S: S A
|
;
%%

int yyerror(char *msg)
{
printf("Invalid string\n");
exit(0);
}

int main()
{
printf("Enter the string\n");
yyparse();
}