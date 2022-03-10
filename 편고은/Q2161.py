n = int(input())
n_list = [i for i in range(1, n + 1)]

del_list = []
while len(n_list) > 1:
    del_list.append(n_list[0])
    del(n_list[0])

    n_list.append(n_list[0])
    del(n_list[0])

del_list.append(n_list[0])
for i in del_list:
    print(i, end = " ")
print()