# 2007년 - 1924

extra_day = (3, 0, 3, 2, 3, 2, 3, 3, 2, 3, 2, 3)
day = ["MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"]
x, y = map(int, input().split())
days = sum(extra_day[:x-1]) + (y-1)
print(day[days % 7])
