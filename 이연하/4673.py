num = set(range(1,10001))
numm=set()

for i in range(1,10001):
    for j in str(i):
        i=i+int(j)
    numm.add(i)

final=sorted(num-numm)
for i in final:
    print(i)

