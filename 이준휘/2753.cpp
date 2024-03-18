#include <stdio.h>
int main(){
    int YEAR;
    scanf("%d", &YEAR);
    if(YEAR%4==0){
        if(YEAR%100==0){
            if(YEAR%400==0){
                printf("1");
            }
            else{
                printf("0");
            }
        }
        else{
        printf("1");
        }
    }
    else{
        printf("0");
    }
    return 0;
}