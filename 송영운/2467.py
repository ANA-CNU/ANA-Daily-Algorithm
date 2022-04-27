import sys

def binary_search(n):
    global plus_idx

    left = plus_idx
    right = len(l)-1
    min_ans = sys.maxsize
    while left <= right:
        mid = (left+right)//2
        sum = abs(n+l[mid])
        if sum < min_ans:
            min_ans = sum
            ans_idx = mid
        if l[mid] < -n:
            left = mid + 1
        else:
            right = mid - 1
    return ans_idx, min_ans

input = __import__('sys').stdin.readline
if __name__ == "__main__":
    n = int(input())
    l = list(map(int, input().split()))

    plus_idx = -1
    for i in range(n):
        if l[i] >= 0:
            plus_idx = i
            break

    if plus_idx == 0:
        print(l[0], l[1])
    elif plus_idx == -1:
        print(l[-2], l[-1])
    else:
        min_sum = sys.maxsize
        for i in range(plus_idx):
            match_idx, match_sum = binary_search(l[i])
            if match_sum < min_sum:
                answer_i, answer_j = i, match_idx
                min_sum = match_sum
        if plus_idx + 1 < len(l):
            compare1 = abs(l[plus_idx] + l[plus_idx+1])
            if compare1 < min_sum:
                answer_i, answer_j = plus_idx, plus_idx+1
                min_sum = compare1
        if plus_idx - 2 >= 0:
            compare2 = abs(l[plus_idx-2] + l[plus_idx-1])
            if compare2 < min_sum:
                answer_i, answer_j = plus_idx-2, plus_idx-1
        print(l[answer_i], l[answer_j])