import sys
input = sys.stdin.readline

n, m = map(int, input().split())
lis = sorted(list(map(int, input().split())))
stack = []
visited = [False]*n

def back(s, cnt):
    
    if len(stack)==m:
        print(' '.join(map(str, stack)))
        return
    
    last_used = 0
    for i in range(s, n):
        if not visited[i] and last_used != lis[i]:
            visited[i] = True
            stack.append(lis[i])
            last_used = lis[i]
            back(i + 1, cnt + 1)
            stack.pop()
            visited[i] = False


back(0, 0)
