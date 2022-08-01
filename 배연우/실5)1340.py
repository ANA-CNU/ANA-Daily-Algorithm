date = input().split(" ")
total_minute = 0
passed_minute = 0

day_per_month = {
    "January": 31,
    "February": 28,
    "March": 31,
    "April": 30,
    "May": 31,
    "June": 30,
    "July": 31,
    "August": 31,
    "September": 30,
    "October": 31,
    "November": 30,
    "December": 31,
}

day_per_month_leap = {
    "January": 31,
    "February": 29,
    "March": 31,
    "April": 30,
    "May": 31,
    "June": 30,
    "July": 31,
    "August": 31,
    "September": 30,
    "October": 31,
    "November": 30,
    "December": 31,
}


def is_leap_year(tar: int):
    if tar % 400 == 0:
        return True
    if tar % 4 == 0 and tar % 100 > 0:
        return True
    return False


def day_to_minute(tar: int):
    return tar * 60 * 24


if is_leap_year(int(date[2])):
    total_minute = day_to_minute(366)
    for key, value in day_per_month_leap.items():
        if key == date[0]:
            break
        passed_minute += day_to_minute(value)
else:
    total_minute = day_to_minute(365)
    for key, value in day_per_month.items():
        if key == date[0]:
            break
        passed_minute += day_to_minute(value)

passed_minute += day_to_minute(int(date[1][:-1])-1)
passed_minute += int(date[3][:2]) * 60
passed_minute += int(date[3][3:])

print(passed_minute / total_minute * 100)
