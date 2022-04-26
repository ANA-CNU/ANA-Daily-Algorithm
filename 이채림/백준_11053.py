import sys
if __name__ == '__main__':
    N = int(sys.stdin.readline().rstrip())
    A = list(map(int, sys.stdin.readline().rstrip().split(" ")))
    dp = [1] * N  # A[i] = i번째까지의 가장 긴 증가하는 수열
    
    for i in range(1,N):
        for j in range(i):
            if A[j] < A[i]:
                dp[i] = max(dp[i], dp[j]+1)
    print(max(dp))