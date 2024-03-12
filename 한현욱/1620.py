import sys
n, m = map(int,input().split())
arr = []
dict = {}
for i in range(n):
    poketmon = sys.stdin.readline().rstrip('\n')
    arr.append(poketmon)
    dict[poketmon] = i+1
for i in range(m):
    problem = sys.stdin.readline().rstrip('\n')
    if ord(problem[0]) < 60:
        print(arr[int(problem)-1])
    else:
        print(dict[problem])

