import sys

def multi(n, k):
    result = n
    for i in range(k-1):
       result = result * (n-1)
       n = n-1
    return result

if __name__ == '__main__':
    M = int(sys.stdin.readline().rstrip()) # 조약돌 색상 수
    
    temp = sys.stdin.readline().rstrip().split() # 각 색상 별 조약돌 개수
    list = []
    for i in temp:
        list.append(int(i))

    K = int(sys.stdin.readline().rstrip())  # 뽑을 조약돌 수
    
    rocks = sum(list)
    numerator = 0   # 분자
    denominator = multi(rocks, K) #분모
   
    # 만약 뽑을 값보다 적은 조약돌의 개수를 가진 색상은 필요없음
    # 해당 색상의 조약돌 제거
    for i in list:
        if(i < K):
            list.remove(i)
                  
    for i in list:
        numerator += multi(i, K)
    
    print(numerator/denominator)
    
