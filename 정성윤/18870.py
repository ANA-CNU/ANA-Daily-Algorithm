N = int(input())

d = {}

nums = list(map(int, input().split()))
nums1 = nums.copy()
nums = list(set(nums))
nums.sort()

answer = []

for i in range(len(nums)):
    d[nums[i]] = i

for i in nums1:
    answer.append(d[i])

print(*answer)