import math
import sys

mod = 1000000000 + 7

n, m, k = map(int, sys.stdin.readline().split())
arr = [int(sys.stdin.readline()) for _ in range(n)]
tree = [0] * pow(2, math.ceil(math.log(n, 2) + 1))
location = [0] * n


def seg(left=0, right=n - 1, i=1):
    if left == right:
        # 리프 노드라면 자기 자신 저장
        tree[i] = arr[left]
        # 리프 노드의 인덱스 저장
        location[left] = i
        return tree[i]
    mid = (left + right) // 2
    # segment에 대한 연산
    tree[i] = seg(left, mid, i * 2) * seg(mid + 1, right, i * 2 + 1) % mod
    return tree[i]


def search(start, end, left, right, i=1):
    # 범위를 벗어나면 0 리턴
    if end < left or start > right:
        return 1
    # 찾는 범위 왼쪽이 구간 왼쪽보다 작거나 같고,
    # 찾는 범위 오른쪽이 구간 오른쪽보다 크거나 같으면 구간값 리턴
    if left <= start and end <= right:
        return tree[i]
    mid = (start + end) // 2
    return search(start, mid, left, right, i * 2) * search(mid + 1, end, left, right, i * 2 + 1) % mod


def update(i, val):
    idx = location[i]
    tree[idx] = val
    while idx > 1:
        idx //= 2
        tree[idx] = tree[idx * 2] * tree[idx * 2 + 1] % mod


seg()
for _ in range(m + k):
    # print(tree)
    a, b, c = map(int, sys.stdin.readline().split())
    if a == 1:
        update(b - 1, c)
    else:
        # print(tree)
        print(search(0, n - 1, b - 1, c - 1))