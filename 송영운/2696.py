from heapq import heappush, heappop
input = __import__('sys').stdin.readline
if __name__ == "__main__":
    t = int(input())
    for _ in range(t):
        m = int(input())
        a = []
        if m % 10 == 0:
            r = m//10
        else:
            r = m//10 + 1
        for i in range(r):
            for l in list(map(int, input().split())):
                a.append(l)
        bigger_q = []
        lower_q = []
        ans = []
        ans.append(a[0])
        mid = a[0]
        if m > 2:
            for i in range(1, m):
                if mid > a[i]:
                    heappush(lower_q, -a[i])
                else:
                    heappush(bigger_q, a[i])

                if i%2 == 0:
                    if len(bigger_q) > len(lower_q):
                        heappush(lower_q, -mid)
                        mid = heappop(bigger_q)
                    elif len(lower_q) > len(bigger_q):
                        heappush(bigger_q, mid)
                        mid = -heappop(lower_q)
                    ans.append(mid)
        l = len(ans)
        print(l)
        for i in range(l):
            if i != 0 and (i+1)%10 == 1:
                print()
            print(ans[i], end=' ')
        print()