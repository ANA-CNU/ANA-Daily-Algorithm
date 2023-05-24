#백준 1094
import sys
input = sys.stdin.readline

x = int(input())

stick = [64]

while True:
    if sum(stick) > x:
        stick.sort()
        half_stick = int(stick[0]/2) # 막대기를 반으로 나눔
        stick.remove(stick[0]) # 기존에 저장된 막대기 제거
        stick.extend([half_stick,half_stick]) # 반으로 나눠진 막대기 저장

        if (sum(stick)-half_stick) >= x: # 위에서 자른 막대의 절반 중 하나를 버리고 남아있는 막대의 길이의 합이 X보다 크거나 같다면, 
            stick.remove(half_stick)     # 위에서 자른 막대의 절반 중 하나를 버린다.
    
    else:
        break

print(len(stick)) 