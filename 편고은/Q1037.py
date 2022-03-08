num_of_divisor = int(input())
divisors = input()

list_of_divisors = [int(i) for i in divisors.split()]

if len(list_of_divisors) == 1:
    print(list_of_divisors[0] ** 2)
else:
    list_of_divisors.sort()
    print(list_of_divisors[0] * list_of_divisors[-1])
