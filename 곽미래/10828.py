import sys


class Stack:
    arr = []
    idx = 0

    def push(self, x):
        if len(self.arr) <= self.idx:
            self.arr.append(x)
        else:
            self.arr[self.idx] = x
        self.idx += 1
        return True

    def pop(self):
        if self.empty():
            return -1
        self.idx -= 1
        return self.arr[self.idx]

    def size(self):
        return self.idx

    def empty(self):
        if self.size() == 0:
            return 1
        else:
            return 0

    def top(self):
        if self.empty():
            return -1
        else:
            return self.arr[self.idx-1]


if __name__ == '__main__':
    n = int(sys.stdin.readline())
    s = Stack()
    for i in range(n):
        order = list(sys.stdin.readline().rstrip().split())
        if order[0] == 'push':
            s.push(int(order[1]))
        elif order[0] == 'pop':
            print(s.pop())
        elif order[0] == 'size':
            print(s.size())
        elif order[0] == 'empty':
            print(s.empty())
        elif order[0] == 'top':
            print(s.top())