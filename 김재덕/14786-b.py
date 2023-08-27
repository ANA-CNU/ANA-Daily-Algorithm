import math

EPSILON = 0.0000000001

def newton_raphson(a: int, b: int, c: int) -> float:
    x0 = 1.0

    while True:
        f_x0 = a * x0 + b * math.sin(x0) - c
        fp_x0 = a + b * math.cos(x0)

        # TODO: `fp_x0`가 혹시라도 0이라면...?
        x1 = x0 - (f_x0 / fp_x0)

        if abs(x1 - x0) < EPSILON:
            return x1

        x0 = x1

if __name__ == "__main__":
    a, b, c = map(int, input().split())

    print(newton_raphson(a, b, c))
