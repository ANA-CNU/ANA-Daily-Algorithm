#include<iostream>
using namespace std;
int n,k;
long result=0;
class Dot{
private:
    long x,y;
public:
    void SetInfo(long x,long y);
    long getx() const;
    long gety() const;
};
void Dot ::SetInfo(long _x, long _y) {
    x=_x;
    y=_y;
}
long Dot ::getx() const {
    return x;
}
long Dot::gety() const {
    return y;
}
Dot dot_list[100];
int range(long lx,long rx,long dy,long ty,int idx){
    int x=dot_list[idx].getx();
    int y=dot_list[idx].gety();
    if(x>=lx&&x<=rx&&y<=ty&&y>=dy){
        return 1;
    }
    return 0;
}
int check(long len){
    for(int i=0;i<n;i++){
        long lx= dot_list[i].getx();
        long rx= lx+len;
        for(int j=0;j<n;j++){
            long dy=dot_list[j].gety();
            long ty=dy+len;
            int cnt=0;
            for(int u=0;u<n;u++){
                if(range(lx,rx,dy,ty,u)){
                    cnt++;
                }
            }
            if(cnt>=k){
                return 1;
            }
        }
    }
    return 0;
}

int main(){
    cin>>n>>k;
    for(int i=0;i<n;i++){
        Dot d{};
        long x,y;
        cin>>x>>y;
        d.SetInfo(x,y);
        dot_list[i]=d;
    }
    long start=0,end=2000000000;
    while(start <= end){
        long mid= (start + end) / 2l;
        if(check(mid)){
            result=mid;
            end= mid - 1;
        }else{
            start=mid+1;
        }
    }
    result+=2;
    cout<<result*result;
}
