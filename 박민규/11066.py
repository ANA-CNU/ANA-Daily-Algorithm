#백준 11066번 파일합치기    
import sys
input = sys.stdin.readline

t = int(input())

for i in range(t):
    n = int(input())
    n_list = list(map(int, input().split()))

    dp = [[0 for _ in range(n)] for _ in range(n)] # 이중 dp문 사용

    # n개의 파일을 합치는 데 필요한 최소 비용을 계산
    for j in range(1,n):
        for k in range(n-j):
            a = j + k
            # dp[k][a]는 k번째 파일부터 a번째 파일까지 합치는 데 필요한 최소 비용을 저장
            # dp[k][a]의 초기값은 99999999로 설정됩니다. 이는 dp[k][a]가 k번째 파일부터 a번째 파일까지 합치는 것이 불가능하다는 것을 의미
            dp[k][a] = 99999999
            arr = sum(n_list[k : a+1])
            # k번째 파일부터 a번째 파일까지의 파일을 두 개의 파일로 나누는 모든 방법을 반복
            for l in range(k,a):
                # 점화식
                dp[k][a] = min(dp[k][a], dp[k][l] + dp[l+1][a] + arr) 
    # 0번째 파일부터 n-1번째 파일까지 합치는 데 필요한 최소 비용
    print(dp[0][n-1])