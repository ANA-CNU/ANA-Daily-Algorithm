# 실버 4 1269 대칭 차집합

n,m = map(int, input().split())

Nd = {}
Md = {}

InputN = map(int, input().split())
InputM = map(int, input().split())

count = 0

for i in InputN:
    Nd[i] = 1
for i in InputM:
    Md[i] = 1

for i in Nd:
   if Md.get(i) == 1:
       count += 2

print(Nd.__len__() + Md.__len__() - count)