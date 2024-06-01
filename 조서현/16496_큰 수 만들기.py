import functools


def cmp(a: str, b: str):
    if a + b > b + a:
        return -1
    if a + b == b + a:
        return 0
    return 1


n = int(input())
arr = input().split()
arr.sort(key=functools.cmp_to_key(cmp))
print(int(''.join(arr)))