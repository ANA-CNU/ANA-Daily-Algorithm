#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int cal(int x1, int y1, int z1, int x2, int y2, int z2) {
    int x = abs(x1 - x2);
    int y = abs(y1 - y2);
    int z = abs(z1 - z2);
    return min(min(x, y), z);
}

int find(int x, vector<int>& parent) {
    int root = x;
    while (root != parent[root]) {
        root = parent[root];
    }
    while (x != root) {
        int next = parent[x];
        parent[x] = root;
        x = next;
    }
    return root;
}

void unionSets(int a, int b, vector<int>& parent) {
    a = find(a, parent);
    b = find(b, parent);
    if (a != b)
        parent[b] = a;
}

int main() {
    int n;
    cin >> n;
    vector<vector<int>>vec1;
    vector<vector<int>>vec2;
    vector<vector<int>>vec3;
    vector<pair<int, pair<int, int>>> map;
    for (int i = 0; i < n; i++) {
        int arr[3];
        cin >> arr[0] >> arr[1] >> arr[2];
        vec1.push_back({arr[0],arr[1],arr[2],i});
        vec2.push_back({arr[1],arr[2],arr[0],i});
        vec3.push_back({arr[2],arr[0],arr[1],i});
    }
    sort(vec1.begin(),vec1.end());
    sort(vec2.begin(),vec2.end());
    sort(vec3.begin(),vec3.end());
    for (int j = 0; j < n-1; j++) {
        map.push_back({cal(vec1[j][0], vec1[j][1], vec1[j][2], vec1[j+1][0], vec1[j+1][1], vec1[j+1][2]), {vec1[j][3]+1, vec1[j+1][3]+1}});
        map.push_back({cal(vec1[j][0], vec1[j][1], vec1[j][2], vec1[j+1][0], vec1[j+1][1], vec1[j+1][2]), {vec1[j+1][3]+1, vec1[j][3]+1}});
    }
    for (int j = 0; j < n-1; j++) {
        map.push_back({cal(vec2[j][0], vec2[j][1], vec2[j][2], vec2[j+1][0], vec2[j+1][1], vec2[j+1][2]), {vec2[j][3]+1, vec2[j+1][3]+1}});
        map.push_back({cal(vec2[j][0], vec2[j][1], vec2[j][2], vec2[j+1][0], vec2[j+1][1], vec2[j+1][2]), {vec2[j+1][3]+1, vec2[j][3]+1}});
    }
    for (int j = 0; j < n-1; j++) {
        map.push_back({cal(vec3[j][0], vec3[j][1], vec3[j][2], vec3[j+1][0], vec3[j+1][1], vec3[j+1][2]), {vec3[j][3]+1, vec3[j+1][3]+1}});
        map.push_back({cal(vec3[j][0], vec3[j][1], vec3[j][2], vec3[j+1][0], vec3[j+1][1], vec3[j+1][2]), {vec3[j+1][3]+1, vec3[j][3]+1}});
    }
    sort(map.begin(), map.end());
    vector<int> parent(n + 1);
    for (int i = 1; i <= n; i++)
        parent[i] = i;
    long long result = 0;
    for (auto edge : map) {
        int weight = edge.first;
        int u = edge.second.first;
        int v = edge.second.second;
        if (find(u, parent) != find(v, parent)) {
            unionSets(u, v, parent);
            result += weight;
        }
    }
    cout << result;
    return 0;
}
