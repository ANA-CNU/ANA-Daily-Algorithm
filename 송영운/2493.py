input = __import__('sys').stdin.readline
if __name__ == "__main__":
    n = int(input())
    top = list(map(int, input().split()))
    ans = [0]*n
    stack = []
    stack.append(n-1)
    for i in range(n-1, -1, -1):
        while stack and top[i] > top[stack[-1]]:
            ans[stack[-1]] = i+1
            stack.pop()
        else:
            stack.append(i)
    print(*ans)