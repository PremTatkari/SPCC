%{
#include<stdio.h>
#include<stdlib.h>
%}

%token A B C NL

%%
stmt: ABC NL {printf("Valid string");exit(0);}
;
ABC: A AB B BC C
AB: A AB B
BC: B BC C
|
;
%%

int yyerror(char *msg)
{printf("Invalid string");exit(0);}

int main()
{
printf("Enter string\n");
yyparse();
return 0;
}