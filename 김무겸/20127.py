n = int(input())
inputs = list(map(int, input().split()))

# 증가경우와 감소경우를 따로 생각하기
def up():
    cnt = 0
    chkIdx = -1
    for i in range(1, n):
        if inputs[i-1] > inputs[i]:
            cnt += 1
            chkIdx = i
        if cnt >= 2:
            return False
    if inputs[0] >= inputs[-1] or cnt == 0:
        return chkIdx
    else:
        return False

def down():
    cnt = 0
    chkIdx = -1
    for i in range(1, n):
        if inputs[i - 1] < inputs[i]:
            cnt += 1
            chkIdx = i
        if cnt >= 2:
            return False
    if inputs[0] <= inputs[-1] or cnt == 0:
        return chkIdx
    else:
        return False


upAns = up()
downAns = down()

if upAns == -1 or downAns == -1:
    print(0)
else:
    if upAns and downAns:
        print(min(upAns, downAns))
    elif upAns and not downAns:
        print(upAns)
    elif downAns and not upAns:
        print(downAns)
    else:
        print(-1)
