N = int(input())
queen = [0]*N
result = 0


def is_exist(q):
    for i in range(q):
        if queen[q] == queen[i] or abs(queen[q]-queen[i]) == q - i:
            return False
    return True


def dfs(q):
    if q == N:
        global result
        result += 1
    else:
        for i in range(N):
            queen[q] = i
            if is_exist(q):
                dfs(q+1)


dfs(0)
print(result)