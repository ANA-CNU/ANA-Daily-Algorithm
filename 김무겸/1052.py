N, K = map(int, input().split())
cnt = 0
while bin(N).count("1") > K:
    N += 1
    cnt += 1
print(cnt)