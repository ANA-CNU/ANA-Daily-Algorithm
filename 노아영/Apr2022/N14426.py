import sys
n, m = map(int, sys.stdin.readline().split())
s = set()
for _ in range(n):
    tmp = sys.stdin.readline().rstrip()
    for i in range(len(tmp)):
        s.add(tmp[:i+1])
cnt = 0    
for _ in range(m):
    w = sys.stdin.readline().rstrip()
    if w in s:
        cnt += 1
print(cnt)