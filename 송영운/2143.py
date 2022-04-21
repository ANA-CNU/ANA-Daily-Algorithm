input = __import__('sys').stdin.readline
if __name__ == "__main__":
    t = int(input())
    n, a = int(input()), list(map(int, input().split()))
    m, b = int(input()), list(map(int, input().split()))
    prefix_a, prefix_b = [], dict()
    for i in range(n):
        sum = 0
        for j in range(i, n):
            sum += a[j]
            prefix_a.append(sum)
    for i in range(m):
        sum = 0
        for j in range(i, m):
            sum += b[j]
            if prefix_b.get(sum):
                prefix_b[sum] += 1
            else:
                prefix_b[sum] = 1
    ans = 0
    for e in prefix_a:
        error = t - e
        if error in prefix_b:
            ans += prefix_b[error]
    print(ans)