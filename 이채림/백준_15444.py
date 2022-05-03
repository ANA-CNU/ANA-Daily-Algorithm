import sys

if __name__ == '__main__':
    N = int(sys.stdin.readline().rstrip())
    S = sys.stdin.readline().rstrip()

    A = ["***", "*.*", "***", "*.*", "*.*"]
    B = ["***", "*.*","***", "*.*", "***"]
    C = ["***", "*..","*..", "*..", "***"]
    D = ["***", "*.*","*.*", "*.*", "***"]
    E = ["***", "*..","***", "*..", "***"]

    for i in range(5):
        for j in S:
            if j=="A":
                print(A[i],end="")
            elif j == "B":
                print(B[i],end="")
            elif j == "C":
                print(C[i],end="")
            elif j == "D":
                print(D[i],end="")
            elif j == "E":
                print(E[i],end="")
        print()