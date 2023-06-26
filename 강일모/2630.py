import sys

def arrayHasSameElements(array):
    isSame = True

    for i in range(len(array)):
        for j in range(len(array)):
            if array[0][0] != array[i][j]:
                isSame = False
                return isSame

    return isSame


def divide_and_conquer(array, blue, white):
    n = len(array)

    if len(array) == 1:
        if array[0][0] == 1:
            blue += 1
            return (blue, white)
        
        else:
            white += 1
            return (blue, white)

    if arrayHasSameElements(array):
        if array[0][0] == 1:
            return (blue+1, white)
        
        else:
            return (blue, white+1)
        
    # N//2 Size Array 로 Divide
    subArrayList = [[], [], [], []] #Sub1, Sub2, Sub3, Sub4

    for i in range(n):
        if i < (n//2):
            subArrayList[0].append(array[i][0:(n//2)])
            subArrayList[1].append(array[i][(n//2):])

        else:
            subArrayList[2].append(array[i][0:(n//2)])
            subArrayList[3].append(array[i][(n//2):])

    for subArray in subArrayList:
        if arrayHasSameElements(subArray): #Array 의 원소가 모두 같을 때
            if subArray[0][0] == 1:
                blue += 1

            else:
                white += 1

        else:
            blue, white = divide_and_conquer(subArray, blue, white) #Array 의 원소가 모두 같지 않을 때

    return (blue, white)


N = int(input())

array = []

for i in range(N):
    array.append(list(map(int, input().split())))

blue, white = divide_and_conquer(array, 0, 0)

print(white)
print(blue)