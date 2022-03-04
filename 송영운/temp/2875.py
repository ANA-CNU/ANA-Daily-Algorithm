input = __import__('sys').stdin.readline
if __name__ == "__main__":
    n, m, k = map(int, input().split())
    for _ in range(k):
        if m * 2 <= n:
            n -= 1
        else:
            m -= 1
    if m * 2 <= n:
        print(m)
    else:
        print(int(n/2))
