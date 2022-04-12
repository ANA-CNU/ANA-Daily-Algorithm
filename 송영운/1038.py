def dfs(n):
    global num_str
    temp = num_str
    if n == 11:
        return
    for i in range(9, -1, -1):
        if num_str == '' or i < int(num_str[-1]):
            num_str += str(i)
            decrease_num.append(int(num_str))
            dfs(n+1)
        num_str = temp

input = __import__('sys').stdin.readline
if __name__ == "__main__":
    n = int(input())
    decrease_num = []
    num_str = ''
    dfs(0)
    decrease_num.sort()
    if len(decrease_num) <= n:
        print(-1)
    else:
        print(decrease_num[n])