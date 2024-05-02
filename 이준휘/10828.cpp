#include <stdio.h>
int main(){
    int N;
    scanf("%d", &N);
    int arr[100001];
    int pos = 0;
    for(int i = 0; i<N; i++){
        char S[6];
        scanf("%s", S);
        if(S[0]=='p' && S[1]=='u'){
            int K;
            scanf("%d", &K);
            arr[pos] = K;
            pos++;
            continue;
        }
        if(S[0]=='p' && S[1]=='o'){
            if(pos!=0) printf("%d", arr[(pos--)-1]);
            else printf("-1\n");
            continue;
        }
        if(S[0]=='s'){
            scanf("%c", &S[3]);
            printf("%d\n", pos);
            continue;
        }
        if(S[0]=='e'){
            if(pos==0) printf("1\n");
            else printf("0\n");
            continue;
        }
        if(S[0]=='t'){
            if(pos!=0) printf("%d\n", arr[pos-1]);
            else printf("-1\n");
            continue;
        }
    }
}