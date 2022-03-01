def factorial(n):
    if n < 1:
        return 1
    else:
        return n*factorial(n-1)

n = int(input())
num = str(factorial(n))

for i in range(len(num)):
    if num[::-1][i] != '0':
        print(i)
        break