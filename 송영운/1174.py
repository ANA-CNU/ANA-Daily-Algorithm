import copy
from itertools import combinations
from collections import deque
input = __import__('sys').stdin.readline
if __name__ == "__main__":
    n = int(input())

    decrease_num = []
    num_q = deque()

    def dfs():
        if len(num_q) > 0:
            decrease_num.append(int("".join(map(str,num_q))))
        for i in range(10):
            if len(num_q) == 0 or num_q[0] < i:
                num_q.appendleft(i)
                dfs()
                num_q.popleft()
    dfs()
    decrease_num.sort()
    if n > len(decrease_num):
        print(-1)
    else:
        print(decrease_num[n-1])
