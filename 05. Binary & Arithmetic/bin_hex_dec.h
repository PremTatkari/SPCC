#include<stdio.h>
#include<math.h>

#define bin_dec_hex(bin)({\
int dec=0,rem,i=0;\
while(bin!=0){ \
    rem=bin%10;\
    dec+=rem*pow(2,i);\
    i++;\
    bin=bin/10;\
}\
dec;\
})

#define dec_hex_bin(num)({\
    int bin=0,rem,i=1;\
    while(num!=0){\
        rem = num%2;\
        bin = num * i;\
        i *= 10;\
        num /= 2;\
    }\
bin;\
})
