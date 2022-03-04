import sys

if __name__ == '__main__':
    N = int(input())
    str = sys.stdin.readline().rstrip()

    answer = str.count("pPAp")
    print(answer)
