import sys

sys.setrecursionlimit(10**6)
class Node:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

class BinaryTree:
    def __init__(self, root):
        self.root = root
    
    def insert(self, value):
        cur_node = self.root
        while True:
            if value < cur_node.value:
                if cur_node.left != None:
                    cur_node =  cur_node.left
                else:
                    cur_node.left = Node(value)
                    break
            else
                if cur_node.right != None:
                    cur_node = cur_node.right
                else:
                    cur_node.right = Node(value)
                    break
    
    def traverse(self, node):
        if node.left != None:
            self.traverse(node.left)
        if node.right != None:
            self.traverse(node.right)
        print (node.value)
try:
    tree = BinaryTree(Node(int(input())))
except:
    exit()

while True:
    try:    
        tree.insert(int(input()))
    except:
        break

tree.traverse(tree.root)
