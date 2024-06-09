import sys

while True:
    try:
        n, m = map(int, sys.stdin.readline().split())
        arr = list(map(int, sys.stdin.readline().split()))
        queries = [list(map(int, sys.stdin.readline().split())) for _ in range(m)]

        sqrt_n = int(n ** 0.5)
        for i in range(n):
            arr[i] += 100000
        num = [0] * 200005
        cnt = [0] * 100005


        def add(k):
            global ans
            num[arr[k]] += 1
            cnt[num[arr[k]] - 1] -= 1
            cnt[num[arr[k]]] += 1
            ans = max(num[arr[k]], ans)


        def sub(k):
            global ans
            num[arr[k]] -= 1
            cnt[num[arr[k]] + 1] -= 1
            cnt[num[arr[k]]] += 1
            if cnt[num[arr[k]] + 1] == 0 and ans == num[arr[k]] + 1:
                ans -= 1


        x = y = 0
        ans = 0
        for idx, q in enumerate(sorted(queries, key=lambda x: (x[0] // sqrt_n, x[1]))):
            l, r = q[0] - 1, q[1] - 1
            if idx == 0:
                x = l
                y = l - 1
            while y < r:
                y += 1
                add(y)
            while y > r:
                sub(y)
                y -= 1
            while x > l:
                x -= 1
                add(x)
            while x < l:
                sub(x)
                x += 1

            q.append(ans)

        print(*map(lambda x: x[-1], queries), sep='\n')
    except:
        break