"""""""""
# 좌표 정렬하기 2
"""""""""

n = int(input())
pos = [tuple(map(int, input().split())) for _ in range(n)]
for pair in sorted(pos, key=lambda x: (x[1], x[0])):
    print(*pair)
