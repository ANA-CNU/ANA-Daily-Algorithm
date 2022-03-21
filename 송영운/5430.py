from collections import deque
input = __import__('sys').stdin.readline
if __name__ == "__main__":
    t = int(input())
    for _ in range(t):
        RD_str = input().strip()
        RD_str = RD_str.replace('RR', '')
        n = int(input())
        list_str = input().strip()
        str_list = list(list_str[1:-1].split(','))
        q = deque(str_list)
        if n == 0:
            q.pop()
        reverse_True = False
        error_True = False
        for RD in RD_str:
            if RD == 'D':
                if len(q) == 0:
                    error_True = True
                    break
                if reverse_True == True:
                    q.pop()
                else:
                    q.popleft()
            if RD == 'R':
                if reverse_True == True:
                    reverse_True = False
                else:
                    reverse_True = True
        if reverse_True == True:
            q.reverse()
        if error_True == True:
            print('error')
        else:
            print('[' + ",".join(q) + ']')