#include <iostream>
#include <vector>


typedef long long ll;

using namespace std; 


vector<ll> v(100001);
vector<ll> tree(400004);


vector<ll> lazy(400004);



void init(int node, int start, int end){
    if(start == end){
        tree[node] = v[start];
        return;
    }
    
    int mid = (start + end)/2;

    init(node*2, start, mid);
    init(node*2+1, mid+1, end);

    tree[node] = tree[node*2] + tree[node*2+1];
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



void update_range(int node, int start, int end, int left, int right, ll diff){
    update_lazy(node, start, end);
    if(left > end || start > right) return;

    if(left<= start && end <= right){
        tree[node] += (end - start + 1) * diff;

        if(start != end){
            lazy[node*2] += diff;
            lazy[node*2+1] += diff;
        }
        return;
    }

    int mid = (start + end)/2;

    update_range(node*2, start, mid, left, right, diff);
    update_range(node*2+1, mid+1, end, left, right, diff);
    

    tree[node] = tree[node*2] + tree[node*2+1];

}

ll query(int node, int start, int end, int idx){
    update_lazy(node,start,end);
    if(start == end) return tree[node];

    int mid = (start + end)/2;

    if(idx <= mid){
        return query(node*2, start, mid, idx);
        
    }
    else{
        return query(node*2+1, mid + 1, end, idx);
    }

    
}







int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int n;
    cin>>n;

    for(int i=0; i<n; i++){
        cin>>v[i];
    }

    init(1, 0, n-1);

    int m;

    cin>>m;

    for(int i=0; i<m; i++){
        int a;
        cin>>a;
        if(a == 1){
            int b, c, d;
            cin>>b>>c>>d;
            update_range(1,0,n-1,b-1,c-1,d);
        }
        else{
            int idx;
            cin>>idx;
            cout<<query(1,0,n-1,idx-1)<<'\n';
        }
    }


    

}

