from collections import deque
input = __import__('sys').stdin.readline
if __name__ == "__main__":
    n = int(input())

    queen = [-1]*n
    q = deque()
    answer = 0
    for i in range(n):
        q.append((0, i))
    while q:
        r, i = q.pop()
        queen[r] = i
        if r == n-1:
            answer += 1
            continue
        r += 1
        for i in range(n):
            for row_num in range(r):
                if queen[row_num] == i:
                    in_check = False
                    break
                if i - (r - row_num) == queen[row_num] or i + (r - row_num) == queen[row_num]:
                    in_check = False
                    break
            else:
                q.append((r, i))

    print(answer)


