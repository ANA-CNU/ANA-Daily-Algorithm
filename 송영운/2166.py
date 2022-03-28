from collections import deque
input = __import__('sys').stdin.readline
if __name__ == "__main__":
    n = int(input())
    dots = []
    area = 0.0
    for i in range(n):
        x, y = map(int, input().split())
        dots.append((x, y))
    dots.append((dots[0][0], dots[0][1]))

    for i in range(n):
        area += (dots[i][0]*dots[i+1][1])-(dots[i+1][0]*dots[i][1])

    area = abs(area)
    print(round(area/2, 1))
