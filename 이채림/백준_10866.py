from collections import deque
import sys

if __name__ == '__main__':
    N = int(sys.stdin.readline().rstrip())
    queue = deque([])
   
    for i in range(N):
        arr = sys.stdin.readline().rstrip().split(" ")
        if arr[0] == "push_front":
            queue.appendleft(arr[1])
        elif arr[0] == "push_back":
            queue.append(arr[1])
        elif arr[0] == "pop_front":
            if queue:
                print(queue.popleft())
            else:
                print(-1)
        elif arr[0] == "pop_back":
            if queue:
                print(queue.pop())
            else:
                print(-1)
        elif arr[0] == "size":
            print(len(queue))
        elif arr[0] == "empty":
            if queue:
                print(0)
            else:
                print(1)
        elif arr[0] == "front":
            if queue:
                print(queue[0])
            else:
                print(-1)
        elif arr[0] == "back":
            if queue:
                print(queue[len(queue)-1])
            else:
                print(-1)

