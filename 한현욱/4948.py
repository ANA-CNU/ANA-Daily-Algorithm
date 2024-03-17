def eratos(num):
    all_num = [x for x in range(1,num+1)]
    all_num[0] = 0
    a = 0
    while a*a <= num:
        if all_num[a] != 0:
            for i in range(num//(a+1)-1):
                all_num[(i+2)*(a+1)-1] = 0
        a += 1
    # s = set(all_num)
    # s.remove(0)
    # return sorted(list(s))
    return all_num





import sys
n = int(sys.stdin.readline())
arr = []
while n != 0:
    arr.append(n)
    n = int(sys.stdin.readline())
max = arr[0]
for i in range(len(arr)-1):
    if arr[i+1]>max:
        max = arr[i+1]
era = eratos(2*max)

for i in range(len(arr)):
    s = {era[arr[i]+x] for x in range(arr[i])}
    try:
        s.remove(0)
    except:
        pass
    print(len(s))

