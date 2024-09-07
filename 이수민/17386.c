#include <stdio.h>
#include <stdlib.h>
typedef struct {
    long long int x,y;
}st;
int ccw(st p1, st p2, st p3) {
    long long int s = (p1.x*p2.y + p2.x*p3.y + p3.x*p1.y) - (p1.x*p3.y + p2.x*p1.y + p3.x*p2.y);
    if(s > 0) return 1;
    else if(s == 0) return 0;
    return -1;
}
int isCross(st p1, st p2, st p3, st p4) {
    int p1p2 = ccw(p1, p2, p3) * ccw(p1, p2, p4);
    int p3p4 = ccw(p3, p4, p1) * ccw(p3, p4, p2);
    return p1p2 <= 0 && p3p4 <= 0;
}
int main()
{
    int x1,x2,x3,x4,y1,y2,y3,y4;
    scanf("%d %d %d %d",&x1,&y1,&x2,&y2);
    scanf("%d %d %d %d",&x3,&y3,&x4,&y4);
    st p1 = {x1, y1};
    st p2 = {x2, y2};
    st p3 = {x3, y3};
    st p4 = {x4, y4};

    printf("%d",isCross(p1, p2, p3, p4));
    return 0;
}
