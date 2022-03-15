import sys

if __name__ == '__main__':
    N = int(sys.stdin.readline().rstrip())
    list = []
    for i in range(N):
        temp = sys.stdin.readline().rstrip().split()
        list.append((int(temp[0]), temp[1]))

    list.sort(key=lambda x:x[0])
   
    for i in list:
        print(i[0], i[1])
