import sys

if __name__ == '__main__':
    S = int(sys.stdin.readline().rstrip())
    sum = 0 # 합
    result = 0 # 개수 저장
    

    for i in range(1,4294967295):
        if sum > S:
            break
        
        sum += i
        result += 1

    print(result-1)
