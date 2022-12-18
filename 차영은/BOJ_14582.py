import sys

W = list(map(int, sys.stdin.readline().split()))
S = list(map(int, sys.stdin.readline().split()))
W_sum = 0
S_sum = 0
flag = False

for i in range(9):
    for _ in range(W[i]):
        W_sum += 1

    for _ in range(S[i]):
        if W_sum > S_sum:
            flag = True
            break

        S_sum += 1


print("Yes" if flag else "No")
