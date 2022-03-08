from collections import Counter
import sys
# input()을 sys.stdin.readline().rstrip()으로 고쳐서 시간초과 해결

if __name__ == '__main__':
    N = int(sys.stdin.readline().rstrip())
    list = [] 

    for i in range(N):
        num = int(sys.stdin.readline().rstrip())
        list.append(num)

    list.sort()

    # 산술 평균
    sum = sum(list)
    average = int(round(sum / N, 0))

    # 중앙값
    middle = list[int(N/2)]

    # 최빈값
    mode_list = Counter(list).most_common()
    mode_freq = mode_list[0][1]
    mode = mode_list[0][0]
    modes = []

    for i in mode_list:
        if i[1] == mode_freq:
            modes.append(i[0])
            

    if len(modes) > 1:
        modes.sort()
        mode = modes[1]

    # 범위
    range = max(list) - min(list)


    print(average)
    print(middle)
    print(mode)
    print(range)