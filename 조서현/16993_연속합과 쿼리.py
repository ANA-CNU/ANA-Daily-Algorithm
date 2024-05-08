import math
import sys


class ArraySegmentTree:
    def __init__(self, init_arr, cmp_func, init_val):
        n = len(init_arr)
        self.n = n
        self.init_arr = init_arr
        self.init_val = init_val
        self.tree = [init_val for _ in range(pow(2, math.ceil(math.log(n, 2) + 1)))]
        self.location = [0] * n
        self.cmp_func = cmp_func
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
        self.tree[i] = self.cmp_func(self.make_segment_tree(left, mid, i * 2), self.make_segment_tree(mid + 1, right, i * 2 + 1))
        return self.tree[i]

    def search(self, start, end, left, right, i=1):
        # 범위를 벗어나면 기본값 리턴
        if end < left or start > right:
            return self.init_val
        # 찾는 범위 왼쪽이 구간 왼쪽보다 작거나 같고,
        # 찾는 범위 오른쪽이 구간 오른쪽보다 크거나 같으면 구간값 리턴
        if left <= start and end <= right:
            return self.tree[i]
        mid = (start + end) // 2
        return self.cmp_func(self.search(start, mid, left, right, i * 2), self.search(mid + 1, end, left, right, i * 2 + 1))


class Node:
    def __init__(self, l_val, r_val, mid_val, p_sum):
        self.l_val = l_val
        self.r_val = r_val
        self.mid_val = mid_val
        self.p_sum = p_sum

    def __str__(self):
        return f'l_val: {self.l_val}, r_val: {self.r_val}, mid_val: {self.mid_val}, p_sum: {self.p_sum}'


def combine(n1: Node, n2: Node):
    l_val = max(n1.l_val, n1.p_sum + n2.l_val)
    r_val = max(n2.r_val, n1.r_val + n2.p_sum)
    mid_val = max(max(n1.mid_val, n2.mid_val), n1.r_val + n2.l_val)
    p_sum = n1.p_sum + n2.p_sum
    return Node(l_val, r_val, mid_val, p_sum)


n = int(input())
arr = list(map(int, input().split()))
arr = list(map(lambda x: Node(x, x, x, x), arr))
MIN = -pow(10, 15)
seg = ArraySegmentTree(arr, combine, Node(MIN, MIN, MIN, MIN))

m = int(input())
for _ in range(m):
    i, j = map(int, sys.stdin.readline().split())
    res = seg.search(0, seg.n - 1, i - 1, j - 1)
    res = max(res.l_val, res.r_val, res.mid_val, res.p_sum)
    print(res)
# https://www.acmicpc.net/problem/16993