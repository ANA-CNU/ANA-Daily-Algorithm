#include <stdio.h>
#include <stdlib.h>

int main()
{
    int x1,x2,x3,y1,y2,y3,s;
    scanf("%d %d %d %d %d %d",&x1,&y1,&x2,&y2,&x3,&y3);
    s = (x2-x1)*(y3-y1) - (y2-y1)*(x3-x1);
    if(s < 0) printf("-1");
    else if(s > 0) printf("1");
    else printf("0");
    return 0;
}
