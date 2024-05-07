import math
import sys

# sys.stdin = open('tools/testcase.txt', 'r')
n = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().split()))
tree = [0] * pow(2, math.ceil(math.log(n, 2) + 1))
lazy = [0] * pow(2, math.ceil(math.log(n, 2) + 1))
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
    tree[i] = seg(left, mid, i * 2) + seg(mid + 1, right, i * 2 + 1)
    return tree[i]


def search(start, end, left, right, i=1):
    # lazy하게 업데이트
    update_lazy(start, end, i)
    # 범위를 벗어나면 0 리턴
    if end < left or start > right:
        return 0
    # 찾는 범위 왼쪽이 구간 왼쪽보다 작거나 같고,
    # 찾는 범위 오른쪽이 구간 오른쪽보다 크거나 같으면 구간값 리턴
    if left <= start and end <= right:
        return tree[i]
    mid = (start + end) // 2
    return search(start, mid, left, right, i * 2) + search(mid + 1, end, left, right, i * 2 + 1)


def update_lazy(start, end, node):
    if lazy[node] != 0:
        tree[node] += (end - start + 1) * lazy[node]
        if start != end:
            lazy[node * 2] += lazy[node]
            lazy[node * 2 + 1] += lazy[node]
        lazy[node] = 0


def update_range(start, end, left, right, i, diff):
    update_lazy(start, end, i)
    if end < left or start > right:
        return
    if left <= start and end <= right:
        tree[i] += (end - start + 1) * diff
        if start != end:
            lazy[i * 2] += diff
            lazy[i * 2 + 1] += diff
        return
    mid = (start + end) // 2
    update_range(start, mid, left, right, i * 2, diff)
    update_range(mid + 1, end, left, right, i * 2 + 1, diff)
    tree[i] = tree[i * 2] + tree[i * 2 + 1]


seg()
m = int(sys.stdin.readline())
for _ in range(m):
    a, *b = map(int, sys.stdin.readline().split())
    if a == 1:
        update_range(0, n - 1, b[0] - 1, b[1] - 1, 1, b[2])
    else:
        print(search(0, n - 1, b[0] - 1, b[0] - 1))