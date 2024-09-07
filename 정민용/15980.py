import sys

n, m = map(int, sys.stdin.readline().split())
arr = [0 for _ in range(m)]
input_data = []
num_data = []
for _ in range(n):
    input_data.append(list(map(str, sys.stdin.readline().split())))
    data = input_data[-1][1]
    num = []

    if input_data[-1][0] == 'L':
        for i, d in enumerate(data):
            num.append(0)
            if d == '1':
                arr[i] += 1
                num[-1] = 1
    else:
        for i, d in enumerate(data):
            num.append(0)
            if d == '1':
                arr[i] -= 1
                num[-1] = -1
    
    num_data.append(num)

res, res_index = 10**9, -1
for index, data in enumerate(num_data):
    test = [0] + [a for a in data]
    for i in range(1, m+1):
        test[i] += test[i-1] - arr[i-1]
    
    score = 0
    for t in test:
        score = max(score, abs(t))
    if score < res:
        res = score
        res_index = index

print(res_index + 1)
print(res)