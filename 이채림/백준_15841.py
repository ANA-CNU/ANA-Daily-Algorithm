import sys

if __name__ == '__main__':
    arr = []
    
    while True:
        temp = int(sys.stdin.readline().rstrip())
        if temp == -1:
            break   
        arr.append(temp)
    
    fibo = [1] * (max(arr)+1)

    for i in range(3,max(arr)+1):
        fibo[i] = fibo[i-1] + fibo[i-2]
    
    for i in arr:
        print("Hour {}: {} cow(s) affected".format(i,fibo[i]))