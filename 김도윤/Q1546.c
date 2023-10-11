#include <stdio.h>

int main(void)
{
    int number[1000] = {0};
    double sum = 0;
    double max = 0;
    int i,n;
    scanf("%d", &n);
    for(i=0; i<n; i++)// 입력받기
    {
        scanf("%d", &number[i]);     
    }
    
    max = number[0];// 최댓값 설정
    for(i=0; i<n; i++)
    {
        if(number[i]>max)
        {
            max = number[i];
        }
    }
    for(i=0; i<n; i++)
    {
        sum += number[i]/max*100;
        
    }
    sum = sum / n;
    printf("%lf", sum);
    
    
    return 0;
}