input = __import__('sys').stdin.readline
if __name__ == "__main__":
    x1, y1 = map(int, input().split())
    x2, y2 = map(int, input().split())
    x3, y3 = map(int, input().split())

    x2, y2, x3, y3 = x2 - x1, y2 - y1, x3 - x1, y3 - y1

    if x2 == 0 or x3 == 0:
        if x2 ==0 and x3 ==0:
            print(0)
            exit()
        reverse = False
        if x2 == 0 and y2 > 0 and x3 < 0:
            reverse = True
        elif x2 == 0 and y2 < 0 and x3 > 0:
            reverse = True

        if x3 == 0 and y3 > 0 and x2 > 0:
            reverse = True
        elif x3 == 0 and y3 < 0 and x2 <0:
            reverse = True

        if reverse == True:
            print(1)
        else:
            print(-1)
        exit()

    inc2 = y2/x2
    inc3 = y3/x3

    if inc2 == inc3:
        print(0)
    else:
        reverse = False
        if x2 > 0 and y2 > 0:
            if (x3 < 0 and y3 > 0) or (x3 > 0 and y3 > 0 and inc3 > inc2) or (x3 < 0 and y3 < 0 and inc3 < inc2):
                reverse = True
        elif x2 < 0 and y2 > 0:
            if (x3 < 0 and y3 < 0) or (x3 < 0 and y3 > 0 and inc3 > inc2) or (x3 >0 and y3<0 and inc3 < inc2):
                reverse = True
        elif x2 < 0 and y2 < 0:
            if (x3 >0 and y3<0) or (x3<0and y3<0 and inc3 > inc2) or (x3>0 and y3>0 and inc3<inc2):
                reverse = True
        elif x2 > 0 and y2 < 0:
            if (x3 >0 and y3>0) or (x3>0and y3<0 and inc3>inc2)or (x3<0and y3>0 and inc3 < inc2):
                reverse = True
        elif y2 == 0 and x2 > 0 and y3 > 0:
            reverse = True
        elif y2 == 0 and x2 < 0 and y3 < 0:
            reverse = True

        if reverse== True:
            print(1)
        else:
            print(-1)