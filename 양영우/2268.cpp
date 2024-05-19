#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

long long tree[4000005];
long long a[1000005];



long long sum(int node, int start, int end, int left, int right){
    if(left > end || right < start){
        return 0;
    }
    if(left <= start && end <= right){
        return tree[node];
    }

    return sum(node*2, start, (start+end)/2, left, right) + sum(node*2+1, (start+end)/2+1, end, left, right);
}

void update(int node, int start, int end, int index, long long diff){
    if(index <  start || index > end) return;
    tree[node] += diff;
    if(start != end){
        update(node*2, start, (start+end)/2, index, diff);
        update(node*2+1, (start+end)/2+1, end, index, diff);
    }
    
}



int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int n,m;

    cin>>n>>m;

    for(int i=0; i<m; i++){
        long long type,b,c;
        cin>>type>>b>>c;

        if(type == 0){
            if(b>c) swap(b,c);
            cout<<sum(1,1,n,b,c)<<'\n';
        }
        else{
            long long diff = c - a[b];
            a[b] = c;
            update(1,1,n,b,diff);

        }



    }

}