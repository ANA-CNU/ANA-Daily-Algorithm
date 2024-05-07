#include <stdio.h>
int main(){
    int N;
    scanf("%d", &N);
    int MX = 100001;
    int arr[2* MX+1];
    int tail = MX;
    int head = MX;
    for(int i = 0; i<N; i++){
        char S[12];
        scanf("%s", S);
        if(S[0]=='p' && S[1]=='u' && S[5]=='b'){
            int K;
            scanf("%d", &K);
            arr[tail+1] = K;
            tail++;
            continue;
        }
        if(S[0]=='p' && S[1]=='u' && S[5]=='f'){
            int K;
            scanf("%d", &K);
            arr[head] = K;
            head--;
            continue;
        }
        if(S[0]=='p' && S[1]=='o' && S[4]=='f'){
            if(tail!=head) {
                printf("%d\n", arr[head+1]);
                head++;
            }
            else printf("-1\n");
            continue;
        }
        if(S[0]=='p' && S[1]=='o' && S[4]=='b'){
            if(tail!=head) {
                printf("%d\n", arr[tail]);
                tail--;
            }
            else printf("-1\n");
            continue;
        }
        if(S[0]=='s'){
            printf("%d\n", tail-head);
            continue;
        }
        if(S[0]=='e'){
            if(tail==head) printf("1\n");
            else printf("0\n");
            continue;
        }
        if(S[0]=='f'){
            if(tail!=head) printf("%d\n", arr[head+1]);
            else printf("-1\n");
            continue;
        }
        if(S[0]=='b'){
            if(tail!=head) printf("%d\n", arr[tail]);
            else printf("-1\n");
            continue;
        }
    }
}