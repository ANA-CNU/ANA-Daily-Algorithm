N = int(input())
M = int(input())
S = list(input())

cnt = 0
i=0
result = 0

while i < (M-2):

    if S[i]=='I' and S[i+1]=='O' and S[i+2]=='I':
        cnt += 1
        i += 1
        if cnt == N:
            result += 1
            cnt -= 1
    else:
        cnt = 0 
    i += 1

print (result)