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
        self.make_segment_tree(0, n - 1, 1)

    def make_segment_tree(self, left, right, i=1):
        if left == right:
            # 리프 노드라면 자기 자신 저장
            self.tree[i] = self.init_arr[left]
            return self.tree[i]
        mid = (left + right) // 2
        # segment에 대한 연산
        self.tree[i] = self.combine_func(self.make_segment_tree(left, mid, i * 2), self.make_segment_tree(mid + 1, right, i * 2 + 1))
        return self.tree[i]

    def propagate_lazy(self, start, end, i):
        # lazy[i]가 0이 아니라면
        if self.lazy[i] != self.init_val:
            # 범위 내에서 xor 연산을 한다 => 범위가 짝수면 그대로, 아니면 k 하나
            if (end - start + 1) & 1:
                self.tree[i] ^= self.lazy[i]
            if start != end:
                # 자식 노드에게로 전파한다
                self.lazy[i * 2] ^= self.lazy[i]
                self.lazy[i * 2 + 1] ^= self.lazy[i]
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

    def update_range(self, start, end, left, right, val, i = 1):
        self.propagate_lazy(start, end, i)
        if end < left or start > right:
            return
        if left <= start and end <= right:
            # 범위 내에서 xor 연산을 한다 => 범위가 짝수면 그대로, 아니면 k 하나를 xor
            if (end - start + 1) & 1:
                self.tree[i] ^= val
            if start != end:
                # 자식 노드에게로 전파한다
                self.lazy[i * 2] ^= val
                self.lazy[i * 2 + 1] ^= val
            return
        mid = (start + end) // 2
        self.update_range(start, mid, left, right, val, i * 2)
        self.update_range(mid + 1, end, left, right, val, i * 2 + 1)
        self.tree[i] = self.combine_func(self.tree[i * 2], self.tree[i * 2 + 1])


n = int(input())
arr = list(map(int, input().split()))
m = int(input())
seg = ArraySegmentTree(arr, 0, lambda x, y: x ^ y)
for _ in range(m):
    a, *b = map(int, sys.stdin.readline().split())
    if a == 1:
        seg.update_range(0, n - 1, b[0], b[1], b[2])
    else:
        print(seg.search(0, n - 1, b[0], b[1]))