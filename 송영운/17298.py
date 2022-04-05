input = __import__('sys').stdin.readline
if __name__ == "__main__":
    n = int(input())
    a = list(map(int, input().split()))
    stack = []
    stack.append(0)
    ans = [-1]*n
    for i in range(1, n):
        while stack and a[stack[-1]] < a[i]:
            ans[stack.pop()] = a[i]
        stack.append(i)
    print(*ans)

# input = __import__('sys').stdin.readline
# if __name__ == "__main__":
#     n = int(input())
#     a = list(map(int, input().split()))
#     a_sort = []
#     for i in range(n):
#         a_sort.append((a[i], i))
#     a_sort.sort()
#     ans = [-1] * n
#     for i in range(n-1):
#         idx = a_sort[i][1]
#         if idx < n-1 and a[idx] < a[idx+1]:
#             ans[idx] = a[idx+1]
#             a[idx] = a[idx+1]
#     print(*ans)