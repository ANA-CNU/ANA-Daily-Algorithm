import sys
N = int(sys.stdin.readline())
numbers = list(map(int, sys.stdin.readline().split()))
# 0:+, 1:-, 2:*, 3://
cal = list(map(int, sys.stdin.readline().split()))
result = []


def dfs(num, idx):
    global cal
    if idx == N:
        global result
        result.append(num)
        return
    if cal[0] != 0:
        new_num = num + numbers[idx]
        cal[0] -= 1
        dfs(new_num, idx+1)
        cal[0] += 1
    if cal[1] != 0:
        new_num = num - numbers[idx]
        cal[1] -= 1
        dfs(new_num, idx+1)
        cal[1] += 1
    if cal[2] != 0:
        new_num = num * numbers[idx]
        cal[2] -= 1
        dfs(new_num, idx+1)
        cal[2] += 1
    if cal[3] != 0:
        if num < 0 < numbers[idx]:
            new_num = -(abs(num) // numbers[idx])
        else:
            new_num = num // numbers[idx]
        cal[3] -= 1
        dfs(new_num, idx+1)
        cal[3] += 1


dfs(numbers[0], 1)
print(max(result))
print(min(result))