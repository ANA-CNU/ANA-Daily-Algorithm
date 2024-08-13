import sys
from collections import deque


class Node:
    def __init__(self, key):
        self.key = key
        self.children = {}
        self.is_end = False


root = Node('')
nicknames = set()
c, n = map(int, sys.stdin.readline().split())
for _ in range(c):
    color = sys.stdin.readline().strip()
    cur = root
    for ch in color:
        if ch not in cur.children:
            cur.children[ch] = Node(ch)
        cur = cur.children[ch]
    cur.is_end = True

for _ in range(n):
    nicknames.add(sys.stdin.readline().strip())

for _ in range(int(sys.stdin.readline())):
    s = sys.stdin.readline().strip()
    cur = root
    res = False
    for i, ch in enumerate(s):
        if cur.is_end and s[i:] in nicknames:
            res = True
            break
        if ch not in cur.children:
            break
        cur = cur.children[ch]
    print('Yes' if res else 'No')