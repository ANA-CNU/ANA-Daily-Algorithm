test_case = int(input())

for i in range(test_case):
    r, e, c = map(int, input().split())

    if r < e - c:
        print("advertise")
    elif r > e - c:
        print("do not advertise")
    else:
        print("does not matter")