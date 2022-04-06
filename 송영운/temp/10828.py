class stack:
    def __init__(self):
        self.s = list()
        self.len = 0
    def push(self, num):
        self.len += 1
        self.s.append(num)

    def pop(self):
        if self.len > 0:
            self.len -= 1
            return self.s.pop()
        else:
            return -1
    def top(self):
        if self.len > 0:
            return self.s[-1]
        else:
            return -1
    def size(self):
        return self.len
    def empty(self):
        if self.len == 0:
            return 1
        else:
            return 0

input = __import__('sys').stdin.readline
if __name__ == '__main__':
    n = int(input())
    s = stack()
    for _ in range(n):
        line = list(input().split())
        if len(line) == 1:
            instruction = line[0]
        else:
            instruction, num = line[0], line[1]
        if instruction == 'push':
            s.push(num)
        elif instruction == 'pop':
            print(s.pop())
        elif instruction == 'top':
            print(s.top())
        elif instruction == 'size':
            print(s.size())
        elif instruction == 'empty':
            print(s.empty())


