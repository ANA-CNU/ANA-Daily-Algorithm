import sys

n = int(sys.stdin.readline())
a_lst = list(map(int, sys.stdin.readline().strip().split()))
b_lst = list(map(int, sys.stdin.readline().strip().split()))
a_lst.sort()

b_lst_sort = []
for i, b in enumerate(b_lst):
    b_lst_sort.append((b, i))
b_lst_sort.sort(key=lambda a:-a[0])

ans = 0
for i, b in enumerate(b_lst_sort):
    ans += b[0]*a_lst[i]
print(ans)