import sys
n = int(sys.stdin.readline())
tri = []
tri.append([int(sys.stdin.readline())])

if n == 1:
    print(tri[0][0])
    exit()

for _ in range(n-1):
    tri.append(list(map(int, sys.stdin.readline().split())))
tri2 = tri.copy()
for i in range(1, n-1):
    for j in range(len(tri[i+1])):
        if j == 0:
            tri2[i+1][j] += tri[i][0]
        elif j == len(tri[i+1])-1:
            tri2[i+1][j] += tri[i][-1]
        else:
            tri2[i+1][j] = tri[i+1][j] + max(tri2[i][j-1], tri2[i][j])

print(max(tri2[-1])+tri2[0][0])