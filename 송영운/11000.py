from heapq import heappop, heappush
input = __import__('sys').stdin.readline
if __name__ == "__main__":
    n = int(input())
    room = []
    lecture = []
    for _ in range(n):
        s, t = map(int, input().split())
        lecture.append((s, t))
    lecture.sort()
    s, t = lecture.pop(0)
    heappush(room, t)
    for l in lecture:
        s, t = l[0], l[1]
        inTrue = False
        if room[0] <= s:
            heappop(room)
            heappush(room, t)
            inTrue = True
        if not inTrue:
            heappush(room, t)
    print(len(room))