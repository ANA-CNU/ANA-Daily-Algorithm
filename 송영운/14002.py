import copy
input = __import__('sys').stdin.readline
if __name__ == "__main__":
    n = int(input())
    a = list(map(int, input().split()))
    dp = [[a[i]] for i in range(n)]
    dp_length = [1]*n
    for i in range(n):
        for j in range(i):
            if a[i] > a[j]:
                if len(dp[i]) < len(dp[j]) + 1:
                    dp[i] = copy.deepcopy(dp[j])
                    dp[i].append(a[i])
                    dp_length[i] = dp_length[j] + 1
    print(max(dp_length))
    print(*dp[dp_length.index(max(dp_length))])