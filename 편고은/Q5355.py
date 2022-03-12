test_case = int(input())

for i in range(test_case):
    calc = list(input().split())

    for j in calc:

        try:
            calc_float = float(j)

        except:
            if j == "@":
                calc_float *= 3
            elif j == "%":
                calc_float += 5
            elif j == "#":
                calc_float -= 7



    print("{:.2f}".format(calc_float))
