input = input().split()
x = int(input[0])
y = int(input[1])
w = int(input[2])
c = int(input[3])

w2 = min(w,c) * 2
d = min(2*w,c)

dd = min(x,y)
dw = max(x,y) - dd

ret = dd * d + dw // 2 * w2 + dw % 2 * w
print(ret)
