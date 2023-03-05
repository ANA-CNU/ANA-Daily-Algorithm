N = int(input())

d = {}

BestSeller = ""
MaxValue = 0

for i in range(N):
    books = input()
    if d.get(books):
        d[books] = d[books] + 1
    else:
        d[books] = 1

sortedD = dict(sorted(d.items()))

for key, value in sortedD.items():
    if MaxValue < value:
        MaxValue = value
        BestSeller = key
print(BestSeller)

