import sys

n, t = map(int, sys.stdin.readline().split())
arr = list(map(int, sys.stdin.readline().split()))
queries = [list(map(int, sys.stdin.readline().split())) for _ in range(t)]

sqrt_n = int(n ** 0.5)
nums = [0] * (pow(10, 6) + 2)


def add(k):
    nums[arr[k]] += 1
    global ans
    ans += (nums[arr[k]] * nums[arr[k]] - (nums[arr[k]] - 1) * (nums[arr[k]] - 1)) * arr[k]

def sub(k):
    nums[arr[k]] -= 1
    global ans
    ans += (nums[arr[k]] * nums[arr[k]] - (nums[arr[k]] + 1) * (nums[arr[k]] + 1)) * arr[k]


x = y = ans = 0
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