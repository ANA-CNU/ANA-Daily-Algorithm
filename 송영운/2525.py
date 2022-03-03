input = __import__('sys').stdin.readline
if __name__ == "__main__":
    h, m = map(int, input().split())
    t = int(input())
    m += t
    add_h, m = m//60, m%60
    h += add_h
    if h >= 24:
        h -= 24
    print(h, m)