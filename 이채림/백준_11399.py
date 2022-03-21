import sys
def cumulativeSum(N,list):
    temp = []
    temp.append(list[0])
    for i in range(1,N):
        temp.append(temp[i-1] + list[i])
    timeSum = sum(temp)
    return timeSum
    
if __name__ == '__main__':
    N = int(sys.stdin.readline().rstrip())
    list = list(map(int, sys.stdin.readline().rstrip().split(" ")))

    list.sort()

    print(cumulativeSum(N,list))