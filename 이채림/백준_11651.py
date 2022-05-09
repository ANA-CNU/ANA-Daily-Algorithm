import sys

if __name__ == "__main__":
    N = int(sys.stdin.readline().rstrip())
    coordinates = []
    for i in range(N):
        xi, yi = map(int, sys.stdin.readline().rstrip().split(" "))
        coordinates.append((xi, yi))
    
    coordinates.sort(key=lambda x:(x[1],x[0]))

    for i,j in coordinates:
        print(i,j)