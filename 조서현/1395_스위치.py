import math
import sys


class ArraySegmentTree:
    def __init__(self, init_arr, init_val, combine_func):
        n = len(init_arr)
        self.init_arr = init_arr
        self.init_val = init_val
        self.combine_func = combine_func
        self.tree = [init_val for _ in range(pow(2, math.ceil(math.log(n, 2) + 1)))]
        self.lazy = [init_val for _ in range(pow(2, math.ceil(math.log(n, 2) + 1)))]
        self.location = [0] * n
        self.make_segment_tree(0, n - 1, 1)

    def make_segment_tree(self, left, right, i=1):
        if left == right:
            # 리프 노드라면 자기 자신 저장
            self.tree[i] = self.init_arr[left]
            # 리프 노드의 인덱스 저장
            self.location[left] = i
            return self.tree[i]
        mid = (left + right) // 2
        # segment에 대한 연산
        self.tree[i] = self.combine_func(self.make_segment_tree(left, mid, i * 2), self.make_segment_tree(mid + 1, right, i * 2 + 1))
        return self.tree[i]

    def propagate_lazy(self, start, end, i):
        # lazy[i]가 1이라면
        if self.lazy[i] != self.init_val:
            # 범위 내의 스위치를 반전 시킨다 -> 켜진 스위치의 개수가 거꾸로 된다.
            self.tree[i] = (end - start + 1) - self.tree[i]
            if start != end:
                # 자식 노드에게로 전파한다
                self.lazy[i * 2] ^= self.lazy[i]
                self.lazy[i * 2 + 1] ^= self.lazy[i]
            # 전파 이후 본인 노드는 다시 초깃값으로
            self.lazy[i] = self.init_val

    def search(self, start, end, left, right, i=1):
        self.propagate_lazy(start, end, i)
        # 범위를 벗어나면 기본값 리턴
        if end < left or start > right:
            return self.init_val
        # 찾는 범위 왼쪽이 구간 왼쪽보다 작거나 같고,
        # 찾는 범위 오른쪽이 구간 오른쪽보다 크거나 같으면 구간값 리턴
        if left <= start and end <= right:
            return self.tree[i]
        mid = (start + end) // 2
        return self.combine_func(self.search(start, mid, left, right, i * 2), self.search(mid + 1, end, left, right, i * 2 + 1))

    def switch_range(self, start, end, left, right, i = 1):
        self.propagate_lazy(start, end, i)
        if end < left or start > right:
            return
        if left <= start and end <= right:
            # 범위 내의 스위치를 반전 시킨다 -> 켜진 스위치의 개수가 거꾸로 된다.
            self.tree[i] = (end - start + 1) - self.tree[i]
            if start != end:
                # 자식 노드에게로 전파한다
                self.lazy[i * 2] ^= 1
                self.lazy[i * 2 + 1] ^= 1
            return
        mid = (start + end) // 2
        self.switch_range(start, mid, left, right, i * 2)
        self.switch_range(mid + 1, end, left, right, i * 2 + 1)
        self.tree[i] = self.combine_func(self.tree[i * 2], self.tree[i * 2 + 1])


n, m = map(int, input().split())
seg = ArraySegmentTree([0] * n, 0, lambda x, y: x + y)
for _ in range(m):
    a, b, c = map(int, sys.stdin.readline().split())
    if a == 0:
        seg.switch_range(0, n - 1, b - 1, c - 1)
    else:
        print(seg.search(0, n - 1, b - 1, c - 1))

# https://www.acmicpc.net/problem/1395