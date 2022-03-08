input = __import__('sys').stdin.readline
if __name__ == "__main__":
    n = int(input())
    a = list(map(int, input().split()))
    dp = [a[0]]
    for i in range(1, n):
        if a[i] > dp[-1]:
            dp.append(a[i])
        else:
            left = 0
            right = len(dp) - 1
            while left <= right:
                mid = (left + right) // 2
                if a[i] == dp[mid]:
                    left = mid
                    break
                elif a[i] > dp[mid]:
                    left = mid + 1
                else:
                    right = mid - 1
            dp[left] = a[i]
    print(len(dp))