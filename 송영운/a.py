input = __import__('sys').stdin.readline
if __name__ == "__main__":
    n = int(input())
    ans = 0
    for i in range(1, n+1):
        ans += i*(n//i)
    print(ans)