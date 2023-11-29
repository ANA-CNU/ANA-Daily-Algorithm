n = int(input())
nums = list(map(int, input().split()))
sorted_nums = sorted(set(nums))

nums_dict = {}
for i in range(len(sorted_nums)):
    nums_dict[sorted_nums[i]] = i

for num_key in nums:
    print(nums_dict[num_key], end=' ')
