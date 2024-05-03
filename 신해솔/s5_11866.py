"""""""""
요세푸스 문제 0
"""""""""

n, k = map(int, input().split())
num = list(range(1, n+1))
josephus = []
index = 0

while len(num) > 0:
    for i in range(k-1):
        if index < len(num)-1:
            index += 1
        else:
            index = 0
    josephus.append(num.pop(index))
    if index > len(num) - 1:
        index = 0

print("<" + ", ".join(map(str, josephus)) + ">")
