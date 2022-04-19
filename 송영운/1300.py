def binary_search(n, k):
    left = 1
    right = k
    answer = 0
    while left <= right:
        mid = (left + right)//2
        count = 0
        for i in range(1, n+1):
            count += min(mid // i, n)
        if count >= k:
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