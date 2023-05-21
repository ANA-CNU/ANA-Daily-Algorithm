def mmul(A, B):
    C = [[0] * len(B[0]) for _ in range(len(A))]
    for i in range(len(C)):
        for j in range(len(C[0])):
            for k in range(len(A[0])):
                C[i][j] += A[i][k] * B[k][j]
            C[i][j] %= 10000
    return C

def mpow(a, n):
    if n == 1:
        return a
    a = mpow(a, n//2)
    a = mmul(a, a)
    if n%2 == 1:
        return mmul(a, [[1, 1], [1, 0]])
    return a

while(True):
   n = int(input())
   if(n == -1):
      break
   if(n == 0):
       print(0)
   else:
       rv = mpow([[1, 1], [1, 0]], n)
       print(rv[0][1])
   
   