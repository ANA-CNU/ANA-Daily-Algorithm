from itertools import combinations
input = __import__('sys').stdin.readline
if __name__ == "__main__":
    while True:
        s = list(map(int, input().split()))
        if len(s) == 1:
            break
        s.pop(0)
        ans = list(combinations(s, 6))
        ans.sort()
        for i in ans:
            print(*i)
        print()