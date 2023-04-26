%{
#include<stdio.h>
#include<stdlib.h>
int yylex(void);
%}

%token num
%left '+' '-'
%left '*' '/'

%%
input:exp {printf("Calculation is %d",$$);exit(0);}
exp: exp'+'exp {$$=$1+$3;}
|exp'-'exp {$$=$1-$3;}
|exp'*'exp {$$=$1*$3;}
|exp'/'exp {if($3==0){printf("Division by zero");exit(0);}
else{$$=$1/$3;}}
|'('exp')' {$$=$2;}
|num{$$=$1;};
%%

int yyerror(){
printf("Invalid expression");
exit(1);
}

int main(){
printf("Enter\n");
yyparse();
return 0;
}