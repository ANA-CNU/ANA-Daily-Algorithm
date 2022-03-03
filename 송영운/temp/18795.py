input = __import__('sys').stdin.readline
if __name__ == "__main__":
    n, m = map(int, input().split())
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))
    s = sum(a) + sum(b)
    print(s)