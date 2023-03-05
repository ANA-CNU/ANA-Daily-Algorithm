# 실버 3 11478 서로 다른 부분 문자열의 개수

input = list(input())

d = {}

for i in range(input.__len__()):
    for j in range(input.__len__()+1):
        s = "".join(input[i:j])
        d[s] = 1

print(d.__len__() - 1)