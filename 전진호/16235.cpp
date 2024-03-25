#include <iostream>
#include <vector>
#include <deque>
#include <algorithm>

using namespace std;


struct tree{
    int row;
    int col;
    int age;
};

int dy[8] = {-1,-1,-1, 0,0, 1,1,1};
int dx[8] = {-1, 0, 1,-1,1,-1,0,1};
int A[11][11];
int CA[11][11];
deque<int> Tree[11][11]; 
deque<tree> del_tree;
deque<tree> furtle;
// 만약에 시간 초과가 나면 pq로 바꾸기 age, row, col 
// less age first 

int N, M, K;

bool outOfBound(int row, int col){
    if(0>row || row >= N || 0> col || col >= N){
        return true;
    }
    return false;
}

void INPUT(){
    cin >> N >> M >> K;
    
    for(int i = 0;i<N;i++){
        for(int j=0;j<N;j++){
            cin >> A[i][j];
            CA[i][j] = 5;
        }
    }

    int row, col, age;
    for(int i = 0;i<M;i++){
        cin >> row >> col >> age;
        --row; --col;
        Tree[row][col].push_back(age);
    }
}

void logic(){
    
    // spring
    for(int i = 0;i<N;i++){
        for(int j = 0;j<N;j++){
            if(Tree[i][j].empty()){
                continue;
            }else{
                if(Tree[i][j].size()>=2){
                    sort(Tree[i][j].begin(), Tree[i][j].end());
                }
                int s = Tree[i][j].size();
                for(int r = 0;r<s;r++){
                    int cur = Tree[i][j].front();
                    Tree[i][j].pop_front();
                    if(CA[i][j] >= cur){

                        CA[i][j] -= cur;
                        cur++; 
                        if(cur%5 ==0){
                            furtle.push_back({i,j,cur});
                        }
                        Tree[i][j].push_back(cur);
                    }else{ // 현재부터 인덱스는 다 죽음 
                        del_tree.push_back({i,j,cur});
                    }
                }
            }
        }
    }

    // summer
    while(!del_tree.empty()){
        tree cur = del_tree.front();
        del_tree.pop_front();
        int row = cur.row;
        int col = cur.col;
        int age = cur.age;
        CA[row][col] += age/2;
    }

    // fall
    while(!furtle.empty()){
        tree cur = furtle.front();
        furtle.pop_front();
        int row = cur.row;
        int col = cur.col;

        for(int l = 0;l<8;l++){
            int ny = row+dy[l];
            int nx = col+dx[l];
            if(outOfBound(ny, nx)){
                continue;
            }
            Tree[ny][nx].push_back(1);
        }
    }
    
    // winter 
    for(int i=0;i<N;i++){
        for(int j = 0;j<N;j++){
            CA[i][j] += A[i][j];
        }
    }
}

void OUTPUT(){
    int cnt = 0;
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            if(Tree[i][j].empty()) continue;
            cnt += Tree[i][j].size();
        }
    }
    cout << cnt << '\n';
}

int main(void){
    ios::sync_with_stdio(false);cin.tie(0);
    INPUT();
    for(int i = 0;i<K;i++){
        logic();
    }
    OUTPUT();
}
