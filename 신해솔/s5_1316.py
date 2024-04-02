import sys


def checker(word: str) -> int:
    if len(word) < 2:
        return 1

    if word[0] == word[1]:
        return checker(word[1:])
    elif word[0] in word[1:]:
        return 0
    else:
        return checker(word[1:])


t = int(input())
cnt = 0

for i in range(t):
    word = sys.stdin.readline().strip()
    cnt += checker(word)

print(cnt)
