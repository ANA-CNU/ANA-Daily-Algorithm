num_list = []

for i in range(9):
    num_list.append(int(input()))

max_num = num_list[0]

for i in num_list[1:]:
    if i <= max_num:
        continue
    else:
        max_num = i

print(max_num)
print(num_list.index(max_num) + 1)
