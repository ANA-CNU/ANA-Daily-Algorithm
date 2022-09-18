import sys

n, m = map(int, sys.stdin.readline().split())
dic = {}

for _ in range(n):
    site = sys.stdin.readline().strip().split()
    dic[site[0]] = site[1]

for _ in range(m):
    s = sys.stdin.readline().strip()
    print(dic[s])
