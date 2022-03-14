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
        heappush(q, l[0])
        if len(q) > l[1]:
            heappop(q)
    print(sum(q))