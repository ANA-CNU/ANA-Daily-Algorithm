    #include <bits/stdc++.h>

    using namespace std;
    typedef pair<pair<int,int>, int> piii;

    struct P{
        int x, y, fuel;
        bool operator<(const P & obj)const {
            return (x+y) < obj.x + obj.y;
        }
    };

    vector<P> NODES;

    int r,c;
    int N;

    bool onlyDownRight(const P& a, const P& b){
        return a.x <= b.x && a.y <= b.y;
    }

    int caldist(const P& a, const P& b){
        return abs(a.x-b.x) + abs(a.y-b.y);
    }
    bool check(int initial_fuel){

        // memset(dp, -1, sizeof(dp));
        vector<int> dp(NODES.size(),-1);
        dp[0] = initial_fuel;
        for(int i = 1;i<NODES.size();i++){
            for(int j = 0;j<i;j++){
                if(!onlyDownRight(NODES[j],NODES[i])) continue; // j - > i
                if(dp[j] < caldist(NODES[j],NODES[i])) continue;
                dp[i] = max(dp[i], dp[j] -caldist(NODES[i],NODES[j]) + NODES[i].fuel);
            }
        }
        return dp[N+1] != -1;
    }

    int main(void){
        ios::sync_with_stdio(false);cin.tie(0);
        cin >> r >> c;
        cin >> N;
        NODES.push_back({0,0,0});
        for(int i =1;i<=N;i++){
            int x, y, fuel;
            cin >> x >> y >> fuel;
            NODES.push_back({x-1,y-1,fuel});
        }
        NODES.push_back({r-1,c-1, 0});

        sort(NODES.begin(),NODES.end());
        int lo = 0; int hi = 6002;
        while(lo<=hi){
            int mid = (hi+lo)/2;
            if(check(mid)){
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }
        cout << lo << '\n';
    }