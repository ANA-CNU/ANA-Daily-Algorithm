# 1992

def ArrayHasSameElement(array):
    N = len(array)

    isSame = True

    for i in range(N):
        for j in range(N):
            if array[0][0] != array[i][j]:
                isSame = False
                return isSame

    return isSame

def DivideAndConquer(array):
    N = len(array)

    if ArrayHasSameElement(array):
        if array[0][0] == '0':
            return str(0)

        else:
            return str(1)

    subArrayList = [ [], [], [], [] ]
    for i in range(N):
        if i < (N//2):
            subArrayList[0].append(array[i][:(N//2)])
            subArrayList[1].append(array[i][(N//2):])

        else:
            subArrayList[2].append(array[i][:(N//2)])
            subArrayList[3].append(array[i][(N//2):])
    
    subArrayResult = []
    for subArray in subArrayList:
        subArrayResult.append(DivideAndConquer(subArray))

    result = ""
    for r in subArrayResult:
        if len(r) > 1:
            result += "(" + r + ")"

        else:
            result += r

    return result

N = int(input())

Array = []

for i in range(N):
    Array.append(input())

result = DivideAndConquer(Array)

if len(result) > 1:
    print("("+result+")")
else:
    print(result)

