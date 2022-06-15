#include <stdio.h>
#include <stdlib.h>
#include <string.h>


int count = 0;
/*int day(int A, int B, int sum, int V){
    sum+=A;
    if(sum >= V){
        return sum;
    }else{
        sum -= B;
        count++;
        return sum;
    }
}
*/
int main(){
    int A,B,V;
    int sum = 0;
    scanf("%d %d %d", &A, &B, &V);

    if((V-B) % (A-B) != 0){
        count = (V-B) / (A-B) + 1;
    }else{
        count = (V-B) /(A-B);
    }
    printf("%d", count);
}
//A+B만큼 sum에 더해지는거임
//많은 수가 들어왔을떄 시간을 줄이는방법은?
//어짜피 B더하기전에 도달하면 카운트안됨 정상을 V-B해도됨
//(A+B)만큼씩증가하니까.. V-B까지가려면 V-B/A+B만큼의 count. 
//나누어떨어지면 그냥 그 몫을 카운트로 제출
//아니면 그 몫 +1을 제출함