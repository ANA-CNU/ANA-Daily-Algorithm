import sys

if __name__ == '__main__':
    N = int(sys.stdin.readline().rstrip())
    stack = []

    for i in range(N):
        stack.append(int(sys.stdin.readline().rstrip()))

    reduce = 0

    now_big = stack.pop()

    while len(stack) != 0:
        top = stack.pop()
        if top >= now_big:
            minus = top - now_big + 1
            reduce += minus
            now_big = top - minus
        else:
            now_big = top
    
    print(reduce)
    