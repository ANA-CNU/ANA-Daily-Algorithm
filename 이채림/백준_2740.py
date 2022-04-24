import sys

if __name__ == '__main__':
    N,M = map(int, sys.stdin.readline().rstrip().split(" "))
    
    A = [0] * N

    for i in range(N):
        A[i] = list(map(int, sys.stdin.readline().rstrip().split(" ")))
    
    M,K = map(int, sys.stdin.readline().rstrip().split(" "))

    B = [0] * M

    for i in range(M):
        B[i] = list(map(int, sys.stdin.readline().rstrip().split(" ")))
    
    C = [[0]* K for _ in range(N)]

    for i in range(N):
        for j in range(K):
            for k in range(M):
                C[i][j] += A[i][k] * B[k][j]

    for r in C:
        print(*r)