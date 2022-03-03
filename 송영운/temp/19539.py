def div2(n):
    return n // 2

input = __import__('sys').stdin.readline
if __name__ == "__main__":
    n = int(input())
    w = list(map(int, input().split()))
    w_div2 = list(map(div2, w))
    sum_w = sum(w)
    sum_w_div2 = sum(w_div2)
    count = sum_w // 3
    if sum_w % 3 == 0 and sum_w_div2 >= count:
        print('YES')
    else:
        print('NO')
