#include <iostream>
#include <vector>
using namespace std;
int main(){
    int n;
    cin>>n;
    vector<vector<double>> a(n);
    vector<double>b(n);
    for(int i=0;i<n;i++){
        for(int j=0;j<=n;j++) {
            double temp;
            cin >> temp;
            if(j!=n) {
                a[i].push_back(temp);
            }
            else {
                b[i]=temp;
            }
        }
    }
    for(int i=0;i<n-1;i++){
        int max = i;
        for(int k=i+1; k<n; k++)
            if(abs(a[k][i]) > abs(a[max][i]))
                max = k;
        swap(a[max], a[i]);
        swap(b[max], b[i]);
        for(int j=i+1;j<n;j++){
            double factor=a[j][i]/a[i][i];
            for(int k=i;k<n;k++)
                a[j][k]-=a[i][k]*factor;
            b[j]-=b[i]*factor;
        }
    }
    for (int i=n-1; i>=0; i--) {
        for (int j=i+1; j<n; j++)
            b[i] -= a[i][j]*b[j];

        b[i] /= a[i][i];
    }
    for(int i=0;i<n;i++) cout<<b[i]<<" ";
}
