class Node:
    def __init__(self, item):
        self.item = item

    def set_child(self, left, right):
        self.left = left
        self.right = right
    def __str__(self):
        return self.item
    def left(self):
        return self.left
    def right(self):
        return self.right

N = int(input())
root = 0
node = [Node(chr(i)) for i in range(ord('A'), ord('A')+N)]

for i in range(N):
    item, left, right = input().split()
    if item == 'A':
        root = i
    
    item = ord(item)-ord('A')
    if left != '.': left = node[ord(left)-ord('A')]
    else: left = None
    if right != '.': right = node[ord(right)-ord('A')]
    else: right = None
    node[item].set_child(left, right)


def order1(n):
    print (n, end='')
    if n.left != None:
        order1(n.left)
    if n.right != None:
        order1(n.right)

def order2(n):
    if n.left != None:
        order2(n.left)
    print (n, end='')
    if n.right != None:
        order2(n.right)

def order3(n):
    if n.left != None:
        order3(n.left)
    if n.right != None:
        order3(n.right)
    print (n, end='')

order1(node[root])
print()
order2(node[root])
print()
order3(node[root])