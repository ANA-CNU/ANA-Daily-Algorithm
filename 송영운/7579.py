import sys

input = __import__('sys').stdin.readline
if __name__ == "__main__":
    n, m = map(int, input().split())
    a = [0] + list(map(int, input().split()))
    c = [0] + list(map(int, input().split()))
    max_w = sum(c)
    min_idx = sys.maxsize
    dp = [[0]*(max_w+1) for _ in range(n+1)]
    for i in range(1, n+1):
        for j in range(1, max_w+1):
            if j >= c[i]:
                dp[i][j] = max(dp[i-1][j], a[i] + dp[i-1][j-c[i]])
            else:
                dp[i][j] = dp[i-1][j]
            if dp[i][j] >= m:
                if min_idx > j:
                    min_idx = j
    print(min_idx)


