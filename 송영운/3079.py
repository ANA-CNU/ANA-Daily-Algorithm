def binary_search():
    global m
    left = 0
    right = max_time*m
    while left <= right:
        mid = (left + right) // 2
        tmp = 0
        for t in times:
            tmp += mid // t
        if tmp >= m:
            ans = mid
            right = mid - 1
        else:
            left = mid + 1
    return ans

input = __import__('sys').stdin.readline
if __name__ == "__main__":
    n, m = map(int, input().split())
    times = [int(input()) for _ in range(n)]
    max_time = max(times)
    print(binary_search())
