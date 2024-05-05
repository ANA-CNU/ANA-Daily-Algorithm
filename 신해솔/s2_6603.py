from itertools import combinations

while True:
    tmp = input()
    if tmp == "0":
        break
    else:
        _, *set_ = map(int, tmp.split())
        for comb in combinations(set_, 6):
            print(*comb)
        print()
