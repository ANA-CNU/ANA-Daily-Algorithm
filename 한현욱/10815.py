def check(list, num):
    length = len(list)
    len_left = length//2
    len_right = length - len_left -1
    pick = length // 2
    ret = 0
    while  length > 2:
        if list[pick] > num:
            length = len_left
            len_left = length // 2
            len_right = length - len_left - 1
            pick = pick - length + length//2
        elif list[pick] < num :
            length = len_right
            len_left = length // 2
            len_right = length - len_left - 1
            pick = pick + length//2 + 1
        else :
            ret = 1
            break
    else:
        if length == 2:
            if (list[pick] == num) or (list[pick-1]==num):
                ret = 1
        else:
            if list[pick] == num:
                ret = 1
    return ret
n = int(input())
mycard = sorted(list(map(int,input().split())))
m = int(input())
given = list(map(int,input().split()))
arr=[]
for i in range(len(given)):
    arr.append(check(mycard,given[i]))
print(*arr)
















































