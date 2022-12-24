N = int(input())

list_A = list(map(int, input().split()))
list_B = list(map(int, input().split()))

S = 0
for i in range(N) :
    S += min(list_A) * max(list_B)
    list_A.pop(list_A.index(min(list_A)))
    list_B.pop(list_B.index(max(list_B)))

print(S)
