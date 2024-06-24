import sys

sys.setrecursionlimit(10**5)

n, m = map(int, input().split())
arr = []
for _ in range(n):
    _, *can = map(lambda x: int(x) - 1, input().split())
    arr.append(can)
# print(arr)
match = [-1] * m


def match_job(x):
    for job in arr[x]:
        if ever[job]:
            continue
        ever[job] = True
        if match[job] == -1 or match_job(match[job]):
            match[job] = x
            return True
    return False


ans = 0
for i in range(n):
    ever = [False] * m
    if match_job(i):
        ans += 1
print(ans)