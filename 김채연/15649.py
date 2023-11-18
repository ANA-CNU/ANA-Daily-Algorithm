n,m = list(map(int,input().split()))
 
stack = []
 
def DFS():
    if len(stack)==m:
        print(' '.join(map(str,stack)))
        return
    
    for i in range(1,n+1):
        if i not in stack:
            stack.append(i)
            DFS()
            stack.pop()
 
DFS()
