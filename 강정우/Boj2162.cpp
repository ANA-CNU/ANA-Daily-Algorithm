#include <iostream>
using namespace std;

int set[3001];

long ccw(long x1, long y1, long x2, long y2, long x3, long y3){
    long result = x1*y2 + x2*y3 + x3*y1 - x1*y3 - x2*y1 - x3*y2;
    if(result > 0) return 1;
    else if(result < 0) return -1;
    else return 0;
}

int cross(long x1, long y1, long x2, long y2, long x3, long y3, long x4, long y4){
    long line1, line2;
    line1 = ccw(x1, y1, x2, y2, x3, y3) * ccw(x1, y1, x2, y2, x4, y4);
    line2 = ccw(x3, y3, x4, y4, x1, y1) * ccw(x3, y3, x4, y4, x2, y2);
    if(line1 <= 0 && line2 <= 0){
        if(line1 == 0 && line2 == 0){
            if(min(x1, x2) > max(x3, x4) || max(x1, x2) < min(x3, x4) || min(y1, y2) > max(y3, y4) || max(y1, y2) < min(y3, y4))
                return 0;
            else return 1;
        }
        else return 1;
    }
    else return 0;
}

int find(int x) {
    if (set[x] == x)
        return x;
    return set[x] = find(set[x]);
}

void unionSets(int a, int b) {
    a = find(a);
    b = find(b);
    if (a != b){
        set[b] = a;
    }
}

int main(){
    int n;
    cin >> n;
    int line[n][4];
    int result_arr[n+1];
    for(int i=0;i<n+1;i++){
        set[i]=i;
        result_arr[i]=0;
    }
    for(int i = 0; i < n; i++){
        cin >> line[i][0] >> line[i][1] >> line[i][2] >> line[i][3];
    }
    for(int i = 0; i < n; i++){
        for(int j = i + 1; j < n; j++){
            if(cross(line[i][0], line[i][1], line[i][2], line[i][3], line[j][0], line[j][1], line[j][2], line[j][3])){
                unionSets(i, j);
            }
        }
    }
    int max = 0;
    int cnt = 0;
    for(int i = 0; i < n; i++){
        result_arr[find(i)]++;
    }
    for(int i=0;i<n+1;i++){
        if(max<result_arr[i]) max=result_arr[i];
        if(result_arr[i]!=0) cnt++;
    }
    cout<<cnt<<endl<<max;
    return 0;
}

