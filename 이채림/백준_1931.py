import sys

if __name__ == '__main__':
    N = int(sys.stdin.readline().rstrip())

    list = []
    for i in range(N):
        a, b = map(int, sys.stdin.readline().rstrip().split(" "))
        list.append((a,b))

    list.sort(key=lambda x:(x[1],x[0]))
    
    cnt = 0
    end_time = 0

    for s,e in list:
        if end_time <= s:
            cnt += 1
            end_time = e
    
    print(cnt)