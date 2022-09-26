N = int(input())
S = list(map(int, input().split()))

result = 0

def expand(l, r):
    left = l
    right = r
    while 0 <= left and right < N and S[left]==S[right]:
        left -= 1
        right += 1
        if left != N-1 and S[left]>=S[left+1]:
            break
    return right-left-1
    
for i in range(N):
    result = max(result, expand(i, i), expand(i, i+1))
    
print (result)