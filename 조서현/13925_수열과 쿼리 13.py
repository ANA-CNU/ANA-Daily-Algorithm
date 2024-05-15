import math
import sys

mod = pow(10, 9) + 7


class ArraySegmentTree:
    def __init__(self, init_arr):
        n = len(init_arr)
        self.init_arr = init_arr
        self.tree = [0] * pow(2, math.ceil(math.log(n, 2) + 1))
        self.add_lazy = [0] * pow(2, math.ceil(math.log(n, 2) + 1))
        self.mul_lazy = [1] * pow(2, math.ceil(math.log(n, 2) + 1))
        self.make_segment_tree(0, n - 1, 1)

    def make_segment_tree(self, left, right, i=1):
        if left == right:
            # 리프 노드라면 자기 자신 저장
            self.tree[i] = self.init_arr[left]
            return self.tree[i]
        mid = (left + right) // 2
        # segment에 대한 연산
        left_seg = self.make_segment_tree(left, mid, i * 2)
        right_seg = self.make_segment_tree(mid + 1, right, i * 2 + 1)
        self.tree[i] = (left_seg + right_seg) % mod
        return self.tree[i]

    def propagate_lazy(self, start, end, i):
        # 값을 변경해야 한다면
        if self.add_lazy[i] != 0 or self.mul_lazy[i] != 1:
            self.tree[i] = (self.tree[i] * self.mul_lazy[i] + self.add_lazy[i] * (end - start + 1)) % mod
            if start != end:
                self.add_lazy[i * 2] = (self.add_lazy[i * 2] * self.mul_lazy[i] + self.add_lazy[i]) % mod
                self.add_lazy[i * 2 + 1] = (self.add_lazy[i * 2 + 1] * self.mul_lazy[i] + self.add_lazy[i]) % mod
                self.mul_lazy[i * 2] = (self.mul_lazy[i * 2] * self.mul_lazy[i]) % mod
                self.mul_lazy[i * 2 + 1] = (self.mul_lazy[i * 2 + 1] * self.mul_lazy[i]) % mod
            self.add_lazy[i] = 0
            self.mul_lazy[i] = 1

    def search(self, start, end, left, right, i=1):
        # lazy하게 업데이트
        self.propagate_lazy(start, end, i)
        # 범위를 벗어나면 기본값 리턴
        if end < left or start > right:
            return 0
        # 찾는 범위 왼쪽이 구간 왼쪽보다 작거나 같고,
        # 찾는 범위 오른쪽이 구간 오른쪽보다 크거나 같으면 구간값 리턴
        if left <= start and end <= right:
            return self.tree[i]
        mid = (start + end) // 2
        left_seg = self.search(start, mid, left, right, i * 2)
        right_seg = self.search(mid + 1, end, left, right, i * 2 + 1)
        return (left_seg + right_seg) % mod

    def update_range(self, start, end, left, right, i, val, mode):
        self.propagate_lazy(start, end, i)
        if end < left or start > right:
            return
        if left <= start and end <= right:
            if mode == 1:
                self.add_lazy[i] = (self.add_lazy[i] + val) % mod
            elif mode == 2:
                self.add_lazy[i] = (self.add_lazy[i] * val) % mod
                self.mul_lazy[i] = (self.mul_lazy[i] * val) % mod
            else:
                self.mul_lazy[i] = 0
                self.add_lazy[i] = val
            self.propagate_lazy(start, end, i)
            return
        mid = (start + end) // 2
        self.update_range(start, mid, left, right, i * 2, val, mode)
        self.update_range(mid + 1, end, left, right, i * 2 + 1, val, mode)
        self.tree[i] = (self.tree[i * 2] + self.tree[i * 2 + 1]) % mod


n = int(input())
arr = list(map(int, input().split()))
m = int(input())

seg = ArraySegmentTree(arr)
for _ in range(m):
    a, *b = map(int, sys.stdin.readline().split())
    if a == 4:
        print(seg.search(0, n - 1, b[0] - 1, b[1] - 1))
    else:
        seg.update_range(0, n - 1, b[0] - 1, b[1] - 1, 1, b[2], a)