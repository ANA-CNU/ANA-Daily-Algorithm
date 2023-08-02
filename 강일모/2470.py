# 2470
import sys
input = sys.stdin.readline

N = int(input())
solution = list(map(int, input().split()))
solution.sort()

acid = list(filter(lambda x : x > 0, solution))
akaline = list(filter(lambda x : x < 0, solution))
result = 0
resultSet = []

if (len(akaline) > 1) and (len(acid) > 1):
    if abs(acid[0] + acid[1]) <  abs(akaline[-1] + akaline[-2]):
        result = abs(acid[0] + acid[1])
        resultSet = [acid[0], acid[1]]
    else:
        result = abs(akaline[-1] + akaline[-2])
        resultSet = [akaline[-2], akaline[-1]]

elif len(akaline) > 1:
    result = abs(akaline[-1] + akaline[-2])
    resultSet = [akaline[-2], akaline[-1]]

else:
    result = abs(acid[0] + acid[1])
    resultSet = [acid[0], acid[1]]

for ac in acid:
    start = 0
    end = len(akaline) - 1

    while start <= end:
        mid = (start + end) // 2

        if ac + akaline[mid] > 0:
            end = mid - 1
            if abs(ac + akaline[mid]) < result:
                result = abs(ac + akaline[mid])
                resultSet = (akaline[mid], ac)

        else:
            start = mid + 1
            if abs(ac + akaline[mid]) < result:
                result = abs(ac + akaline[mid])
                resultSet = (akaline[mid], ac)


print(str(resultSet[0]) + " " + str(resultSet[1]))
