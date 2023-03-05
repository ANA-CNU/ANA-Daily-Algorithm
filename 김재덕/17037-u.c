#include <stdio.h>
#include <stdint.h>

#define CELL_SIZE 1001

typedef struct { 
    int x, y; 
} Vector2;

int main(void) {
    int n, k;

    scanf("%d %d", &n, &k);

    // 최댓값이 1000이므로 16비트 정수형 사용 가능
    uint16_t diff[CELL_SIZE][CELL_SIZE] = { 0 };

    Vector2 min = { 0 }, max = min;

    for (int i = 0; i < n; i++) {
        Vector2 p, q;

        scanf("%d %d %d %d", &p.x, &p.y, &q.x, &q.y);

        diff[p.y][p.x]++, diff[p.y][q.x]--, diff[q.y][p.x]--, diff[q.y][q.x]++;

        if (i == 0) {
            min = p, max = q;
        } else {
            if (min.x > p.x) min.x = p.x;
            if (min.y > p.y) min.y = p.y;
            if (max.x < q.x) max.x = q.x;
            if (max.y < q.y) max.y = q.y;
        }
    }

    uint16_t cells[CELL_SIZE][CELL_SIZE] = { 0 };

    for (int y = min.y; y < max.y; y++)
        for (int x = min.x; x < max.x; x++) {
            cells[y][x] = ((y > 0) ? cells[y - 1][x] : 0)
                + ((x > 0) ? cells[y][x - 1] : 0)
                - ((x > 0 && y > 0) ? cells[y - 1][x - 1] : 0) 
                + diff[y][x];
        }

    int result = 0;

    for (int y = min.y; y <= max.y; y++)
        for (int x = min.x; x <= max.x; x++)
            if (cells[y][x] == k) result++;

    printf("%d\n", result);

    return 0;
}