import sys
from collections import Counter

word = list(sys.stdin.readline().strip())
word.sort()
dic = Counter(word)
odd_cnt = 0
center = ""
ans = ""

for i in dic:
    if dic[i] % 2 != 0:
        odd_cnt += 1
        center += i
        word.remove(i)

    if odd_cnt > 1:
        print("I'm Sorry Hansoo")
        sys.exit(0)

for i in range(0, len(word), 2):
    ans += word[i]

print(ans + center + ans[::-1])
