from collections import deque
input = __import__('sys').stdin.readline
if __name__ == "__main__":
    t = int(input())
    for i in range(t):
        strs = list(input().split())
        len_str1 = len(strs[0])
        len_str2 = len(strs[1])
        len_str3 = len(strs[2])
        YesNo = False
        q = deque()
        q.append((0,0,0))
        visit = [[False]*(len_str2+1) for _ in range(len_str1+1)]
        while q:
            str1, str2, str3 = q.popleft()
            if len_str1 == str1 and len_str2 == str2:
                YesNo = True
                break

            if len_str1 != str1 and strs[0][str1] == strs[2][str3] and visit[str1+1][str2] == False:
                q.append((str1+1, str2, str3+1))
                visit[str1+1][str2] = True
            if len_str2 != str2 and strs[1][str2] == strs[2][str3] and visit[str1][str2+1] == False:
                q.append((str1, str2+1, str3+1))
                visit[str1][str2+1] = True

        if YesNo == True:
            yesno = 'yes'
        else:
            yesno = 'no'

        print(f"Data set {i+1}:", yesno)
