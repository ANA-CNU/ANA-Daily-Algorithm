n, b = map(int, input().split())
digit = []
num = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"

while n > 0:
    quotient = n % b
    n //= b
    digit.append(num[quotient])

print(''.join(reversed(digit)))
