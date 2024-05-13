import bisect
import math
import sys


class ArraySegmentTree:
    def __init__(self, init_arr, init_val, combine_func):
        n = len(init_arr)
        self.init_arr = init_arr
        self.init_val = init_val
        self.combine_func = combine_func
        self.tree = [init_val for _ in range(pow(2, math.ceil(math.log(n, 2) + 1)))]
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

    def search(self, start, end, left, right, k, i=1):
        # 범위를 벗어나면 기본값 리턴
        if end < left or start > right:
            return self.init_val
        # 찾는 범위 왼쪽이 구간 왼쪽보다 작거나 같고,
        # 찾는 범위 오른쪽이 구간 오른쪽보다 크거나 같으면 구간값 리턴
        if left <= start and end <= right:
            if isinstance(self.tree[i], int):
                return 1 if self.tree[i] > k else 0
            return len(self.tree[i]) - bisect.bisect_right(self.tree[i], k)
        mid = (start + end) // 2
        left_seg = self.search(start, mid, left, right, k, i * 2)
        right_seg = self.search(mid + 1, end, left, right, k, i * 2 + 1)
        if left_seg is None:
            return right_seg
        if right_seg is None:
            return left_seg
        return left_seg + right_seg


def merge(a: list[int], b: list[int]):
    i = j = 0
    # lst = []
    # while i < len(a) and j < len(b):
    #     if a[i] < b[j]:
    #         lst.append(a[i])
    #         i += 1
    #     else:
    #         lst.append(b[j])
    #         j += 1
    # while i < len(a):
    #     lst.append(a[i])
    #     i += 1
    # while j < len(b):
    #     lst.append(b[j])
    #     j += 1
    lst = a + b
    lst.sort()
    return lst


def combine(a, b):
    if a is None:
        return b
    if b is None:
        return a
    if isinstance(a, int):
        a = [a]
    if isinstance(b, int):
        b = [b]
    return merge(a, b)


# sys.stdin = open('tools/testcase.txt', 'r')
n = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().split()))
m = int(sys.stdin.readline())

seg = ArraySegmentTree(arr, None, combine)
for _ in range(m):
    i, j, k = map(int, sys.stdin.readline().split())
    print(seg.search(0, n - 1, i - 1, j - 1, k))