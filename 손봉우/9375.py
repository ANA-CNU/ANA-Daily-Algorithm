T = int(input())

for i in range(T):
    N = int(input())
    data = {}

    for j in range(N):
        line = input().split()
        if line[1] in data:
            data[line[1]] += 1
        else:
            data[line[1]] = 1
    a = 1
    for j in data:
        a *= data[j]+1
    print (a-1)