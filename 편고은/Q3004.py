n = int(input())

if n % 2 == 0:
    print((n // 2 + 1) ** 2)
elif n % 2 == 1:
    print(((n - 1) // 2 + 1) * ((n - 1) // 2 + 2))