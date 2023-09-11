arr = [0] * 8
for i in range(8):
    arr[i] = int(input())
real_arr = arr.copy()
res = 0
arr.sort(reverse=True)  

for i in range(5):
    res += arr[i]

ind_arr = [0] * 5
for i in range(5):
    ind_arr[i] = real_arr.index(arr[i])+1

ind_arr.sort()

print(res)
for elm in ind_arr:
    print(elm, end=' ')
