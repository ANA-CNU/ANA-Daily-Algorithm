a= int(input())
b= int(input())
c= int(input())
num=list(str(a*b*c))

for i in range(10):
    print(num.count(str(i)))