import math
import sys

# 에라토스테네스의 체
if __name__ == "__main__":
    N = int(sys.stdin.readline().rstrip())
    nums = list(map(int, sys.stdin.readline().rstrip().split(" ")))
    maxNum = 1000
    primNums = [True for i in range(maxNum+1)]

    # 0과 1은 소수가 아님
    primNums[0] = False
    primNums[1] = False

    for i in range(2, int(math.sqrt(maxNum)) + 1):
        if primNums[i] == True:
            for j in range(2, maxNum+1):
                if i*j <= maxNum:
                    primNums[i*j] = False
                else:
                    break
    
    count = 0

    for i in nums:
        if primNums[i] == True:
            count += 1
    
    print(count)