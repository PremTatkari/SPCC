%{
#include<stdio.h>
int Vowels=0;
int Consonants=0;
%}

%%
[aeiouAEIOU] {printf("Vowel\t\n");Vowels++;}
[a-zA-Z] {printf("Consonant\t\n");Consonants++;}
\n {printf("Vowels=%d and Consonants=%d",Vowels,Consonants);}
%%

int main()
{
printf("Enter a string\n");
yylex();
}
int yywrap()
{
return 1;
}