an, bn = map(int, input().split())
A_dic = {}
B_dic = {}
for n in map(int, input().split()):
    A_dic[n] = 1
for n in map(int, input().split()):
    B_dic[n] = 1

res = []
for a in A_dic:
    if a not in B_dic:
        res.append(a)

print(len(res))
if len(res) !=0:
    print(*sorted(res))
