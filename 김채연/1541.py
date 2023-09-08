arrminus = list(input().split('-'))
for i in range(len(arrminus)):
    arrminus[i] = map(int, arrminus[i].split('+'))
    arrminus[i] = sum(arrminus[i])
    
res = arrminus[0]
if len(arrminus)>1:
    for i in range(1, len(arrminus)):
        res = res -arrminus[i]

print(res)
