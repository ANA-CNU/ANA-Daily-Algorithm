import sys


input_nums = [int(sys.stdin.readline()) for _ in range(10)]
remainders = {input_nums[i] % 42 for i in range(10)}
print(len(remainders))
