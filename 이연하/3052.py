n=[]

for i in range(10):
    a=int(input())
    b=a%42
    n.append(b)

a=set(n)
print(len(a))