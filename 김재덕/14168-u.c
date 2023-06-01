#include <limits.h>
#include <stdio.h>
#include <stdlib.h>

typedef struct { long long int x, y; } Vector2;

typedef enum { HOLSTEIN, GUERNSEY } Breed;

inline long long int vector2_distance_sqr(Vector2 v1, Vector2 v2) {
    const long long int dx = (v1.x - v2.x), dy = (v1.y - v2.y);

    return (dx * dx) + (dy * dy);
}

int main(void) {
    int h, g;

    scanf("%d %d", &h, &g);

    Vector2 *holsteins = calloc(h, sizeof *holsteins);

    for (int i = 0; i < h; i++) 
        scanf("%lld %lld", &holsteins[i].x, &holsteins[i].y);

    Vector2 *guernseys = calloc(g, sizeof *guernseys);

    for (int i = 0; i < g; i++) 
        scanf("%lld %lld", &guernseys[i].x, &guernseys[i].y);

    long long int ***dp = malloc((h + 1) * sizeof *dp);

    for (int i = 0; i <= h; i++) dp[i] = malloc((g + 1) * sizeof **dp);

    for (int y = 0; y <= h; y++)
        for (int x = 0; x <= g; x++) {
            dp[y][x] = calloc(2, sizeof ***dp);

            dp[y][x][HOLSTEIN] = dp[y][x][GUERNSEY] = INT_MAX;
        }

    // 첫 번째 Holstein부터 확인한다.
    dp[1][0][HOLSTEIN] = 0;

    {
        for (int y = 0; y <= h; y++) {
            for (int x = 0; x <= g; x++) {
                // 마지막으로 확인한 품종과 다음으로 확인할 품종 모두 Holstein인 경우...?
                if (y > 1) {
                    const long long int distance = dp[y - 1][x][HOLSTEIN]
                        + vector2_distance_sqr(holsteins[y - 2], holsteins[y - 1]);

                    if (dp[y][x][HOLSTEIN] > distance) dp[y][x][HOLSTEIN] = distance;
                }

                // 마지막으로 확인한 품종과 다음으로 확인할 품종 모두 Guernsey인 경우...?
                if (x > 1) {
                    const long long int distance = dp[y][x - 1][GUERNSEY]
                        + vector2_distance_sqr(guernseys[x - 2], guernseys[x - 1]);

                    if (dp[y][x][GUERNSEY] > distance) dp[y][x][GUERNSEY] = distance;
                }
                
                // 마지막으로 확인한 품종과 다음으로 확인할 품종이 다른 경우...?
                if (x > 0 && y > 0) {
                    const long long int distance = vector2_distance_sqr(
                        holsteins[y - 1], guernseys[x - 1]
                    );

                    if (dp[y][x][HOLSTEIN] > dp[y - 1][x][GUERNSEY] + distance)
                        dp[y][x][HOLSTEIN] = dp[y - 1][x][GUERNSEY] + distance;

                    if (dp[y][x][GUERNSEY] > dp[y][x - 1][HOLSTEIN] + distance)
                        dp[y][x][GUERNSEY] = dp[y][x - 1][HOLSTEIN] + distance;
                }
            }
        }
    }

    // 마지막으로 확인할 품종은 항상 Holstein!
    printf("%lld\n", dp[h][g][HOLSTEIN]);

    for (int y = 0; y <= h; y++)
        for (int x = 0; x <= g; x++)
            free(dp[y][x]);

    for (int i = 0; i <= h; i++) free(dp[i]);

    free(guernseys), free(holsteins), free(dp);

    return 0;
}