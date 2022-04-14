import sys

if __name__ == '__main__':
    x,y,w,h = map(int, sys.stdin.readline().rstrip().split(" "))

    # x랑 0사이의 거리, x랑 w사이의 거리, y랑 0사이의 거리, y랑 h사이의 거리 중 최소
    min = 1000
    xzero = abs(x)
    xw = abs(x-w)
    yzero = abs(y)
    yh = abs(y-h)


    min = xw  if xzero > xw else xzero
    min = yzero if min > yzero else min
    min = yh if min > yh else min

    print(min)    