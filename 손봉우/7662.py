import heapq

T = int(input())
for i in range(T):
    k = int(input())

    LA = []
    LB = []
    index = [False] * k
    for j in range(k):
        line = input().split()
        line[1] = int(line[1])
        if line[0] == 'I':
            heapq.heappush(LA, (line[1], j))
            heapq.heappush(LB, (-line[1], j))
            index[j] = True
        else:
            if len(LA) == 0:
                continue
            size = len(LA)
            temp = 0
            if line[1] == -1:
                while LA and not index[LA[0][1]]:
                    heapq.heappop(LA)
                if LA:
                    index[LA[0][1]] = False
                    heapq.heappop(LA)
            else:
                while LB and not index[LB[0][1]]:
                    heapq.heappop(LB)
                if LB:
                    index[LB[0][1]] = False
                    heapq.heappop(LB)
            
    while LA and not index[LA[0][1]]:
        heapq.heappop(LA)
    while LB and not index[LB[0][1]]:
        heapq.heappop(LB)

    if len(LA) == 0:
        print ('EMPTY')
    else:
        print (-LB[0][0], LA[0][0])