import math
import sys


class Node:
    def __init__(self, lmx, rmx, mx, itv):
        self.lmx = lmx
        self.rmx = rmx
        self.mx = mx
        self.itv = itv

    def __repr__(self):
        return f'lmx{self.lmx}|rmx{self.rmx}|mx{self.mx}|itv{self.itv}'


class SegTree:
    def __init__(self, arr: list[int], merge_func):
        self.n = len(arr)
        self.init_arr = arr
        self.location = [0] * self.n
        self.merge = merge_func
        self.tree = [Node(0, 0, 0, 1) for _ in range(pow(2, math.ceil(math.log2(self.n) + 1)))]
        self._init_tree(0, self.n - 1)

    def _init_tree(self, s, e, i=1):
        if s == e:
            self.tree[i] = Node(1, 1, 1, 1) if self.init_arr[s] == 0 else Node(0, 0, 0, 1)
            self.location[s] = i
            return self.tree[i]
        m = s + e >> 1
        self.tree[i] = self.merge(self._init_tree(s, m, i << 1), self._init_tree(m + 1, e, i << 1 | 1))
        return self.tree[i]

    def search(self, s, e, l, r, i=1):
        if e < l or s > r: return Node(0, 0, 0, 1)
        if l <= s and e <= r: return self.tree[i]
        m = s + e >> 1
        return self.merge(self.search(s, m, l, r, i << 1), self.search(m + 1, e, l, r, i << 1 | 1))

    def update_from_leaf(self, loc, v):
        idx = self.location[loc]
        self.init_arr[loc] += v
        self.tree[idx] = Node(0, 0, 0, 1) if self.init_arr[loc] != 0 else Node(1, 1, 1, 1)
        while idx > 1:
            idx >>= 1
            self.tree[idx] = self.merge(self.tree[idx << 1], self.tree[idx << 1 | 1])


def merge(a, b):
    lmx = a.lmx if a.mx != a.itv else a.mx + b.lmx
    rmx = b.rmx if b.mx != b.itv else a.rmx + b.mx
    mx = max(a.mx, b.mx, a.rmx + b.lmx)
    itv = a.itv + b.itv
    return Node(lmx, rmx, mx, itv)


n = int(sys.stdin.readline()) + 2
a = [0] + list(map(int, sys.stdin.readline().split())) + [0]
# 초기 배열 처리
b = [0] * n
for i in range(n - 1): b[i] = a[i + 1] - a[i]
c = [0] * n
c[0] = a[1]
for i in range(1, n): c[i] = b[i] - b[i - 1]
# print(b)
# print(c)
# [0, 1, 1, 0, -4, -1, 3]
# [1, 1, 0, -4, -1, 3, 0]
# [1, 1, 0, -4, -1, 3, 0]

tree = SegTree(c, merge)

for _ in range(int(sys.stdin.readline())):
    op, *args = map(int, sys.stdin.readline().split())
    i, j = args[0], args[1]
    if op == 1:
        x, y = args[2], args[3]
        tree.update_from_leaf(i - 1, x)
        tree.update_from_leaf(i, y - x)
        tree.update_from_leaf(j, -x - (j - i + 1) * y)
        tree.update_from_leaf(j + 1, x + (j - i) * y)
        print(tree.init_arr)
    elif j - i < 2:
        print(j - i + 1)
    else:
        node = tree.search(0, n - 1, i + 1, j - 1)
        print(max(node.lmx, node.rmx, node.mx) + 2)