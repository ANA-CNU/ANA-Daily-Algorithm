num_list = list(map(int, input().split()))
num_list.remove(max(num_list))
print(max(num_list))
