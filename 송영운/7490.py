import sys
sys.setrecursionlimit(10**6)

def dfs(one_to_n, strs):
    global n
    for i in range(3):
        temp = strs
        temp += str(one_to_n)

        if one_to_n == n:
            remove_blank_temp = temp.replace(' ', '')
            calc = eval(remove_blank_temp)
            if calc == 0:
                print(temp)
            return
        if i == 0:
            temp += ' '
        elif i == 1:
            temp += '+'
        else:
            temp += '-'
        dfs(one_to_n+1, temp)

input = __import__('sys').stdin.readline
if __name__ == "__main__":
    t = int(input())
    for _ in range(t):
        n = int(input())
        start = 1
        strs = ''
        dfs(start, strs)
        print()