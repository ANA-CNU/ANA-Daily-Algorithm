import sys
from collections import Counter

T = int(sys.stdin.readline())

for _ in range(T):
    N = int(sys.stdin.readline())
    dic = []

    for _ in range(N):
        x = sys.stdin.readline().strip().split()[1]
        dic.append(x)

    dic = Counter(dic)
    ans = 1

    for i in dic.keys():
        ans *= dic[i] + 1

    print(ans - 1)
