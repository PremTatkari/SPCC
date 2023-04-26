%option noyywrap
%{
#include<stdio.h>
int keyword=0;
int identifier=0;
int number=0;
int operator=0;
int symbol=0;
int t=0;
%}

%%
"if"|"else"|"while"|"dowhile"|"for"|"int"|"float"|"long"|"char"|"double"|"printf"|"break" {printf("Keyword\n");keyword++;t++;}
"("|")"|"{"|"}"|";"|","|"="|"@"|":"|"&"|"<"|">"|"#" {printf("Symbols\n");symbol++;t++;}
[A-Za-z]+ {printf("Identifier\n");identifier++;t++;}
[0-9]+ {printf("Number\n");number++;t++;}
"+"|"-"|"*"|"/"|"%" {printf("Operator\n");operator++;t++;}
\n {printf("\nKeywords=%d\n Symbols=%d\n Identifiers=%d\n Numbers=%d\n Operators=%d\n Tokens=%d\n",keyword,symbol,identifier,number,operator,t);}
%%

int main()
{
printf("Enter\n");
yylex();
return 0;
}