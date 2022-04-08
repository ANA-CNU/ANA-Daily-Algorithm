from heapq import heappop, heappush
input = __import__('sys').stdin.readline
if __name__ == "__main__":
    n = int(input())
    conf = []
    for i in range(n):
        s, f = map(int, input().split())
        conf.append((s, f))
    conf.sort(key=lambda x:(x[0], x[1]))
    ans = 1
    finish_times = []
    min_finish_time = 0
    for c in conf:
        if c[0] < min_finish_time:
            ans += 1
            heappush(finish_times, c[1])
            temp = heappop(finish_times)
            if min_finish_time > temp:
                heappush(finish_times, min_finish_time)
                min_finish_time = temp
            else:
                heappush(finish_times, temp)
        else:
            heappush(finish_times, c[1])
            min_finish_time = heappop(finish_times)
    print(ans)
