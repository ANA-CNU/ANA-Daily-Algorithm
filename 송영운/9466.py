input = __import__('sys').stdin.readline
if __name__ == "__main__":
    t = int(input())
    for _ in range(t):
        n = int(input())
        prefer = [0] + list(map(int, input().split()))
        visit = [False]*(n+1)
        team = []
        for i in range(1, n+1):
            if visit[i] == False:
                stack = [i]
                q = [i]
                while stack:
                    idx = stack.pop()
                    if visit[idx] == True:
                        break
                    visit[idx] = True
                    if visit[prefer[idx]] == True and prefer[idx] in q:
                        team += q[q.index(prefer[idx]):]
                        break
                    q.append(prefer[idx])
                    stack.append(prefer[idx])
        print(n - len(team))