#백준 12015번
import sys
input = sys.stdin.readline

N = int(input())
A = list(map(int, input().split()))
a = [0]

for i in A:
    if a[-1] < i:
        a.append(i)
    else:
        start = 0
        end = len(a)
        while start < end:
            mid = (start + end) // 2
            if a[mid] < i:
                start = mid + 1
            else:
                end = mid
        a[end] = i

print(len(a) - 1)


# 백준 12015번 (dp 풀이)
import sys

n = int(sys.stdin.readline())
A = list(map(int,sys.stdin.readline().split()))

dp = [0] # dp안에 0이 있어야 각 숫자를 시작으로 할 수 있는 가장 긴 증가하는 부분 수열의 길이를 저장할 수 있다.

for i in range(n):
    start = 0
    end = len(dp) - 1
    while start <= end:
        mid = (start+end)//2 # dp배열의 중간요소 인덱스

        if dp[mid] < A[i]: 
            start = mid + 1  # dp[mid]는 A[i]보다 작거나 같은 요소만 포함하는 부분 배열
        else:
            end = mid - 1 # dp[mid]는 A[i]보다 크거나 같은 요소만 포함하는 부분 배열
        
    if start >= len(dp):
        dp.append(A[i])
    else:
        dp[start] = A[i] # 숫자를 천천히 넣어보면 된다.

print(len(dp) - 1)