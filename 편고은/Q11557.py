test_case = int(input())

for i in range(test_case):
    num_of_schools = int(input())
    S = []
    L = []

    for j in range(num_of_schools):
        a, b = input().split()
        S.append(a)
        L.append(int(b))

    print(S[L.index(max(L))])

