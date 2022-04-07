import sys

if __name__ == '__main__':
    
    K, N = map(int, sys.stdin.readline().rstrip().split(" "))
    lines = []
    for i in range(K):
        lines.append(int(sys.stdin.readline().rstrip()))
    
    # 랜선의 최소길이가 1임
    # low를 1로 해야한다.
    # 0으로 하면 zero division error
    low = 1
    high = max(lines)

    while low <= high:
        mid = (low + high) // 2
        cnt = 0

        for line in lines:
            cnt += line // mid
        
        if cnt >= N:
            low = mid + 1
        else:
            high = mid - 1

    print(high)   

