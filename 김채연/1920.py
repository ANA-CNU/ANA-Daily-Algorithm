n = int(input())
arr = set(map(int, input().split()))
m = int(input())
nums = list(map(int, input().split()))

for i in range(m):
    if nums[i] in arr:
        print(1)
    else:
        print(0)
