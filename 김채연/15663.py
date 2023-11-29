import sys
input = sys.stdin.readline

n, m = map(int, input().split())
nums = sorted(list(map(int, input().split())))
visited = [False]*n
stack = []

def dfs():
    if len(stack)==m:
        print(' '.join(map(str, stack)))
        return
    
    now = 0
    for i in range(n):
        if not visited[i] and now != nums[i]:
            visited[i] = True
            stack.append(nums[i])
            now = nums[i]
            dfs()
            visited[i] = False
            stack.pop()

dfs()
