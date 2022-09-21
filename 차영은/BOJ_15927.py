import sys

word = sys.stdin.readline().strip()
ans = 0
curr = word[0]
same = True

if word == word[::-1]:
    for i in word:
        if i != curr:
           same = False
           break
        else:
            curr = i

    if same:
        ans = -1
    else:
        ans = len(word) - 1
else:
    ans = len(word)

print(ans)
