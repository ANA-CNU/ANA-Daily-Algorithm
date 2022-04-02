input = __import__('sys').stdin.readline
if __name__ == "__main__":
    n = int(input())
    strs = input().strip()
    l = len(strs)
    we_count = []
    w_num = 0
    e_num = 0
    for i in range(l):
        if strs[i] == 'W':
            w_num += 1
        elif strs[i] == 'H':
            we_count.append((w_num,e_num))
        elif strs[i] == 'E':
            e_num += 1
    ans = 0
    e_dp = [0]*(e_num+1)
    for i in range(1, len(e_dp)):
        e_dp[i] = (i-1) + 2*e_dp[i-1]
    for i in range(len(we_count)):
        e_num_i_to_end = e_num - we_count[i][1]
        ans += we_count[i][0] * e_dp[e_num_i_to_end]
    print(ans%1000000007)