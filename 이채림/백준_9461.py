import sys

if __name__ == '__main__':
    list = [1,1,1]

    T = int(sys.stdin.readline().rstrip())
    pn = []
    for i in range(T):
        pn.append(int(sys.stdin.readline().rstrip()))
    
    maximum = max(pn)

    for i in range(3, maximum):
        list.append(list[i-2] + list[i-3])
  
    for i in range(T):
        print(list[pn[i]-1])