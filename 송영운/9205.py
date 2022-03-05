from collections import deque
input = __import__('sys').stdin.readline
onetime_distance = 20*50
if __name__ == "__main__":
    t = int(input())
    for _ in range(t):
        happy = False
        n = int(input())
        visit = [False]*(n+1)
        s_x, s_y = map(int, input().split())
        conv = list()
        for i in range(n):
            x, y = map(int, input().split())
            conv.append((x, y))
        d_x, d_y = map(int, input().split())
        q = deque()
        q.append((s_x, s_y))
        while q:
            x, y = q.popleft()
            if x == s_x and y == s_y and visit[n] == False:
                visit[n] = True
            elif x == s_x and y == s_y:
                continue
            distance = abs(d_x - x) + abs(d_y - y)
            if distance <= onetime_distance:
                happy = True
                print('happy')
                break
            for i in range(len(conv)):
                if visit[i] == True:
                    continue
                c_distance = abs(conv[i][0] - x) + abs(conv[i][1] - y)
                if c_distance <= onetime_distance:
                    q.append((conv[i][0], conv[i][1]))
                    visit[i] = True
        if happy == True:
            continue
        print('sad')