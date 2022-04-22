from heapq import heappop, heappush
from collections import deque
input = __import__('sys').stdin.readline
if __name__ == "__main__":
    n, m = map(int, input().split())
    before_problem = [set() for _ in range(n+1)]
    after_problem = [set() for _ in range(n+1)]
    visit = [False for _ in range(n+1)]
    s = set()
    for i in range(1, n+1):
        s.add(i)
    for _ in range(m):
        a, b = map(int, input().split())
        before_problem[b].add(a)
        after_problem[a].add(b)
        if visit[b] == False:
            s.remove(b)
            visit[b] = True
    pq = []
    for i in s:
        heappush(pq, i)
    ans = []
    while pq:
        tmp = heappop(pq)
        ans.append(tmp)
        for i in after_problem[tmp]:
            before_problem[i].remove(tmp)
            if len(before_problem[i]) == 0:
                heappush(pq, i)
    print(*ans)
