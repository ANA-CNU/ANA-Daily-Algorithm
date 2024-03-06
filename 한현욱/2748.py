# n = int(input())
# if n == 1:
#     print(1)
# else:
#     fib = [0]*n
#     fib[0] = 1
#     fib[1] = 1
#     for i in range(n-2):
#         fib[i+2] = fib[i+1] +fib[i]
#     print(fib[n-1])

n = int(input())
fib = [0]*n
fib[0] = 1
fib[1] = 1
for i in range(n-2):
    fib[i+2] = fib[i+1] +fib[i]

print(fib)
print(fib[n-1])

