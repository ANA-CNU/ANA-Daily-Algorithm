input = __import__('sys').stdin.readline
if __name__ == "__main__":
    n = int(input())
    a = list(map(int, input().split()))
    reverse_a = list(reversed(a))

    dp = [1]*n
    dp_r = [1]*n
    for i in range(n):
        for j in range(i):
            if a[i] > a[j]:
                dp[i] = max(dp[i], dp[j] + 1)
            if reverse_a[i] > reverse_a[j]:
                dp_r[i] = max(dp_r[i], dp_r[j] + 1)

    max_length = 0
    for i in range(n):
        max_length = max(max_length, dp[i] + dp_r[n-1 - i] - 1)
    print(max_length)