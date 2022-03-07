input = __import__('sys').stdin.readline
if __name__ == "__main__":
    n, m = map(int, input().split())
    know = list(map(int, input().split()))
    know.pop(0)
    s = set(know)
    party = []
    for i in range(m):
        participant = list(map(int, input().split()))
        participant.pop(0)
        party.append(participant)

    visit_party = [False]*m
    while True:
        count = 0
        for i in range(len(party)):
            if visit_party[i] == True:
                continue
            for man_num in party[i]:
                if man_num in s:
                    for man in party[i]:
                        s.add(man)
                    count += 1
                    visit_party[i] = True
                    break

        if count == 0:
            break
    print(visit_party.count(False))