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
    '''
    for i in range(len(p)):
        word = p[:i+1]
        for j in range(1, len(word)):
            if word[:j] == word[len(word)-j:]:
                kmp[i] = j
    '''
    j = 0
    for i in range(len(s)):
        while j > 0 and s[i] != p[j]:
            j = kmp[j-1]
        if s[i] == p[j]:
            if j == len(p) - 1:
                print(1)
                exit()
            else:
                j += 1
    print(0)

    '''
    i = 0
    while i < len(s):
        idx = i
        if s[i] == p[0] and len(s) >= i + len(p):
            TrueFalse = True
            for j in range(1, len(p)):
                idx += 1
                if s[idx] == p[j]:
                    continue
                else:
                    i = idx - kmp[j-1]
                    TrueFalse = False
                    break
            if TrueFalse == True:
                print(1)
                exit()
        else:
            i += 1
    print(0)
    
    '''
    ''''''