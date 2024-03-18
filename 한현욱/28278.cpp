#include <iostream>

using namespace std;

int main(){

    int n = 0;
    scanf("%d",&n);
    static int arr[10000001]={0};

    int *p = &arr[0];
    int *first = p;//주의?
    for (int i = 0; i < n; i++)
        {
            int num;
            scanf("%d", &num);
            
            if (num == 1){
                int c;
                scanf("%d",&c);
                *(p+4) = c;
                p += 4;
            }
            else if (num == 2){
                if(*p != 0){
                    printf("%d\n",*p);
                    p -= 4;

                }
                else{
                    printf("%d\n",-1);
                }
            }
            else if (num == 3){
                printf("%d\n",(p-first)/4);
            }
            else if (num == 4){
                if(p-first == 0){
                    printf("%d\n",1);
                }
                else{
                    printf("%d\n",0);
                }
            }
            else{
                if(p-first == 0){
                    printf("%d\n",-1);
                }
                else{
                    printf("%d\n",*p);
                }
            }
        }

    return 0;
}
