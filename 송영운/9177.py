def check(str1, str2, str3):
    global len_str1
    global len_str2
    global len_str3
    if visit[str1][str2][str3] == True:
        return False
    visit[str1][str2][str3] = True
    tf = False
    if len_str1 - str1 != 0 and strs[0][str1] == strs[2][str3]:
        if len_str3 - str3 == 1:
            return True
        tf = check(str1 + 1, str2, str3 + 1)
    if len_str2 - str2 != 0 and strs[1][str2] == strs[2][str3]:
        if len_str3 - str3 == 1:
            return True
        tf = check(str1, str2 + 1, str3 + 1)

    if tf == True:
        return True
    else:
        return False


input = __import__('sys').stdin.readline
if __name__ == "__main__":
    t = int(input())
    for i in range(t):
        strs = list(input().split())
        len_str1 = len(strs[0])
        len_str2 = len(strs[1])
        len_str3 = len(strs[2])
        visit = [[[False]*(len_str3+1) for _ in range(len_str2+1)] for _ in range(len_str1+1)]
        YesNo = check(0, 0, 0)
        if YesNo == True:
            yesno = 'yes'
        else:
            yesno = 'no'

        print(f"Data set {i+1}:", yesno)
