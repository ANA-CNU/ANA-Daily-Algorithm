margin_error = 0.00000001
import math
input = __import__('sys').stdin.readline
if __name__ == "__main__":
    x1, y1, x2, y2 = map(int, input().split())
    x3, y3, x4, y4 = map(int, input().split())

    if x2 - x1 == 0:
        inc1 = math.inf
    else:
        inc1 = (y2 - y1) / (x2 - x1)
    if x4 - x3 == 0:
        inc2 = math.inf
    else:
        inc2 = (y4 - y3) / (x4 - x3)

    if inc1 == math.inf and inc2 == math.inf:
        if x1 == x3:
            if min(y3, y4) <= max(y1, y2) <= max(y3, y4) or \
                min(y3, y4) <= min(y1, y2) <= max(y3, y4) or \
                min(y1, y2) <= max(y3, y4) <= max(y1, y2) or \
                min(y1, y2) <= min(y3, y4) <= max(y1, y2):
                print(1)
                exit()

    elif inc1 == math.inf and inc2 != math.inf:
        a = y3 - inc2 * x3
        y = inc2 * x1 + a
        if min(y1,y2) <= y <= max(y1,y2) and \
            min(x3,x4) <= x1 <= max(x3,x4):
            print(1)
            exit()

    elif inc1 != math.inf and inc2 == math.inf:
        a = y1 - inc1 * x1
        y = inc1 * x3 + a
        if min(y3,y4) <= y <= max(y3,y4) and \
            min(x1,x2) <= x3 <= max(x1, x2):
            print(1)
            exit()

    else:
        a1 = y1 - inc1 * x1
        a2 = y3 - inc2 * x3
        if inc1 == inc2:
            y = inc1 * x3 + a1
            if y3 - margin_error <= y <= y3 + margin_error:
                if min(x3, x4) <= max(x1, x2) <= max(x3, x4) or \
                    min(x3, x4) <= min(x1, x2) <= max(x3, x4) or \
                    min(x1, x2) <= max(x3, x4) <= max(x1, x2) or \
                    min(x1, x2) <= min(x3, x4) <= max(x1, x2):
                    print(1)
                    exit()
            print(0)
            exit()
        x = (a1 - a2) / (inc2 - inc1)
        y = inc1 * x + a1
        if min(x1, x2) - margin_error <= x <= max(x1, x2) + margin_error:
            if min(x3, x4) - margin_error <= x <= max(x3, x4) + margin_error:
                if min(y1, y2) - margin_error <= y <= max(y1, y2) + margin_error:
                    if min(y3, y4) - margin_error <= y <= max(y3,y4) + margin_error:
                        print(1)
                        exit()
    print(0)