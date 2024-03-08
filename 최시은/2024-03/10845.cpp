#include <iostream>
#include <string>
#include <vector>
#include <sstream>
using namespace std;

int main() {

    int n;
    cin >> n;
    cin.ignore();

    vector<int> queue;

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
            queue.push_back(stoi(command[1]));
        } else if (!command[0].compare("pop")) {
            if (queue.empty()) {
                cout << -1 << endl;
            } else {
                cout << queue.front() << endl;
                queue.erase(queue.begin());
            }
        } else if (!command[0].compare("size")) {
            cout << queue.size() << endl;
        } else if (!command[0].compare("front")) {
            if (queue.empty()) {
                cout << -1 << endl;
            } else {
                cout << queue.front() << endl;
            }
        } else if (!command[0].compare("back")) {
            if (queue.empty()) {
                cout << -1 << endl;
            } else {
                cout << queue.back() << endl;
            }
        } else if (!command[0].compare("empty")) {
            if (queue.empty()) {
                cout << 1 << endl;
            } else {
                cout << 0 << endl;
            }
        }
    }

    return 0;
}