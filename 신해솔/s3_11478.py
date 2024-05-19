# 서로 다른 부분 문자열의 개수 - 11478

import sys

word = sys.stdin.readline().strip()

sub_str = []
length = len(word)
for i in range(1, length+1):
    for j in range(length-i+1):
        sub_str.append(word[j:j+i])
print(len(set(sub_str)))
