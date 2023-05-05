#풀이 1
import sys
input = sys.stdin.readline
n = int(input())
n_list = set(map(int,input().split()))
m = int(input())
m_list = list(map(int,input().split()))

for i in m_list:
    if i in n_list:
        print(1)
    else:
        print(0)
        
# 풀이 2, 이분 탐색을 이용한 풀이
def binary_serch(x,data):
    start = 0
    end = len(data) - 1

    while start <= end:
        mid = (start+end)//2

        if data[mid] == x:
            return 1
        elif data[mid] < x:
            start = mid + 1
        else:
            end = mid - 1
    return None

n = int(input())
n_arr = sorted(list(map(int,input().split())))
# 이분탐색을 사용하기 위해 정렬
m = int(input())
m_arr = list(map(int,input().split()))

for i in m_arr:
    if binary_serch(i,n_arr):
        print(1)
    else:
        print(0)