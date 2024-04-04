import sys
input = sys.stdin.readline

a= list(map(int, input().split()))
ans = [0]
S = sum(a)
k=True
while S>0 and k:
    #print(S,a)
    k=False
    if max(a) <= S-max(a):
        for i in range(9,-1,-1):
            if a[i]:  # 카드가 존재하고
                if ans[-1] != i: # 인접하지 않을 때
                    ans.append(i)
                    a[i] -= 1
                    S -= 1
                    k = True
                    break
    else:
        for i in range(9,-1,-1):
            if a[i] == max(a) and ans[-1]!=i:
                ans.append(i)
                a[i] -= 1
                S -= 1
                k = True
                break
        if k:
            continue
        else:
            for i in range(9,-1,-1):
                if ans[-1] != i and a[i]>0:
                    ans.append(i)
                    a[i] -= 1
                    S -= 1
                    k = True
                    break

if len(ans)==1:
    print(0)
else:
    for i in range(1,len(ans)):
        print(ans[i], end="")