import sys
from math import ceil
N, atk = map(int, input().split())
rooms = [list(map(int, input().split())) for _ in range(N)]


def fight(hp, Atk):
    hp_f = hp
    for r in rooms:
        t, a, h = r
        if t == 1:
            if ceil(h / Atk) <= ceil(hp / a):
                hp = hp - (ceil(h / Atk) - 1) * a
            elif ceil(h / Atk) > ceil(hp / a):
                return False
        elif t == 2: # 포션
            Atk += a
            hp += h
            if hp_f <= hp:
                hp = hp_f
    return True


start, end = 1, sys.maxsize

while start <= end:
    mid = (start + end) // 2
    if fight(mid, atk):
        end = mid - 1
    elif not fight(mid, atk):
        start = mid + 1
print(start)