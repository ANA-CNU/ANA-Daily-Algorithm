import sys

if __name__ == '__main__':

    while True:
        plays = int(sys.stdin.readline().rstrip())
        
        if plays==0:
            break

        A_point = 0
        B_point = 0

        A = list(map(int, sys.stdin.readline().rstrip().split(" ")))
        B = list(map(int, sys.stdin.readline().rstrip().split(" ")))

        for i in range(plays):
            # 한 개 차이면 적은 수를 가진 애가 이김
            # 자신의 카드 넘버와 상대의 카드 넘버 만큼
            if abs(A[i]-B[i]) == 1:
                if A[i] > B[i]:
                    if A[i] == 2:
                        B_point += 6
                    else:
                        B_point += A[i] + B[i]
                else:   # B[i] > A[i]
                    if B[i] == 2:
                        A_point += 6
                    else:
                        A_point += A[i] + B[i]
            elif A[i] < B[i]:
                B_point += B[i]
            elif A[i] > B[i]:
                A_point += A[i]

        print("A has {} points. B has {} points.\n".format(A_point, B_point))