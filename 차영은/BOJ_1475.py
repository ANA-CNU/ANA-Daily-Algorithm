import sys

s = sys.stdin.readline().strip()
dic = {'0': 0, '1': 0, '2': 0, '3': 0, '4': 0, '5': 0, '6': 0, '7': 0, '8': 0}

for i in s:
    if i == '6' or i == '9':
        dic['6'] += 0.5
    else:
        dic[i] += 1

print(round(max(dic.values()) + 0.1))
