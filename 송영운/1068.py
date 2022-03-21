from collections import deque
input = __import__('sys').stdin.readline
if __name__ == "__main__":
    n = int(input())
    root_node = list(map(int, input().split()))
    r = int(input())

    q = deque()
    q.append(r)
    while q:
        rm = q.popleft()
        root_node[rm] = -2
        for i in range(n):
            if root_node[i] == rm:
                q.append(i)

    count = 0
    for i in range(n):
        if root_node[i] != -2:
            if i not in root_node:
                count += 1
    print(count)