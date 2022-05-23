import sys

s = sys.stdin.readline().rstrip()
q = int(sys.stdin.readline().rstrip())

sum = [[0 for i in range(26)] for i in range(len(s))]

sum[0][ord(s[0])-97] = 1

for i in range(1,len(s)):
    sum[i][ord(s[i])-97] = 1

for i in range(1, len(s)):
    for j in range(26):
        sum[i][j] += sum[i-1][j]

for i in range(q):
    arr = list(sys.stdin.readline().rstrip().split(" "))
    alpha = arr[0]
    l = int(arr[1])
    r = int(arr[2])

    if l == 0:
        print(sum[r][ord(alpha)-97])
    else:
        print(sum[r][ord(alpha)-97]-sum[l-1][ord(alpha)-97])