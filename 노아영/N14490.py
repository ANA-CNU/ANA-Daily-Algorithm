import sys
n, m = map(int, sys.stdin.readline().split(":"))

for i in range(min(n, m), 0, -1):
    if n%i == 0 and m%i == 0:
        print("{}:{}".format(n//i, m//i))
        exit()