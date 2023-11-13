#include <bits/stdc++.h>
using namespace std;
int cnt,n,k,arr[101];
vector<int> v;
int main()
{
    scanf("%d %d",&n,&k);
    for(int i=0; i<k; i++) {
        scanf("%d",&arr[i]);
    }

    for(int i=0; i<k; i++) {
        int t = v.size();
        int j;
        if(t < n) {
                for(j=0; j<t; j++) {
                    if(v[j] == arr[i]) break;
                }
                if(j<t) continue;
                v.push_back(arr[i]);
        }
        else if(t == n) {
            for(j=0; j<t; j++) {
                if(v[j] == arr[i]) {
                    break;
                }
            }
            if(j < t) continue;

            cnt++;
            int max_value = -1;
            int max_index = 0;
            for(j=0; j<t; j++) {
                int x = v[j];
                int index = k;
                for(int l=i+1; l<k; l++) {
                    if(x == arr[l]) {
                        index = l;
                        break;
                    }
                }
                if(max_index < index) {
                    max_index = index;
                    max_value = j;
                }
            }
            v[max_value] = arr[i];
        }
    }
    printf("%d",cnt);
    return 0;
}
