from heapq import heappop, heappush

def find(n):
    while parent[n] != n:
        n = parent[n]
    return n

error = 10**(-2)
if __name__ == "__main__":
    n = int(input())
    star_xy = []
    parent = [i for i in range(n)]
    g = []
    answer = 0
    for i in range(n):
        x, y = map(float, input().split())
        star_xy.append((x, y))
    for i in range(n):
        x1, y1 = star_xy[i]
        for j in range(1, n):
            x2, y2 = star_xy[j]
            x_distance = abs(x2 - x1)
            y_distance = abs(y2 - y1)
            distance = (x_distance**2 + y_distance**2)**(0.5)
            heappush(g, (distance, i, j))
    while g:
        d, i, j = heappop(g)
        root_i = find(i)
        root_j = find(j)
        if root_i > root_j:
            parent[root_j] = root_i
            answer+=d
        elif root_j > root_i:
            parent[root_i] = root_j
            answer+=d
    print(answer)