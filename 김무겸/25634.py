import sys
input = sys.stdin.readline
n = int(input())
a = list(map(int, input().split()))
st = list(map(int, input().split()))
ans = [0] * n
if 0 not in st:
    print(sum(a) - min(a))
else:
    idx = st.index(0)
    idx_r = n - st[::-1].index(0) - 1
    ans[idx] = a[idx]
    sum = 0
    for i in range(n):
        if st[i] == 1:
            sum += a[i]
    for i in range(idx + 1, idx_r + 1):
        if st[i] == 0:
            ans[i] = max(ans[i-1] + a[i], a[i])
        else:
            ans[i] = ans[i-1] - a[i]
    print(max(ans) + sum)