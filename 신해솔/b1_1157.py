input_str = input()
upper_str = input_str.upper()
max_frequency = 0
result = 0
accomplished_char = []

for i in upper_str:
    if i not in accomplished_char:
        frequency = upper_str.count(i)
        accomplished_char.append(i)

        if frequency > max_frequency:
            max_frequency = frequency
            result = i
        elif frequency == max_frequency:
            result = '?'

print(result)
