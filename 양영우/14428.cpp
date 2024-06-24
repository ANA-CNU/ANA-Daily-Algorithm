#include <iostream>
#include <vector>
#include <algorithm>


typedef long long ll;




using namespace std;


vector<ll> v(100005);
vector<ll> tree(400005);



void init(int node, int start, int end){
    if(start == end) tree[node] = start;
    else{
        int mid = (start + end)/2;
        
        init(node*2, start, mid);
        init(node*2+1, mid + 1, end);

        int left_idx = tree[node*2];
        int right_idx = tree[node*2+1];

        tree[node] = (v[left_idx] <= v[right_idx]) ? left_idx : right_idx;
    }
}


void update_num(int node, int start, int end, int idx, ll val){
    if(idx < start || idx > end) return;
    if(start == end){
        v[idx] = val;
        tree[node] = start;
    }
    else{
        int mid = (start + end)/2;
        update_num(node*2, start, mid, idx, val);
        update_num(node*2+1, mid + 1, end, idx, val);

        int left_idx = tree[node*2];
        int right_idx = tree[node*2+1];

        tree[node] = (v[left_idx] <= v[right_idx]) ? left_idx : right_idx;
    }
}




ll query(int node, int start, int end, int left, int right){
    if(right < start || left > end) return -1;
    if(left <= start && end <= right) return tree[node];

    int mid = (start + end)/2;

    int left_idx = query(node*2, start, mid, left, right);
    int right_idx = query(node*2+1, mid+1, end, left, right);

    if(left_idx == -1) return right_idx;
    if(right_idx == -1) return left_idx;

    return (v[left_idx] <= v[right_idx]) ? left_idx : right_idx;




}







int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int n;
    cin>>n;


    for(int i=1; i<=n; i++){
        cin>>v[i];
    }

    int m;

    cin>>m;

    init(1,1,n);

    for(int i=0; i<m; i++){
        int a;
        cin>>a;
        if(a == 1){
            int b;
            ll c;
            cin>>b>>c;
            update_num(1,1,n, b, c);
        }
        if(a == 2){
            int b,c;
            cin>>b>>c;
            cout<<query(1, 1, n, b, c)<<'\n';
    
        }
    }



}