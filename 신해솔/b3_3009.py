"""""""""
# 네 번째 점
"""""""""

pos_list = [tuple(map(int, input().split())) for _ in range(3)]
x_pos, y_pos = zip(*pos_list)
x = [x for x in x_pos if x_pos.count(x) == 1]
y = [y for y in y_pos if y_pos.count(y) == 1]
print(*(x + y))
