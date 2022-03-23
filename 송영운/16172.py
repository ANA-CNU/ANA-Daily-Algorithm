def get_pi(P):
    m = len(P)
    pi = [0 for i in range(m)]
    idx = 0
    for i in range(1, m):
        while idx > 0 and P[i] != P[idx]:
            idx = pi[idx - 1]
        if P[i] == P[idx]:
            idx += 1
            pi[i] = idx
    return pi

input = __import__('sys').stdin.readline
if __name__ == "__main__":
    s = input().strip()
    p = input().strip()
    kmp = get_pi(p)
    j = 0
    for i in range(len(s)):
        if 48<=ord(s[i])<=57:
            continue
        while j > 0 and s[i] != p[j]:
            j = kmp[j - 1]
        if s[i] == p[j]:
            if j == len(p) - 1:
                print(1)
                exit()
            else:
                j += 1
    print(0)
