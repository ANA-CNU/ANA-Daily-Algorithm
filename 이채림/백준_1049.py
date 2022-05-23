import sys

if __name__ == '__main__':
    N, M = map(int, sys.stdin.readline().rstrip().split())
    money = 0
    six = []
    one = []

    for i in range(M):
        s,o =map(int, sys.stdin.readline().rstrip().split())
        six.append(s)
        one.append(o)
    
    six.sort()
    one.sort()

    if (one[0] * 6) > six[0]: # 낱개 6개보다 패키지가 쌈
        # 패키지로 살 수 있는데까지 삼
        # 나머지를 패키지1개로 살지, 낱개 가격으로 살지 결정
        if one[0] * (N%6) > six[0]: # 이땐 패키지 하나 더 사는게 나음
            money = (N//6) * six[0] + six[0]
        else:
            money = (N//6) * six[0] + (N%6) * one[0]
    else: # 낱개 6개값이 패키지값보다 쌈. 다 낱개로 사기
        money = N * one[0]


    print(money)