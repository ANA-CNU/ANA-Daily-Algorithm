    #include <iostream>
    #include <vector>
    #include <algorithm>
    #include <cmath>
    #include <string>
    using namespace std;

    int n[8001];

    int main() {
        cin.tie(NULL);
        cout.tie(NULL);
        ios::sync_with_stdio(false);

        int k, tmp;
        cin >> k;

        vector<int> v;
        vector<pair<int, int>> a;

        int sum = 0;

        while (k-- > 0) {
            cin >> tmp;
            sum += tmp;
            v.push_back(tmp);
            n[tmp + 4000]++;
        }

        int max = 0;
        int maxIndex;

        for (int i = 0; i < 8001; i++) {
            if (n[i] > max) {
                max = n[i];
            }
        }

        int isSecond = 0;

        //cout << "<<<<" << max << "\n";

        for (int i = 0; i < 8001; i++) {
            if (n[i] == max) {
                maxIndex = i;
                break;
            }
        }

        for (int i = maxIndex + 1; i < 8001; i++) {
            if (n[i] == max) {
                maxIndex = i;
                break;
            }
        }


        sort(v.begin(), v.end());

        int avg = round((float)sum / v.size());
        cout << avg << "\n";
        cout << v[(v.size() - 1) / 2] << "\n";
        cout << maxIndex - 4000 << "\n";
        cout << (v.back() - v.front());
    }
