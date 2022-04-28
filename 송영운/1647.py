def find(n):
    while n != root[n]:
        n = root[n]
    return n

from heapq import heappush, heappop
input = __import__('sys').stdin.readline
if __name__ == "__main__":
    n, m = map(int, input().split())
    root = [i for i in range(n+1)]
    pq = []
    for i in range(m):
        a, b, c = map(int, input().split())
        heappush(pq, (c, a, b))

    ans = 0
    max = 0
    while pq:
        c, a, b = heappop(pq)
        root_a = find(a)
        root_b = find(b)
        if root_a != root_b:
            if root_a < root_b:
                root[root_b] = root_a
            elif root_a > root_b:
                root[root_a] = root_b
            ans += c
            max = c
    print(ans - max)