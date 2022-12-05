N = int(input())
D = {}
for _ in range(N):
    s = input()
    for idx, i in enumerate(s[::-1]):
        t = 10**idx
        if i in D: D[i] += t
        else: D[i] = t
L = list(D.values())
L.sort(reverse=True)
result = 0

for idx, i in enumerate(L):
    result += i*(9-idx)

print (result)