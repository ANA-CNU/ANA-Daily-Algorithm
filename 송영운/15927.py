
def palindrome(s_idx, d_idx):
    src = s_idx
    dst = d_idx
    first_w = s[0]
    same_count = 0
    while s_idx <= d_idx:
        if s[s_idx] == first_w and s[d_idx] == first_w:
            same_count += 2
        if s[s_idx] != s[d_idx]:
            return dst - src + 1
        s_idx += 1
        d_idx -= 1
    if same_count >= dst - src + 1:
        return 0
    return dst - src

input = __import__('sys').stdin.readline
if __name__ == "__main__":
    s = input().strip()
    max_length = palindrome(0, len(s)-1)

    if max_length == 0:
        print(-1)
    else:
        print(max_length)