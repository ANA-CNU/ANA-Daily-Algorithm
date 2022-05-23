import sys

if __name__ == '__main__':
    N, K = map(int, sys.stdin.readline().rstrip().split(" "))
    temperatures = list(map(int, sys.stdin.readline().rstrip().split(" ")))

    # 연속된 K일의 온도 합을 저장하는 배열의 크기는 N-K+1
    sum = [sum(temperatures[:K])]

    for i in range(N-K):
        sum.append(sum[i] - temperatures[i] + temperatures[i+K])

    print(max(sum))