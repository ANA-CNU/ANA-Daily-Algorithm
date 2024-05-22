#include <iostream>
#include <vector>
#include <algorithm>



using namespace std;

int n,m;


vector<long long> a(100001);
vector<long long> tree(400004);



long long init(int node, int start, int end){
    if(start == end) return tree[node] = a[start];
    else{
        return tree[node] = min(init(node*2, start, (start+end)/2), init(node*2+1, (start+end)/2+1, end));
    }
}


long long min_sum(int node, int start, int end, int left, int right){
    if(left > end || right < start) return 1e9;
    if(left <= start && end <= right) return tree[node];
    return min(min_sum(node*2, start, (start+end)/2, left, right), min_sum(node*2+1, (start+end)/2+1, end, left, right));
}







int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin>>n>>m;

    for(int i=1; i<=n; i++){
        cin>>a[i];
    }

    init(1,1,n);

    for(int i=0; i<m; i++){
        int a,b;
        cin>>a>>b;
        cout<<min_sum(1,1,n,a,b)<<'\n';
    }


}