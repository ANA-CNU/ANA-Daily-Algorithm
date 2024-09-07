#include <iostream>
#include <vector>
#include <algorithm>


using namespace std;


typedef long long ll;

vector<ll> v(100001);
vector<ll> tree_idx(400004);


int init(int node, int start, int end){
    if(start == end) return tree_idx[node] = start;
    else{
        
        int mid = (start + end)/2;
        int left_idx = init(node*2, start, mid);
        int right_idx = init(node*2+1, mid + 1, end);
        if(v[left_idx] < v[right_idx]){
            return tree_idx[node] = left_idx;
        }
        else if(v[left_idx] > v[right_idx]){
            return tree_idx[node] = right_idx;
        }
        else{
            return tree_idx[node] = min(left_idx, right_idx);
        }
    }
}


void update(int node, int start, int end, int index, ll value){
    if(index < start || index > end) return;
    if(start == end){
        v[index] = value;
        tree_idx[node] = start;
    }
    else{
        int mid = (start + end)/2;

        update(node*2, start, mid, index, value);
        update(node*2+1, mid + 1, end, index, value);

        int left_idx = tree_idx[node*2];
        int right_idx = tree_idx[node*2+1];

        if(v[left_idx] > v[right_idx]){
            tree_idx[node] = right_idx;
        }
        else if(v[left_idx] < v[right_idx]){
            tree_idx[node] = left_idx;
        }
        else{
            tree_idx[node] = min(left_idx, right_idx);
        }
    }
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


    init(1,1,n);

    int m;

    cin>>m;
    
    for(int i=0; i<m; i++){
        int a;
        cin>>a;

        if(a == 1){
            int b,c;
            cin>>b>>c;
            update(1,1,n,b,c);
        }
        else if(a == 2){
            cout<<tree_idx[1]<<'\n';

        }
    }


}