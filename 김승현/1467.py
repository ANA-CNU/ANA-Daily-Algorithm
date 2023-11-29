import sys
from collections import deque
input = sys.stdin.readline

N = input().strip()
s = input().strip()
Idx = {str(i):deque() for i in range(10)}
cnt = {str(i):0 for i in range(10)}
for i in range(len(N)):
    Idx[N[i]].append(i)
for i in range(len(s)):
    cnt[s[i]] += 1
ans = ''
N = list(N)
N = deque(N)
for _ in range(len(N)-len(s)):
    for i in range(9,-1,-1):
        if cnt[str(i)] == N.count(str(i)) and cnt[str(i)]:
            continue
        try:
            idx = N.index(str(i))
        except:
            continue
        Cnt = [0 for _ in range(10)]
        key =True
        for j in range(idx):
            Cnt[int(N[j])] += 1
            if Cnt[int(N[j])] > cnt[N[j]]:
                key = False
                break
        if key:
            break
    ans += str(i)
    for j in range(10):
        cnt[str(j)] -= Cnt[j]
    for __ in range(sum(Cnt)+1):
        N.popleft()


print(ans)