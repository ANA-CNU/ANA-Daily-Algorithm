#include <iostream>
#include <vector>

using namespace std;



vector<long long> tree(4000004);
vector<long long> lazy(4000004);
vector<long long> v(1000001);





int n,m,k;


void init(int node, int start, int end){
    if(start == end) tree[node] = v[start];
    else{
        init(node*2, start, (start+end)/2);
        init(node*2+1, (start+end)/2+1, end);
        tree[node] = tree[node*2 ] + tree[node*2+1];
    }
}



void update_lazy(int node, int start, int end){
    if(lazy[node] != 0){
        tree[node] += (end - start + 1) * lazy[node];
        if(start != end){
            lazy[node*2] += lazy[node];
            lazy[node*2+1] += lazy[node];
        }
        lazy[node] = 0;
    }
}


void update_tree(int node, int start, int end, int left, int right, long long diff){
    update_lazy(node, start, end);
    if(end < left || right < start){
        return;
    }
    if(left <= start && end <= right){
        tree[node] += (end - start + 1) * diff;
        if(start != end){
            lazy[node*2] += diff;
            lazy[node*2+1] += diff;
        }
        return;
    }

    update_tree(node*2, start, (start + end)/2, left, right, diff);

    update_tree(node*2+1, (start + end)/2+1, end, left, right, diff);
    tree[node] = tree[node*2] + tree[node*2+1];
}


long long query(int node, int start, int end, int left, int right){
    update_lazy(node, start, end);
    if(end < left || right < start) return 0;
    if(left <= start && end <= right) return tree[node];


    return query(node*2, start, (start+end)/2, left, right) + query(node*2+1, (start+end)/2+1, end, left ,right);


}












int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    cin>>n>>m>>k;


    for(int i=0; i<n; i++){
        cin>>v[i];
    }

    init(1,0,n-1);

    m += k;


    for(int i=0; i<m; i++){
        int a;
        cin>>a;

        if(a == 1){
            int b,c;
            long long d;
            cin>>b>>c>>d;

            update_tree(1,0,n-1, b-1, c-1, d);
        }
        else{
            int b,c;
            cin>>b>>c;
            cout<<query(1,0,n-1,b-1,c-1)<<'\n';
        }

    }

}