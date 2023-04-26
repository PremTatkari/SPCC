%option noyywrap

%{
#include<stdio.h>
int chars=0;
int words=0;
int sents=0;
int lines=1;
int tabs=0;
int nums=0;
int spaces=0;
%}

%%
[A-Za-z] {chars++;}
" " {spaces++;words++;}
\t {tabs++;words++;}
\n {lines++;words++;}
"." {sents++;}
[0-9]+ {nums++;}
"$" {printf("\nCharacters=%d\nWords=%d\nSentences=%d\nLines=%d\nTabs=%d\nNumbers=%d\nSpaces=%d",chars,words,sents,lines,tabs,nums,spaces);}
%%

int main()
{
printf("Enter\n");
yylex();
return 0;
}


