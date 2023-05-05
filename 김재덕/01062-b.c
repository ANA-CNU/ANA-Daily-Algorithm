#include <stdio.h>
#include <stdlib.h>

#define MAX_WORD_LENGTH  16

static int result = 0;

static int is_prerequisite(char c) {
    return (c == 'a' || c == 'c' || c == 'i' || c == 'n' || c == 't'); 
}

static void solve(
    char *table, char **words, char *chosen, 
    int table_len, int n, int next_index, int low, int high
) {
    if (low == high) {
        int count = 0;

        for (int i = 0; i < n; i++) {
            int check = 1;

            for (int j = 0; words[i][j]; j++) {
                if (!is_prerequisite(words[i][j]) 
                    && !chosen[words[i][j] - 'a']) {
                        check = 0;

                        break;
                    }
            }

            if (check) count++;
        }

        if (result < count) result = count;
    } else {
        for (int i = next_index; i < table_len; i++) {
            if (chosen[table[i] - 'a']) continue;

            chosen[table[i] - 'a'] = 1;

            solve(table, words, chosen, table_len, n, i, low + 1, high);

            chosen[table[i] - 'a'] = 0;
        }
    }
}

int main(void) {
    int n, k;
   
    scanf("%d %d", &n, &k);

    if (k < 5) {
        puts("0");

        return 0;
    }

    char *chosen = calloc('z' - 'a' + 1, sizeof *chosen);
    char *table = calloc('z' - 'a' + 1, sizeof *table);

    char **words = malloc(n * sizeof *words);

    int input_len, word_len = 0, table_len = 0;

    for (int i = 0; i < n; i++) {
        char input[16];

        scanf("%s%n", input, &input_len); input_len--;

        words[i] = calloc(input_len, sizeof **words);

        for (int j = 4; j < input_len - 4; j++) {
            if (!is_prerequisite(input[j])) {
                words[i][word_len++] = input[j];

                if (!chosen[input[j] - 'a'])
                    chosen[input[j] - 'a'] = 1, table[table_len++] = input[j];
            }
        }

        word_len = 0;
    }

    for (int i = 0; i <= 'z' - 'a'; i++) chosen[i] = 0;

    solve(
        table, words, chosen, 
        table_len, n, 0, 0, (table_len < k - 5) ? table_len : k - 5
    );

    printf("%d\n", result);

    for (int i = 0; i < n; i++) free(words[i]);

    free(words), free(table), free(chosen);
    
    return 0;
}