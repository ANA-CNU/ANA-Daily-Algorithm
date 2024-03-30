import sys


matrix = [[] for _ in range(9)]
max_info = {"num": -1, "row": 0, "column": 0}
for i in range(9):
    matrix[i] = list(map(int, sys.stdin.readline().split()))

for i in range(9):
    max_in_row = max(matrix[i])
    if max_in_row > max_info["num"]:
        max_info["num"] = max_in_row
        max_info["row"] = i
        max_info["column"] = matrix[i].index(max_in_row)

print(max_info["num"])
print(max_info["row"]+1, max_info["column"]+1)
