test_case = int(input())

for i in range(test_case):
    Yonsei = []
    Korea = []

    for j in range(9):
        y, k = map(int, input().split())
        Yonsei.append(y)
        Korea.append(k)

    if sum(Yonsei) > sum(Korea):
        print("Yonsei")
    elif sum(Yonsei) < sum(Korea):
        print("Korea")
    else:
        print("Draw")
