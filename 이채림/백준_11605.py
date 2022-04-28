import sys
from traceback import print_tb

if __name__ == '__main__':
    N = int(sys.stdin.readline().rstrip())

    number = [i for i in range(1,101)]
    isMess = [False for _ in range(100)]
    result = 0


    for i in range(N):
        arr = list(sys.stdin.readline().rstrip().split(" "))
        for j in range(100):
            if arr[0] == "ADD":
                number[j] = number[j] + int(arr[1])
                
            elif arr[0] == "SUBTRACT":
                number[j] = number[j] - int(arr[1])
        
            elif arr[0] == "MULTIPLY":
                number[j] = number[j] * int(arr[1])
        
            elif arr[0] == "DIVIDE":
                number[j] = number[j] / int(arr[1])
            
            if isMess[j] == False:
                if number[j] < 0:
                    result += 1
                    isMess[j] = True

                elif str(type(number[j])) == "<class 'float'>":
                    if (number[j]).is_integer() == False:
                        result += 1
                        isMess[j] = True
        
    
    print(result)