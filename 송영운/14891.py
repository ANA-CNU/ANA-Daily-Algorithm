def check():
    score = 0
    if t[0][0]==1:
        score += 1
    if t[1][0]==1:
        score += 2
    if t[2][0]==1:
        score += 4
    if t[3][0]==1:
        score += 8
    return score

def reverse_cycle(n):
    temp = t[n][0]
    for i in range(t_size):
        if i == t_size - 1:
            t[n][i] = temp
            break
        t[n][i] = t[n][i+1]

def cycle(n):
    temp = t[n][t_size-1]
    for i in range(t_size-1, -1, -1):
        if i == 0:
            t[n][i] = temp
            break
        t[n][i] = t[n][i - 1]

from collections import deque
input = __import__('sys').stdin.readline
t_size = 8
t_count = 4
if __name__ == "__main__":
    t = [list(map(int, list(input().strip()))) for _ in range(4)]
    k = int(input())
    for _ in range(k):
        n, d = map(int, input().split())
        n -= 1

        isTurnTrue = [False]*t_count
        q = deque()
        q.append(n)
        visit = [False] * t_count
        visit[n] = True
        while q:
            x = q.popleft()
            isTurnTrue[x] = True
            before_left = t[x][6]
            before_right = t[x][2]
            left = x - 1
            right = x + 1
            if left >= 0 and visit[left] != True:
                visit[left] = True
                if t[left][2] != before_left:
                    q.append(left)
            if right < t_count and visit[right] != True:
                visit[right] = True
                if t[right][6] != before_right:
                    q.append(right)
        q = deque()
        q.append((n, d))
        visit = [False] * t_count
        visit[n] = True
        while q:
            x, d = q.popleft()
            if d == -1:
                reverse_cycle(x)
            else:
                cycle(x)
            left = x - 1
            right = x + 1
            if left >= 0 and visit[left] != True:
                visit[left] = True
                if isTurnTrue[left] == True:
                    q.append((left, -d))
            if right < t_count and visit[right] != True:
                visit[right] = True
                if isTurnTrue[right] == True:
                    q.append((right, -d))
    print(check())