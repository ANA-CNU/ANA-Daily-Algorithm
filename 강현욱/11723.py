import sys
input = sys.stdin.readline
num=int(input())
answer=set()
word=[]
for k in range(num):
    word = list(input().split())
    if word[0] =='add':
        answer.add(word[1])
    elif word[0] == 'remove':
        answer.discard(word[1])
    elif word[0] == 'check':
        if word[1] in answer:
            print(1)
        else:
            print(0)
    elif word[0] == 'toggle':
        if word[1] in answer:
            answer.discard(word[1])
        else:
            answer.add(word[1])
    elif word[0] == 'all':
        answer.clear()
        for j in range(1,21):
            answer.add(str(j))
    elif word[0] == 'empty':
        answer.clear()
    