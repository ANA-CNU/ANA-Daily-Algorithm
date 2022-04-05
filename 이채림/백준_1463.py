import sys



if __name__ == '__main__':
    N = int(sys.stdin.readline().rstrip())

    dp = [0 for i in range(N+1)]

    for i in range(2, N+1):
        three = i // 3
        two = i // 2

        if i%3 == 0 and i%2 == 0:
            # i가 3이랑 2로 나누어 떨어질 때
            # dp[i-1] , dp[i%3], dp[i%2] 중에서 작은 값 구하고
            # 거기에 1 더해서 dp[i]에 넣기
            min = dp[three] if dp[three] < dp[two] else dp[two]
            if dp[i-1] < min :
                min = dp[i-1]
            dp[i] = min + 1

        elif i % 3 == 0:
            # i가 3으로만 나누어 떨어질 때
            # dp[i-1] , dp[i%3] 중에서 작은 값 구하고
            # 거기에 1 더해서 dp[i]에 넣기
            min = dp[i-1] if dp[i-1] < dp[three] else dp[three]
            dp[i] = min + 1
            

        elif i%2==0:
            # i가 2로만 나누어 떨어질 때
            # dp[i-1], dp[i%2] 중에서 작은 값 구하고
            # 거기에 1 더해서 dp[i]에 넣기
            min = dp[i-1] if dp[i-1] < dp[two] else dp[two]
            dp[i] = min + 1

        else:
            # i가 3으로도, 2로도 나누어 떨어지지 않을 때
            # dp[i-1]에 1 더해서 dp[i]에 넣기
            dp[i] = dp[i-1] + 1
    
    print(dp[N])
