input = __import__('sys').stdin.readline
if __name__ == "__main__":
    n, k = map(int, input().split())
    j = [map(int, input().split()) for i in range(n)]
    c = [int(input()) for i in range(k)]

