A, B= map(int, input().split())
C=int(input())
a = (A+int((B+C)/60))%24
b = int((B+C)%60)
print(a,b)