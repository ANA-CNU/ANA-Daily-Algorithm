def dfs(one_to_n, strs):
    global n
    temp = strs+str(one_to_n)
    if one_to_n == n:
        remove_blank_temp = (temp).replace(' ', '')
        calc = eval(remove_blank_temp)
        if calc == 0:
            print(temp)
        return
    dfs(one_to_n+1, temp+' ')
    dfs(one_to_n + 1, temp+'+')
    dfs(one_to_n + 1, temp+'-')

input = __import__('sys').stdin.readline
if __name__ == "__main__":
    t = int(input())
    for _ in range(t):
        n = int(input())
        start = 1
        strs = ''
        dfs(start, strs)
        print()