input = __import__('sys').stdin.readline
if __name__ == "__main__":
    n, m = map(int, input().split())
    student = [set() for _ in range(n+1)]
    next_student = [set() for _ in range(n+1)]
    for _ in range(m):
        a, b = map(int, input().split())
        student[b].add(a)
        next_student[a].add(b)
    s = set()
    for i in range(1, n+1):
        if len(student[i]) == 0:
            s.add(i)
    ans = []
    while s:
        tmp = s.pop()
        ans.append(tmp)
        while next_student[tmp]:
            next = next_student[tmp].pop()
            student[next].remove(tmp)
            if len(student[next]) == 0:
                s.add(next)
    print(*ans)
