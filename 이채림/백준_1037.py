import sys

if __name__ == '__main__':
    num = int(sys.stdin.readline().rstrip())
    divisors = list(map(int, sys.stdin.readline().rstrip().split(" ")))

    print(max(divisors) * min(divisors))