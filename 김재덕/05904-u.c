#include <stdio.h>
#include <stdlib.h>

int f(int x) {
    return (x >= 0)
        ? ((2 * f(x - 1)) + (x + 3))
        : 0;
}

char solve(int x, int n) {
    int k = f(x), low = k + 1, high = (2 * k) + (x + 4);

    if (n < low) return solve(x - 1, n);
    else if (n > high) return solve(x + 1, n);
    else {
        int mid = low + (x + 3);

        if (n > mid) return solve(x - 1, n - mid);
        else return (n == low) ? 'm' : 'o';
    }
}

int main(void) {
    int n;

    scanf("%d", &n);

    printf("%c\n", solve(0, n));

    return 0;
}