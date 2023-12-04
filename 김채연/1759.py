import sys
input = sys.stdin.readline

l, c = map(int, input().split())
words = sorted(list(input().split()))
wkdma = ['a', 'e', 'i', 'o', 'u']
res = []


def back(cnt, idx):
    if cnt == l:
        a, not_a = 0, 0
        for i in range(l):
            if res[i] in wkdma:
                a +=1
            else:
                not_a +=1
        if a >=1 and not_a >=2:
            print(''.join(res))

    for i in range(idx, c):
        res.append(words[i])
        back(cnt+1, i+1)
        res.pop()
    
back(0, 0)
