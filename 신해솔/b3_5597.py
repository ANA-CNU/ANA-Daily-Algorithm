import sys

members = list(range(1, 31))
numbers = [int(sys.stdin.readline()) for _ in range(28)]
absence = [i for i in members if i not in numbers]
print(absence[0])
print(absence[1])
