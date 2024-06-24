import math
import sys


class SegTree:
    def __init__(self, arr):
        self.arr = arr
        self.n = len(arr)
        self.tree = [0] * pow(2, math.ceil(math.log(self.n, 2) + 1))
        self.loc = [0] * self.n
        self.init_seg(0, self.n - 1)

    def init_seg(self, s, e, i=1):
        if s == e:
            self.loc[s] = i
            self.tree[i] = 1 if self.arr[s] > 0 else (-1 if self.arr[s] < 0 else 0)
            # self.tree[i] = self.arr[s]
            return self.tree[i]
        m = (s + e) >> 1
        self.tree[i] = self.init_seg(s, m, i << 1) * self.init_seg(m + 1, e, i << 1 | 1)
        return self.tree[i]

    def search(self, s, e, l, r, i=1):
        if e < l or s > r:
            return 1
        if l <= s and e <= r:
            return self.tree[i]
        m = (s + e) >> 1
        return self.search(s, m, l, r, i << 1) * self.search(m + 1, e, l, r, i << 1 | 1)

    def update(self, i, x):
        idx = self.loc[i]
        x = 1 if x > 0 else (-1 if x < 0 else 0)
        self.tree[idx] = x
        while idx > 1:
            idx //= 2
            self.tree[idx] = self.tree[idx << 1] * self.tree[idx << 1 | 1]


while True:
    try:
        n, k = map(int, sys.stdin.readline().split())
        a = list(map(int, sys.stdin.readline().split()))
        seg = SegTree(a)
        for i in range(k):
            inst, *args = sys.stdin.readline().split()
            args = tuple(map(int, args))
            if inst == 'C':
                seg.update(args[0] - 1, args[1])
            elif inst == 'P':
                res = seg.search(0, n - 1, args[0] - 1, args[1] - 1)
                print('+' if res > 0 else ('-' if res < 0 else '0'), end='')
        print()
    except:
        break