#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;



typedef long long ll;

vector<ll> num(100001);
vector<ll> treeIdx(400004);




int n;
ll max_area = 0;



int init(int node, int start, int end) {
    if (start == end) return treeIdx[node] = start;


    int mid = (start + end) / 2;
    int leftIdx = init(node * 2, start, mid);
    int rightIdx = init(node * 2 + 1, mid + 1, end);

    return treeIdx[node] = (num[leftIdx] < num[rightIdx]) ? leftIdx : rightIdx;
}




int findMinIdx(int node, int start, int end, int left, int right) {

    if (left > end || right < start) return -1;
    if (left <= start && end <= right) return treeIdx[node];

    int mid = (start + end) / 2;


    int leftIdx = findMinIdx(node * 2, start, mid, left, right);
    int rightIdx = findMinIdx(node * 2 + 1, mid + 1, end, left, right);

    if (leftIdx == -1) return rightIdx;
    if (rightIdx == -1) return leftIdx;


    return (num[leftIdx] < num[rightIdx]) ? leftIdx : rightIdx;
}


void maxArea(int left, int right) {
    if (left > right) return;

    int idx = findMinIdx(1, 0, n - 1, left, right);



    ll area = (right - left + 1) * num[idx];



    max_area = max(max_area, area);
    maxArea(left, idx - 1);
    maxArea(idx + 1, right);
}







int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);





    cin >> n;


    for (int i = 0; i < n; i++) {
        cin >> num[i];
    }



    init(1, 0, n - 1);
    maxArea(0, n - 1);

    cout << max_area << "\n";






}
