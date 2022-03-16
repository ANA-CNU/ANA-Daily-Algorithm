input = __import__('sys').stdin.readline
if __name__ == "__main__":
    n = int(input())
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))
    for i in range(n):
        a_max_idx = a.index(max(a))
        b_max_idx = b.index(max(b))
        if a[a_max_idx] != b[b_max_idx]:
            print(0)
            exit()
        if b_max_idx == len(b) - 1:
            a.remove(a[a_max_idx])
            b.pop()
            continue
        elif a_max_idx <= b_max_idx:
            a.remove(a[a_max_idx])
            b.remove(b[b_max_idx])
            if set(a[:b_max_idx]) == set(b[:b_max_idx]):
                continue
        print(0)
        exit()
    print(1)