#include <iostream>
#include <string>
#include <vector>
#include <sstream>
using namespace std;

int main() {

    int n;
    cin >> n;
    cin.ignore();

    vector<int> stack;

    for (int i = 0; i < n; i++) {
        string input;
        getline(cin, input);

        istringstream ss(input);
        string stringBuffer;
        vector<string> command;

        while (getline(ss, stringBuffer, ' ')) {
            command.push_back(stringBuffer);
        }

        if (!command[0].compare("push")) {
            stack.push_back(stoi(command[1]));
        } else if (!command[0].compare("pop")) {
            if (stack.empty()) {
                cout << -1 << endl;
            } else {
                cout << stack.back() << endl;
                stack.pop_back();
            }
        } else if (!command[0].compare("size")) {
            cout << stack.size() << endl;
        } else if (!command[0].compare("top")) {
            if (stack.empty()) {
                cout << -1 << endl;
            } else {
                cout << stack.back() << endl;
            }
        } else if (!command[0].compare("empty")) {
            if (stack.empty()) {
                cout << 1 << endl;
            } else {
                cout << 0 << endl;
            }
        }
    }

    return 0;
}