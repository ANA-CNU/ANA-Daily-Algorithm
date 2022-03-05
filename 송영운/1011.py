import math
input = __import__('sys').stdin.readline
if __name__ == "__main__":
    t = int(input())
    for _ in range(t):
        x, y = map(int, input().split())
        d = y - x
        d_sqrt = int(math.sqrt(d)) + 1
        d_sqrt_pow = d_sqrt**2
        d_sqrt_count = 2*d_sqrt - 1
        minus_count = d_sqrt_pow - d
        count = 0
        for i in range(minus_count):
            count += 1
            if count == d_sqrt:
                d_sqrt_count -= 1
                d_sqrt -= 1
                count = 0

        print(d_sqrt_count)

