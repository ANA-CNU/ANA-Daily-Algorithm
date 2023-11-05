#include <bits/stdc++.h>
using namespace std;
int isOk=0;
void f(string x, string y) {
    int x_size = x.size();
    int y_size = y.size();
    if(x_size > y_size) return;
    if(x_size == y_size) {
        if(x == y) {
            isOk = 1;
            return;
        }
        return;
    }

    char a = y[0];
    char b = y[y_size-1];
    if(a == 'A') {
        if(b == 'B') return;
        f(x, y.substr(0, y_size-1));
    }
    else {
        if(b == 'A') {
            f(x, y.substr(0, y_size-1));

            reverse(y.begin(), y.end());
            y = y.substr(0, y_size-1);
            f(x, y);
        }
        else {
            reverse(y.begin(), y.end());
            y = y.substr(0, y_size-1);
            f(x, y);
        }
    }

}
int main()
{
    string a, b;
    cin >> a;
    cin >> b;

    f(a, b);
    printf("%d",isOk);
    return 0;
}
