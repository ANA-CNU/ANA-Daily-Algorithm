import time

N = 10**8
start = time.time()
a = [0]*N
print("time :", time.time() - start)

start = time.time()
b = [0 for _ in range(N)]
print("time :", time.time() - start)
