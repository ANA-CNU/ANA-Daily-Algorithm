import sys

if __name__ == '__main__':
    T = int(sys.stdin.readline().rstrip())
    
    f = [0] * 41
    f[0] = 0
    f[1] = 1

    for i in range(2,41):
        f[i] = f[i-1] + f[i-2]

    for i in range(T):
        num = int(sys.stdin.readline().rstrip())
        if(num == 0):
            print(1, 0)
        elif(num == 1):
            print(0, 1)
        else:
            print(f[num-1], f[num])  