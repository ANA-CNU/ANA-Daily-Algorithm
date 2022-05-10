from collections import deque
input = __import__('sys').stdin.readline
if __name__ == "__main__":
    n = int(input())
    m = int(input())
    visit_possible = [[] for _ in range(n)]
    for i in range(n):
        connect = list(map(int, input().split()))
        for j in range(len(connect)):
            if connect[j] == 1:
                visit_possible[i].append(j)
    plan = list(map(int, input().split()))
    s = set()
    q = deque()
    q.append(plan[0]-1)
    visit = [False] * n
    while q:
        x = q.pop()
        s.add(x)
        if visit[x] == True:
            continue
        visit[x] = True
        for i in visit_possible[x]:
            q.append(i)
    for i in plan:
        if i-1 not in s:
            print('NO')
            exit()
    print('YES')