from collections import deque
input = __import__('sys').stdin.readline
if __name__ == "__main__":
    f, s, g, u, d = map(int, input().split())
    visit = [False]*(f+1)
    q = deque()
    q.append((s, 0))
    while q:
        now, count = q.popleft()
        if now == g:
            print(count)
            exit()
        if visit[now] == True:
            continue
        visit[now] = True
        up_now = now + u
        down_now = now - d
        if 0 < up_now <= f:
            q.append((up_now, count + 1))
        if 0 < down_now <= f:
            q.append((down_now, count + 1))
    print('use the stairs')