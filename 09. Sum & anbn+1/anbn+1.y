%{
#include<stdio.h>
#include<stdlib.h>
%}

%token A B NL

%%
stmt: AB NL {printf("Valid string\n");exit(0);}
;
AB: A AB B
| B
;
%%

int yyerror(char *msg){
printf("Invalid string\n");
exit(0);
}

int main(){
printf("Enter string\n");
yyparse();
return 0;
}