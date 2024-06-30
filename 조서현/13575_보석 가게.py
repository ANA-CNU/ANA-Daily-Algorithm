import sys

mod = 998244353
w = 3


def ntt(a, inverse=False):
    n = len(a)
    j = 0
    for i in range(1, n):
        reverse = n // 2
        while j >= reverse:
            j -= reverse
            reverse //= 2
        j += reverse
        if i < j:
            a[i], a[j] = a[j], a[i]
    step = 2
    while step <= n:
        half = step // 2
        u = pow(w, mod // step, mod)
        if inverse:
            u = pow(u, mod - 2, mod)
        for i in range(0, n, step):
            wi = 1
            for j in range(i, i + half):
                v = a[j + half] * wi
                a[j + half] = (a[j] - v) % mod
                a[j] = (a[j] + v) % mod
                wi = (u * wi) % mod
        step *= 2

    if inverse:
        num = mod - (mod - 1) // n
        for i in range(n):
            a[i] = (a[i] * num) % mod


def multiply_ntt(a, b):
    n = 1
    while n < len(a):
        n <<= 1
    while n < len(b):
        n <<= 1
    n <<= 1
    while len(a) < n:
        a.append(0)
    while len(b) < n:
        b.append(0)
    ntt(a)
    ntt(b)
    c = []
    for i in range(n):
        c.append(a[i] * b[i])
    ntt(c, True)
    return c


def strip(array: list[int]):
    for i in range(len(array) - 1, -1, -1):
        if not array[i]: array.pop()
        else: break


n, k = map(int, sys.stdin.readline().split())
a = list(map(int, sys.stdin.readline().split()))

arr = [0] * 1001
for e in a:
    arr[e] = 1

strip(arr)
tmp = arr[:]
k -= 1
while k:
    if k & 1:
        arr = multiply_ntt(arr[:], tmp[:])
        strip(arr)
    k >>= 1
    tmp = multiply_ntt(tmp[:], tmp[:])
    strip(tmp)
    # print(k)

for i in range(len(arr)):
    if arr[i] > 0: sys.stdout.write(str(i) + ' ')
sys.stdout.write('\n')