import sys

if __name__ == '__main__':
    K = int(sys.stdin.readline().rstrip())
    stack = []

    for i in range(K):
        num = int(sys.stdin.readline().rstrip())
        if(num == 0):
            stack.pop()
        else:
            stack.append(num)
    print(sum(stack))