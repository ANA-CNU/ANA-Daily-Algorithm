from collections import deque
import sys
input = sys.stdin.readline

for i in range(int(input())):
    A, B = map(int, input().split())

    def bfs():
        q = deque()
        q.append ((A, ''))
        C = ['D', 'S', 'L', 'R']

        visit = [False] * 10000
        
        while q:
            n, com = q.popleft()
            visit[n] = True
            if n == B:
                return com

            tmp = [n*2%10000, (n-1)%10000, n%1000*10+n//1000, n//10+n%10*1000]

            for i in range(4):
                if not visit[tmp[i]]:
                    q.append ((tmp[i], com+C[i]))
                    visit[tmp[i]] = True

    print (bfs())