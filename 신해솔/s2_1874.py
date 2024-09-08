# 스택 수열 - 1874

import sys
input = lambda: sys.stdin.readline().rstrip()


def stack(target: list[int]) -> str | list[str]:
    seq: list[int] = list(range(len(target), 0, -1))
    save: list[int] = []
    result: list[str] = []

    for i in target:
        while True:
            if save and save[-1] == i:
                save.pop()
                result.append("-")
                break

            if not seq:
                return "NO"

            save.append(seq.pop())
            result.append("+")

    return result


def main():
    n = int(input())
    target = [int(input()) for _ in range(n)]
    result = stack(target)

    if type(result) is list:
        for i in result:
            print(i)
    else:
        print(result)


if __name__ == "__main__":
    main()
