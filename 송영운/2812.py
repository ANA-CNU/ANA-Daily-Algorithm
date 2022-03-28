from collections import deque
input = __import__('sys').stdin.readline
if __name__ == "__main__":
    n, k = map(int, input().split())
    num_list = deque(list(input().strip()))
    stack = deque()
    while num_list:
        x = num_list.popleft()
        if len(stack) == 0:
            stack.append(x)
        elif stack[len(stack)-1] < x and k > 0:
            stack.pop()
            k -= 1
            num_list.appendleft(x)
        else:
            stack.append(x)
    if k != 0:
        for i in range(k):
            stack.pop()
    print("".join(stack))
