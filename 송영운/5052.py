input = __import__('sys').stdin.readline
if __name__ == "__main__":
    t = int(input())
    for _ in range(t):
        n = int(input())
        phone_number = [input().strip() for _ in range(n)]
        phone_number.sort()

        YesNo = True
        s = set()
        for pn in phone_number:
            for i in range(len(pn)):
                if pn[:i+1] in s:
                    YesNo = False
                    break
            s.add(pn)
            if YesNo == False:
                break
        if YesNo == True:
            print('YES')
        else:
            print('NO')
