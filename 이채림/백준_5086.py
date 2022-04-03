import sys
if __name__ == '__main__':
    while(True):
        F,T = map(int, sys.stdin.readline().rstrip().split(" "))
        if F==0 and T==0:
            break
        else:
            if T%F==0:
                print("factor")
            elif F%T==0:
                print("multiple")
            else:
                print("neither")

   