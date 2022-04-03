a = input().upper()
word = list(set(a))

cnt = []
for i in word:
    count=a.count(i)
    cnt.append(count)

if cnt.count(max(cnt)) > 1:
        print("?")

else: print(word[cnt.index(max(cnt))].upper())