n, m = map(int, input().split())

stack = []
def Back(cnt):
    if len(stack)==m:
        print(' '.join(map(str,stack)))
        return
    
    for i in range(cnt, n+1):
        stack.append(i)
        Back(i)
        stack.pop()
Back(1)
