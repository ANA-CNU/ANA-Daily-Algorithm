#include <bits/stdc++.h>
using namespace std;
typedef struct {
    int sd;
    int ed;
}st;
struct compare {
    bool operator()(st a, st b) {
        if(a.sd == b.sd) return a.ed > b.ed;
        return a.sd < b.sd;
    }
};
vector<st> v;
int day[13] = {0, 30, 58, 89, 119, 150, 180, 211, 242, 272, 303, 333, 364};
int main()
{
    int n,sm,sd,em,ed;
    scanf("%d",&n);
    int min_sd = 365;
    int max_ed = 0;
    for(int i=0; i<n; i++) {
        scanf("%d %d %d %d",&sm, &sd, &em, &ed);
        sd = day[sm-1] + sd;
        ed = day[em-1] + ed;
        min_sd = min(min_sd, sd);
        max_ed = max(max_ed, ed);

        v.push_back({sd, ed});
    }

    if(min_sd > 59 || max_ed < 333) {
        printf("0");
        return 0;
    }

    sort(v.begin(), v.end(), compare());

    int sum = 0;
    int ssd = 59;
    int t = v.size();
    while(ssd < 334) {
        int n_ssd = ssd;

        for(int i=0; i<t; i++) {
            if(v[i].sd <= ssd && v[i].ed > n_ssd) n_ssd = v[i].ed;
        }

        if(n_ssd == ssd) {
            printf("0");
            return 0;
        }
        sum++;
        ssd = n_ssd;
    }
    printf("%d",sum);


    return 0;
}
