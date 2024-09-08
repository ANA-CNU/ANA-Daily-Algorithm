import functools
import sys


class AhoCorasick:
    class Node:
        def __init__(self, key):
            self.key = key
            self.children = {}
            self.fail = None
            self.is_end = False

        def __repr__(self):
            return f'{self.key}: {len(self.children)}, {self.is_end}'

    def __init__(self, keywords):
        self.root = self.Node('')
        self.root.fail = self.root
        for kw in keywords:
            self.insert(kw)
        self.build_fail()

    def insert(self, s):
        cur = self.root
        for ch in s:
            if ch not in cur.children:
                cur.children[ch] = self.Node(ch)
            cur = cur.children[ch]
        cur.is_end = True

    def build_fail(self):
        from collections import deque
        q = deque([self.root])
        while q:
            cur = q.popleft()
            for ch, nxt in cur.children.items():
                if cur == self.root:
                    nxt.fail = self.root
                else:
                    dest = cur.fail
                    while dest != self.root and ch not in dest.children:
                        dest = dest.fail
                    if ch in dest.children:
                        dest = dest.children[ch]
                    nxt.fail = dest
                if nxt.fail.is_end: nxt.is_end = True
                q.append(nxt)

    def find(self, s):
        cur = self.root
        for i, ch in enumerate(s):
            while cur != self.root and ch not in cur.children:
                cur = cur.fail
            if ch in cur.children:
                cur = cur.children[ch]
            if cur.is_end: yield i, cur

    def contains(self, s):
        return any(self.find(s))

    def count(self, s, return_idx=False):
        if return_idx:
            return list(self.find(s))
        else:
            return functools.reduce(lambda x, y: x + 1, self.find(s), 0)


for _ in range(int(sys.stdin.readline())):
    n, m = map(int, sys.stdin.readline().split())
    dna = sys.stdin.readline().strip()
    base_marker = sys.stdin.readline().strip()
    markers = {base_marker}
    for i in range(m - 1):
        l = base_marker[:i]
        for j in range(m, i + 1, -1):
            r = base_marker[j:]
            reversed_m = base_marker[i:j][::-1]
            markers.add(l + reversed_m + r)

    ac = AhoCorasick(markers)
    print(ac.count(dna))

