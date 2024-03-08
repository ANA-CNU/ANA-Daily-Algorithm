#include<iostream>
using namespace std;

int main(){
    int x, y, w, h;
    cin >> x >> y >> w >> h;

    int minx = x;
    if(w - x < x)
        minx = w - x;

    int miny = y;
    if(h - y < y)
        miny = h - y;
    
    int min = minx;
    if(miny < minx)
        min = miny;

    cout << min;

    return 0;
}
