input = __import__('sys').stdin.readline
if __name__ == "__main__":
    n = int(input())
    num = list(map(int, input().split()))
    dp = [[i] for i in range(n)]
    for i in range(n):
        for j in range(i):
            if num[i] == num[j] and (i-1 == j or j+1 in dp[i-1]):
                dp[i].append(j)
    m = int(input())
    for _ in range(m):
        s, e = map(int, input().split())
        if s - 1 in dp[e-1]:
            print(1)
        else:
            print(0)