# 백준 13335번 트럭
from collections import deque
q = deque()

n,w,l = map(int,input().split())
truck_weight = list(map(int,input().split()))

bridge = [0]*w
cnt = 0
# bridge가 비어있지 않을때 까지 반복
while bridge:
    cnt += 1
    # bridge의 첫번째 원소 제거
    bridge.pop(0)
    if truck_weight:
        if sum(bridge) + truck_weight[0] <= l:
            # turck 의 원소를 제거함과 동시에 bridge에 추가
            bridge.append(truck_weight.pop(0))
        else:
            # l 보다 크면 bridge에 0 추가
            bridge.append(0)

print(cnt)