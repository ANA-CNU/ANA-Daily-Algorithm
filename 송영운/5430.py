input = __import__('sys').stdin.readline
if __name__ == "__main__":
    t = int(input())
    for _ in range(t):
        RD_str = input().strip()
        n = int(input())
        list_str = input().strip()
        list_str = list_str[1:-1]
        str_list = list(list_str.split(','))
        if n == 0:
            str_list = []
        reverse_True = False
        error_True = False
        for RD in RD_str:
            if RD == 'D':
                if len(str_list) == 0:
                    error_True = True
                    break
                if reverse_True == True:
                    str_list.pop()
                else:
                    str_list.pop(0)
            if RD == 'R':
                if reverse_True == True:
                    reverse_True = False
                else:
                    reverse_True = True
        if reverse_True == True:
            str_list.reverse()
        if error_True == True:
            print('error')
        else:
            print('[' + ",".join(str_list) + ']')