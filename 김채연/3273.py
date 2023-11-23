import sys

input = sys.stdin.readline

n = int(input())
num_list = [0]*2000001
for num in map(int,input().split()):
    num_list[num] = 1
_sum = int(input())
i = 1
j = _sum - 1
ans = 0

while i<j:
    if num_list[i] + num_list[j] > 1:
        ans += 1
    i,j = i+1,j-1

print(ans)
