import sys

t, k = map(int, sys.stdin.readline().split())
skill = []
for _ in range(5):
    data = list(map(int, sys.stdin.readline().split()))
    skill.append([0] + data[1:])

m = int(sys.stdin.readline().rstrip())
a = [[0, [0, 0, 0, 0, 0]]] + [[i] for i in map(int, sys.stdin.readline().split())]
for i in range(m):
    a[i+1].append(list(map(int, sys.stdin.readline().split())))

m = int(sys.stdin.readline().rstrip())
b = [[0, [0, 0, 0, 0, 0]]] + [[i] for i in map(int, sys.stdin.readline().split())]
for i in range(m):
    b[i+1].append(list(map(int, sys.stdin.readline().split())))

m = int(sys.stdin.readline().rstrip())
c = [[0, [0, 0, 0, 0, 0]]] + [[i] for i in map(int, sys.stdin.readline().split())]
for i in range(m):
    c[i+1].append(list(map(int, sys.stdin.readline().split())))

res = 0
for x in a:
    for y in b:
        for z in c:
            cost = x[0] + y[0] + z[0]
            if cost > t:
                continue

            power = [0, 0, 0, 0, 0]
            for i in range(5):
                power[i] += (x[1][i] + y[1][i] + z[1][i])

            st = 0
            for i in range(5):
                st += skill[i][min(power[i], len(skill[i])-1)]
            res = max(res, st)

            if cost + k <= t:
                for plus in range(5):
                    for minus in range(5):
                        if power[minus] == 0:
                            continue

                        power_re = [p for p in power]
                        power_re[plus] += 1
                        power_re[minus] -= 1

                        st = 0
                        for i in range(5):
                            st += skill[i][min(power_re[i], len(skill[i])-1)]
                        res = max(res, st)

print(res)