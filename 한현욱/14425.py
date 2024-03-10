import sys
n,m = map(int,input().split())
arr_n = [sys.stdin.readline().rstrip('\n') for _ in range(n)]
arr_n.sort()
arr_m = [sys.stdin.readline().rstrip('\n') for _ in range(m)]
arr_m.sort()

num = 0
arr_m_set = [arr_m[0]]
arr_m_cnt = [1]
for i in range(len(arr_m)-1):
    if arr_m_set[num] == arr_m[i+1]:
        arr_m_cnt[num] += 1
    else:
        num += 1
        arr_m_cnt.append(1)
        arr_m_set.append(arr_m[i+1])
sum = 0
cnt = 0
for i in range(n):
    cnt_const = cnt
    for j in range(len(arr_m_set)-cnt_const):

        if arr_n[i] > arr_m_set[j+cnt_const]:
            cnt += 1
            pass
        elif arr_n[i] == arr_m_set[j+cnt_const] :
            cnt += 1
            sum += arr_m_cnt[j+cnt_const]
        else:
            break
print(sum)








