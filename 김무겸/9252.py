String_A = " " + input()
String_B = " " + input()
la, lb = len(String_A), len(String_B)
LCS = [[0] * la for _ in range(lb)]
LCS_name = [[""] * la for _ in range(lb)]

for i in range(1, lb):
    for j in range(1, la):
        if String_A[j] == String_B[i]:
            LCS[i][j] = LCS[i-1][j-1] + 1
            LCS_name[i][j] = LCS_name[i-1][j-1] + String_A[j]

        else:
            LCS[i][j] = max(LCS[i-1][j], LCS[i][j-1])
            LCS_name[i][j] = LCS_name[i-1][j] if LCS[i-1][j] > LCS[i][j-1] else LCS_name[i][j-1]

print(LCS[lb-1][la-1])
print(LCS_name[lb-1][la-1])