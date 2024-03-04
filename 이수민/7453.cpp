#include <bits/stdc++.h>
using namespace std;
int n;
int a[4001], b[4001], c[4001], d[4001];
long long int sum;
vector<int> v1, v2;
int main()
{
    scanf("%d",&n);
    for(int i=0; i<n; i++) {
        scanf("%d %d %d %d",&a[i],&b[i],&c[i],&d[i]);
    }
    for(int i=0; i<n; i++) {
        for(int j=0; j<n; j++) {
            int value = a[i] + b[j];
            v1.push_back(value);
        }
    }
    sort(v1.begin(), v1.end());

    for(int i=0; i<n; i++) {
        for(int j=0; j<n; j++) {
            int value = c[i] + d[j];
            v2.push_back(value);
        }
    }
    sort(v2.begin(), v2.end());
    long long int v1_size = v1.size();
    long long int v2_size = v2.size();
    long long int i = 0;
    long long int j = v2_size - 1;
    while(i < v1_size && j >= 0) {
        if(v1[i] + v2[j] < 0) {
            i++;
        }
        else if(v1[i] + v2[j] > 0) {
            j--;
        }
        else {
            long long int ni = i+1;
            long long int nj = j-1;

            while(ni < v1_size && v1[i] == v1[ni]) ni++;
            while(nj >= 0 && v2[j] == v2[nj]) nj--;

            sum += (ni - i) * (j - nj);
            i = ni;
            j = nj;
        }
    }

    printf("%lld",sum);
    return 0;
}
