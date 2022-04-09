input = __import__('sys').stdin.readline
if __name__ == "__main__":
    n = int(input())
    a = [int(input()) for _ in range(n)]
    s = set()
    ans = 0
    for i in range(n):
        for j in range(n):
            s.add(a[i] + a[j])
    for i in range(n-1, -1, -1):
        for j in range(n-1, -1, -1):
            if a[i] - a[j] in s:
                ans = max(ans, a[i])
    print(ans)