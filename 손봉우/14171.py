N = int(input())
d = {}

cnt = 0
for _ in range(N):
    state, code = input().split()
    state = state[:2]

    if state == code: continue

    if (state, code) not in d:
        d[(state, code)] = 0
    d[(state,code)] += 1

    if (code, state) in d:
        cnt += d[(code, state)]

print (cnt)