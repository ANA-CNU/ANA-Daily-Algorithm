input = __import__('sys').stdin.readline
if __name__ == "__main__":
    n = int(input())
    dp = [0]*(n+1)
    dp_answer = [[1] for _ in range(n+1)]

    for i in range(2, n+1):
        dp[i] = dp[i-1] + 1
        dp_answer[i] = dp_answer[i-1] + [i]
        if i%2 == 0 and dp[i] > dp[i//2]+1:
            dp[i] = dp[i//2] + 1
            dp_answer[i] = dp_answer[i//2] + [i]
        if i%3 == 0 and dp[i] > dp[i//3]+1:
            dp[i] = dp[i//3] + 1
            dp_answer[i] = dp_answer[i//3] + [i]
    print(dp[n])
    print(*reversed(dp_answer[n]))
