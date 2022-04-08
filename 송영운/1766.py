class Node:
    def __init__(self, data):
        self.data = data
        self.next = None
class linked_list:
    def __init__(self):
        self.head = None

    def append(self, n):
        if self.head == None:
            self.head = Node(n)
        else:
            temp = self.head
            while temp.next is not None:
                temp = temp.next
            temp.next = Node(n)

    def insert(self, i, n):
        node = Node(n)
        if i == 0:
            node.next = self.head
            self.head = node
        else:
            temp = self.head
            for i in range(i-1):
                temp = temp.next
            Node.next = self.head.next
            self.head.next = node

    def insert_of_num(self, find_n, insert_n):
        node = Node(insert_n)
        temp = self.head
        if temp.data == find_n:
            node.next = self.head
            self.head = node
        else:
            while temp.next is not None:
                if temp.next.data == find_n:
                    node.next = temp.next
                    temp.next = node
                    return
                else:
                    temp = temp.next
    def remove(self, n):
        temp = self.head
        if temp.data == n:
            self.head = temp.next
            del temp
            return

        while temp.next is not None:
            if temp.next.data == n:
                temp.next = temp.next.next
                return
            else:
                temp = temp.next

    def index(self, i):
        temp = self.head
        for i in range(i):
            temp = temp.next
        return temp

input = __import__('sys').stdin.readline
if __name__ == "__main__":
    n, m = map(int, input().split())
    problem = [i for i in range(1, n+1)]
    solve_sequence = []
    for _ in range(m):
        a, b = map(int, input().split())
        solve_sequence.append((a, b))
    solve_sequence.sort(key=lambda x:(x[0], -x[1]))
    ll = linked_list()
    for i in range(n):
        ll.append(i+1)
    for ss in solve_sequence:
        a, b = ss[0], ss[1]
        ll.remove(a)
        ll.insert_of_num(b, a)
    for i in range(n):
        print(ll.index(i).data, end=' ')