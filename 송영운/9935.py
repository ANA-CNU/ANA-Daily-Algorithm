from collections import deque
import hashlib
input = __import__('sys').stdin.readline
if __name__ == "__main__":
    str1 = input().strip()
    str2 = input().strip()
    len_str2 = len(str2)

    stack = []
    for s in range(len(str1)):
        stack.append(str1[s])
        if str1[s] == str2[-1] and len(stack) >= len_str2:
            if "".join(stack[-len_str2:]) == str2:
                for _ in range(len_str2):
                    stack.pop()
    if len(stack) == 0:
        print('FRULA')
    else:
        print("".join(stack))
