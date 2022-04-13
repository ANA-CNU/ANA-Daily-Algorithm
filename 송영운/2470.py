import sys
def binary_search(i):
    global plus_idx

    left = plus_idx
    right = len(liquid)-1
    min_ans = sys.maxsize
    min_x, min_y = 0, 0
    while left <= right:
        mid = (left + right)//2
        if -liquid[i] < liquid[mid]:
            if abs(min_ans) > abs(liquid[i] + liquid[mid]):
                min_ans = liquid[i] + liquid[mid]
                min_x, min_y = i, mid
            right = mid - 1
        else:
            if abs(min_ans) > abs(liquid[i] + liquid[mid]):
                min_ans = liquid[i] + liquid[mid]
                min_x, min_y = i, mid
            left = mid + 1
    return min_ans, min_x, min_y

input = __import__('sys').stdin.readline
if __name__ == "__main__":
    n = int(input())
    liquid = list(map(int, input().split()))
    liquid.sort()
    plus_idx = -1
    for i in range(len(liquid)):
        if liquid[i] >= 0:
            plus_idx = i
            break
    if plus_idx == 0:
        print(liquid[0], liquid[1])
    elif plus_idx == -1:
        print(liquid[-2], liquid[-1])
    else:
        min_num = sys.maxsize
        ans_x, ans_y = 0, 0
        for i in range(plus_idx):
            temp, x, y = binary_search(i)
            if abs(min_num) > abs(temp):
                min_num = temp
                ans_x, ans_y = x, y
        lx, ly = liquid[ans_x], liquid[ans_y]
        if plus_idx > 1:
            lmx, lmy = liquid[plus_idx-2], liquid[plus_idx-1]
            lm_sum = lmx + lmy
            if abs(min_num) > abs(lm_sum):
                lx, ly = lmx, lmy
        if len(liquid) - plus_idx > 1:
            lpx, lpy = liquid[plus_idx], liquid[plus_idx+1]
            lp_sum = lpx + lpy
            if abs(min_num) > abs(lp_sum):
                lx, ly = lpx, lpy
        print(min(lx, ly), max(lx, ly))