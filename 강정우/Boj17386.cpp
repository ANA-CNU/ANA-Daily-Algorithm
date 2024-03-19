#include <iostream>
using namespace std;
long ccw(long x1,long y1,long x2,long y2,long x3,long y3){
    long result=x1*y2 + x2*y3 + x3*y1 - x1*y3 - x2*y1 - x3*y2;
    if(result>0) return 1;
    else if(result<0) return -1;
    else return 0;
}
int main(){
    long x1,x2,x3,x4,y1,y2,y3,y4;
    cin>>x1>>y1>>x2>>y2;
    cin>>x3>>y3>>x4>>y4;
    long line1,line2;
    line1=ccw(x1,y1,x2,y2,x3,y3)*ccw(x1,y1,x2,y2,x4,y4);
    line2=ccw(x3,y3,x4,y4,x1,y1)*ccw(x3,y3,x4,y4,x2,y2);
    if(line1<=0 && line2<=0){
        if(line1==0 && line2==0){
            if(min(x1,x2)>max(x3,x4)||max(x1,x2)<min(x3,x4)||min(y1,y2)>max(y3,y4)||max(y1,y2)<min(y3,y4))
                cout<<0;
            else cout<<1;
        }
        else cout<<1;
    }
    else cout<<0;
    return 0;
}

