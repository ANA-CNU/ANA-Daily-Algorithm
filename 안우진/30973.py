import sys
r=sys.stdin.readline

n=int(r())

xMin, yMin, xMax, yMax = map(int,r().split())
tree = []
xAvg, yAvg = 0, 0
xp, yp = 0, 0
for _ in range(n):
    x,y,l = map(int,r().split())
    tree.append((x,y,l))
    xp += l
    yp += l
    xAvg += x*l
    yAvg += y*l

if xp > 0:
    xAvg //= xp
if yp > 0:
    yAvg //= yp
xAvg = min(xMax, max(xMin, xAvg))
yAvg = min(yMax, max(yMin, yAvg))

def calc(xc,yc):
    res=0
    for x, y, l in tree:
        res+=l*((xc-x)**2 + (yc-y)**2)
    return res

points = [
    (xAvg-1, yMin-1),
    (xAvg, yMin-1),
    (xAvg+1, yMin-1),

    (xAvg-1, yMax+1),
    (xAvg, yMax+1),
    (xAvg+1, yMax+1),

    (xMin-1, yAvg-1),
    (xMin-1, yAvg),
    (xMin-1, yAvg+1),

    (xMax+1, yAvg-1),
    (xMax+1, yAvg),
    (xMax+1, yAvg+1),
]

res=[]
for xc, yc in points:
    res.append(calc(xc,yc))
print(min(res))
