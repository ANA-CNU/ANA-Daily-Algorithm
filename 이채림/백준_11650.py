import sys


if __name__ == '__main__':
    N = int(sys.stdin.readline().rstrip())
    list = []
    for i in range(N):
        coordinates = sys.stdin.readline().rstrip().split(" ")
        list.append((int(coordinates[0]), int(coordinates[1])))

    list.sort(key=lambda x:(x[0], x[1]))

    for xy in list:
        print(xy[0], xy[1])