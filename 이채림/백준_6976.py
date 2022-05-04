import sys

if __name__ == "__main__":
    N = int(sys.stdin.readline().rstrip())

    for i in range(N):
        num = int(sys.stdin.readline().rstrip())
        temp = num
        print(num)
        
        while temp >= 100:
            strNum = str(temp)
            temp = int(strNum[:-1]) - int(strNum[-1])
            print(temp)

        if (temp % 11 == 0):
            print("The number {} is divisible by 11.".format(num))
        else:
            print("The number {} is not divisible by 11.".format(num))
        print()

