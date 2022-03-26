a=[]
for i in range(9):
    a.append(int(input()))
print(max(a))
print(a.index(max(a))+1)