def binary_search(n, k):
    left = 1
    right = k
    answer = 0
    while left <= right:
        mid = (left + right)//2
        tmp = 0
        for i in range(1, n+1):
            tmp += min(mid // i, n)
            if mid // i == 0:
                break
        if tmp >= k:
            answer = mid
            right = mid - 1
        else:
            left = mid + 1

    return answer

input = __import__('sys').stdin.readline
if __name__ == "__main__":
    n = int(input())
    k = int(input())

    print(binary_search(n, k))