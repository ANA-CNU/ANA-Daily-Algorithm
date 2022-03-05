if __name__ == '__main__':
    N = int(input())
    temp = 0
    count = 0
    while True:
        count = count+1
        if str(count).find("666") != -1:
            temp = temp + 1
            if temp == N:
                answer = count
                break

    print(answer)