import sys


class Person:
    def __init__(self, name, day, month, year):
        self.name = name
        self.day = day
        self.month = month
        self.year = year


people = []
N = int(sys.stdin.readline())

for _ in range(N):
    name, day, month, year = tuple(sys.stdin.readline().split())
    people.append(Person(name, int(day), int(month), int(year)))

people.sort(key=lambda x: (x.year, x.month, x.day))

print(people[-1].name)
print(people[0].name)
