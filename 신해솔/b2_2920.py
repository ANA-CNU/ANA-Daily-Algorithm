input_note = list(map(int, input().split()))
ascending = [i for i in range(1, 9)]
descending = [i for i in range(8, 0, -1)]

if input_note == ascending:
    print("ascending")
elif input_note == descending:
    print("descending")
else:
    print("mixed")
