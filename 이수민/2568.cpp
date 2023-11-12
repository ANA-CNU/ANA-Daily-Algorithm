#include <bits/stdc++.h>
using namespace std;
typedef struct {
    int a;
    int b;
}st;
bool compare(st a, st b) {
    return a.a < b.a;
}
int num[500001];
int check[500001];
int main()
{
    int t,a,b;
    vector<st> v;
    vector<st> arr;
    //for(int i=0; i<500001; i++) num[i] = check[i] = 0;
    scanf("%d",&t);
    for(int i=0; i<t; i++) {
        scanf("%d %d",&a,&b);
        num[a] = 1;
        v.push_back({a, b});
    }
    sort(v.begin(), v.end(), compare);
    arr.push_back({v[0].a, v[0].b});
    for(int i=1; i<t; i++) {
        if(arr[arr.size()-1].b < v[i].b) {
            check[v[i].a] = arr[arr.size()-1].a;
            arr.push_back(v[i]);
        }
        else {
            int left = 0;
            int right = arr.size() - 1;
            int mid;
            while(left <= right) {
                mid = (left + right) / 2;
                if(arr[mid].b < v[i].b) left = mid + 1;
                else right = mid - 1;
            }
            arr[left] = v[i];
            check[v[i].a] = left == 0 ? 0 : arr[left-1].a;
        }
    }
    printf("%d\n",t - arr.size());
    int p = arr[arr.size()-1].a;
    while(p) {
        num[p] = 0;
        p = check[p];
    }
    for(int i=0; i<500001; i++) if(num[i]) printf("%d\n",i);
    return 0;
}
