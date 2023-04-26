%{
#include<stdio.h>
#include<stdlib.h>
%}

%token A B NL

%%
stmt: AAB NL {printf("Valid string");exit(0);}
;
AAB: A A AAB B
|
;
%%

int yyerror(char *msg){
printf("Invalid string");
exit(0);
}

int main(){
printf("Enter string\n");
yyparse();
return 0;
}