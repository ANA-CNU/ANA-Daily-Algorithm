input = __import__('sys').stdin.readline
if __name__ == "__main__":
    n = int(input())
    d = {}
    for _ in range(n):
        num = int(input())
        if num not in d:
            d[num] = 1
        else:
            d[num] = d[num] + 1
    sdict = sorted(d.items())
    for s in sdict:
        for i in range(s[1]):
            print(s[0])