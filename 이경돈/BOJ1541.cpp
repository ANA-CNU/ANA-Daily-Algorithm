#include <iostream>
#include <string>
using namespace std;

int nextNum(string str, int k) {
    string n;
    int i = k;
    while (isdigit(str[i])) {
        n += str[i];
        i++;
    }
    return stoi(n);
}

int main() {
    string str;
    cin >> str;

    string num;
    int result = nextNum(str, 0);
    int isMinus = 0;

    for (int i = 0; i < str.length(); i++) {
        if (str[i] == '+') {
            if (isMinus) {
                result -= nextNum(str, i+1);
            }
            else {
                result += nextNum(str, i+1);
            }
        }
        else if (str[i] == '-') {
            isMinus = 1;
            result -= nextNum(str, i + 1);
        }
    }

    cout << result;
}

