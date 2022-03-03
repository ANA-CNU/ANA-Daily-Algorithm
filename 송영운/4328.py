def decimalToN(n, b):
    tmp_str = ''
    if n == 0:
        return 0
    while n > 0:
        r = n % b
        n //= b
        tmp_str += str(r)
    return "".join(reversed(tmp_str))

input = __import__('sys').stdin.readline
if __name__ == "__main__":
    while True:
        line = input()
        line = line.strip()
        if line == '0':
            break
        b, p, m = map(str, line.split())
        b = int(b)
        decimal_p, decimal_m = int(p, b), int(m, b)
        decimal_remain = decimal_p % decimal_m
        print(decimalToN(decimal_remain, b))
