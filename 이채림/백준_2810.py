import sys

if __name__ == '__main__':
    N = int(sys.stdin.readline().rstrip())

    seats = sys.stdin.readline().rstrip()
    l_seat = 0
    s_seat = 0

    for i in range(N):
        if seats[i] == 'L':
            l_seat += 1
        else:
            s_seat += 1
    max_person = 1 + s_seat + (l_seat//2)
    
    if max_person > N:
        max_person = N

    print(max_person)