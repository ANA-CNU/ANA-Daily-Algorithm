#include <bits/stdc++.h>
using namespace std;
typedef struct {
    int x;
    int y;
}st;
int compare_x(st a, st b) {
    return a.x < b.x;
}
int compare_y(st a, st b) {
    return a.y < b.y;
}
vector<st> vx;

int dis(st a, st b) {
    return (b.x - a.x)*(b.x - a.x) + (b.y - a.y)*(b.y - a.y);
}
int f(int left, int right) {
    int len = right - left + 1;
    if(len == 2) {
        return dis(vx[left], vx[right]);
    }
    else if(len == 3) {
        int mid = left+1;
        int d1 = dis(vx[left], vx[mid]);
        int d2 = dis(vx[mid], vx[right]);
        int d3 = dis(vx[left], vx[right]);
        return min(min(d1, d2), d3);
    }
    int mid = (left+right) / 2;

    int disl = f(left, mid);
    int disr = f(mid+1, right);
    int t = min(disl, disr);

    if(t == 0) return t;
    vector<st> vy;
    for(int i=left; i<=mid; i++) {
        if((vx[mid].x-vx[i].x)*(vx[mid].x-vx[i].x) < t) vy.push_back(vx[i]);
    }

    for(int i=mid+1; i<=right; i++) {
        if((vx[mid+1].x-vx[i].x)*(vx[mid+1].x-vx[i].x) < t) vy.push_back(vx[i]);
    }

    int yt = vy.size();
    sort(vy.begin(), vy.end(), compare_y);

    for(int i=0; i<yt-1; i++) {
        for(int j=i+1; j<yt; j++) {
            if((vy[i].y-vy[j].y)*(vy[i].y-vy[j].y) < t) {
                int k = dis(vy[i], vy[j]);
                t = t > k ? k : t;
            }
            else break;
        }
    }
    return t;
}
int main()
{
    int t,x,y,answer;
    scanf("%d",&t);
    for(int i=0; i<t; i++) {
        scanf("%d %d",&x,&y);
        vx.push_back({x, y});
    }
    sort(vx.begin(), vx.end(), compare_x);
    answer = f(0, t-1);
    printf("%d",answer);
    return 0;
}
