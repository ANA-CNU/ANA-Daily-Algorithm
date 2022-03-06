if __name__ == '__main__':
    N = int(input())
    list = [] * N
    for i in range(N):
        list.append(int(input()))

    list.sort()

    for i in list:
        print(i)