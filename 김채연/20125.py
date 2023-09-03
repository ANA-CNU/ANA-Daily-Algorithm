n = int(input())
arr = []
x = 0
y = 0
for _ in range(n):
    arr.append(list(input()))
   
try:
    for i in range(n):
        for j in range(n):
            if arr[i][j]=='*':
                x = j
                y = i+1
                raise NotImplementedError
except:
    pass
left_arm = 0
right_arm = 0
for i in range(x-1, -1, -1):
    if arr[y][i] !='*':
        break
    left_arm +=1
for i in range(x+1, n):
    if arr[y][i] !='*':
        break
    right_arm +=1
waist = 0
b = 0
for i in range(y+1, n):
    if arr[i][x] !='*':
        b = i
        break
    waist +=1

left_leg = 0
right_leg = 0
for j in range(b, n):
    if arr[j][x-1]!='*':
        break
    left_leg +=1
for j in range(b, n):
    if arr[j][x+1]!='*':
        break
    right_leg +=1
print(y+1, x+1)
print(left_arm, right_arm, waist, left_leg, right_leg)
