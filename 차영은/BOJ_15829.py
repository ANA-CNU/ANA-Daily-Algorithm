import sys

n = int(sys.stdin.readline())
s = sys.stdin.readline().strip()
a = 96
ans = 0
dic = {}

for i in range(1, 27):
    dic[chr(a + i)] = i

for i in range(n):
    ans += dic[s[i]] * (31 ** i)

print(ans % 1234567891)
