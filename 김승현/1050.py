import sys
from collections import deque
input = sys.stdin.readline

n, m = map(int, input().split())
dic = {}  # 비용
# q = deque()
dic["LOVE"] = -1
for _ in range(n):
    a, b = map(str, input().split())
    dic[a] = int(b)

dic2 = {}  # 레시피
for _ in range(m):
    label, recipe = input().split("=")
    if label not in dic:
        dic[label] = -1
    tmp = []
    for i in list(recipe.rstrip().split("+")):
        tmp.append((int(i[0]),i[1:]))
        if i[1:] not in dic:
            dic[i[1:]] = -1
    if label not in dic2:
        dic2[label] = [tmp]
    else:
        dic2[label].append(tmp)
for _ in range(50):
    for key in dic2:
        for arr in dic2[key]:
            cost = 0
            flag = True  # 제작 가능
            for c, x in arr:
                if dic[x] != -1:
                    cost += c*dic[x]
                else:
                    flag =False
                    break
            if cost >1000000000:
                cost = 1000000001
            if flag:
                if dic[key] == -1:
                    dic[key] = cost
                else:
                    dic[key] = min(dic[key],cost)


print(dic["LOVE"])


