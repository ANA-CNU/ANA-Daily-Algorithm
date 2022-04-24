import sys
N, M = map(int, sys.stdin.readline().split())


def count(n, k):
    cnt = 0
    while n >= k:
        n //= k
        cnt += n
    return cnt


five_cnt = count(N, 5) - count(M, 5) - count(N-M, 5)
two_cnt = count(N, 2) - count(M, 2) - count(N-M, 2)
print(min(five_cnt, two_cnt))