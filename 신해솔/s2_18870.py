"""""""""
# 좌표 압축
"""""""""

n = int(input())
pos_list = list(map(int, input().split()))
pos_sorted = sorted(set(pos_list))
mapping = dict(zip(pos_sorted, range(len(pos_sorted))))
trans_pos = [mapping[pos] for pos in pos_list]
print(*trans_pos)
