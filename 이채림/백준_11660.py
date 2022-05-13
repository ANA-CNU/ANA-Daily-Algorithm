import sys

if __name__ == '__main__':
    N,M = map(int, sys.stdin.readline().rstrip().split(" "))
    arr = []
    sum =  [[0 for i in range(N + 1)] for i in range(N + 1)]
    
    for i in range(N):
        temp = list(map(int, sys.stdin.readline().rstrip().split(" ")))
        arr.append(temp)
    # 합
    for i in range(N):
        for j in range(N):
            sum[i+1][j+1] = sum[i][j+1] + sum[i+1][j] - sum[i][j] + arr[i][j]

    for i in range(M):
        x1,y1,x2,y2 = map(int, sys.stdin.readline().rstrip().split(" "))
        print(sum[x2][y2] - sum[x1-1][y2] -sum[x2][y1-1] + sum[x1-1][y1-1])
    
    