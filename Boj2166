#include <iostream>
#include <cmath>
#include <cstdio>
using namespace std;
double polygon_area(double x[], double y[], int n) {
    double area = 0;
    for (int i = 0; i < n - 1; i++) {
        area += (x[i] * y[i + 1]) - (y[i] * x[i + 1]);
    }
    area += (x[n - 1] * y[0]) - (y[n - 1] * x[0]);
    area = abs(area) / 2.0;
    return area;
}
int main() {
    int n;
    cin >> n;
    double x[n], y[n];
    for (int i = 0; i < n; i++) {
        cin >> x[i] >> y[i];
    }
    double result = polygon_area(x, y, n);
    printf("%.1f\n", result);

    return 0;
}
