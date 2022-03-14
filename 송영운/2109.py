from heapq import heappush, heappop
input = __import__('sys').stdin.readline
if __name__ == "__main__":
    n = int(input())
    answer = 0
    lecture = []
    for _ in range(n):
        p, d = map(int, input().split())
        lecture.append((p, d))
    lecture.sort(key=lambda x:x[1])
    q = []
    for l in lecture:
        if len(q) < l[1]:
            heappush(q, l[0])
        else:
            min_price= heappop(q)
            if min_price > l[0]:
                heappush(q, min_price)
            else:
                heappush(q, l[0])
    print(sum(q))


