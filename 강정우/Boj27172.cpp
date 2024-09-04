#include <iostream>
#include <vector>
using namespace std;
vector<int> numbers;
int score[1000006];
int card[1000006];
int main(){
    int n;
    cin >> n;
    for (int i = 0; i < n; i++)    {
        int t;
        cin >> t;
        numbers.push_back(t);
        card[t] = 1;
    }
    for (int i = 0; i < n; i++){
        for (int j = numbers[i] * 2; j < 1000001; j += numbers[i]){
            if (card[j] == 1){
                score[numbers[i]]++;
                score[j]--;
            }
        }
    }
    for (int i = 0; i < n; i++)
        cout<<score[numbers[i]]<<" ";
    return 0;
}
