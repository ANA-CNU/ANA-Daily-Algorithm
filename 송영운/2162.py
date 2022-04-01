def find(n):
    idx = root[n]
    while idx != root[idx]:
        idx = root[idx]
    root[n] = idx
    return idx

def solution():
    ccw123 = ccw(x1, y1, x2, y2, x3, y3)
    ccw124 = ccw(x1, y1, x2, y2, x4, y4)
    ccw341 = ccw(x3, y3, x4, y4, x1, y1)
    ccw342 = ccw(x3, y3, x4, y4, x2, y2)

    if ccw123*ccw124 == 0 and ccw341*ccw342 == 0:
        if mx1 <= mx4 and mx3 <= mx2 and my1 <= my4 and my3 <= my2:
            return 1
    else:
        if ccw123*ccw124 <= 0 and ccw341*ccw342 <= 0:
            return 1

    return 0

def ccw(x1, y1, x2, y2, x3, y3):
    return (x2-x1)*(y3-y1) - (y2-y1)*(x3-x1)

input = __import__('sys').stdin.readline
if __name__ == "__main__":
    n = int(input())
    root = [i for i in range(n)]
    line = [list(map(int, input().split())) for _ in range(n)]
    for i in range(n):
        for j in range(i+1, n):
            x1, y1, x2, y2 = line[i]
            x3, y3, x4, y4 = line[j]
            mx1, my1, mx2, my2 = min(x1, x2), min(y1, y2), max(x1, x2), max(y1, y2)
            mx3, my3, mx4, my4 = min(x3, x4), min(y3, y4), max(x3, x4), max(y3, y4)
            if solution():
                x = find(i)
                y = find(j)
                if root[x] < root[y]:
                    root[y] = x
                else:
                    root[x] = y

    my_dict = dict()
    for i in root:
        a = find(i)
        if a in my_dict:
            my_dict[a] += 1
        else:
            my_dict[a] = 1
    print(len(my_dict.keys()))
    print(max(my_dict.values()))