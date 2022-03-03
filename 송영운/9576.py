input = __import__('sys').stdin.readline
if __name__ == "__main__":
    t = int(input())
    for _ in range(t):
        n, m = map(int, input().split())
        student = []
        for i in range(m):
            a, b = map(int, input().split())
            student.append((a, b))
        student.sort(key=lambda x:(x[1], x[0]))
        receive_count = 0
        for i in range(1, n + 1):
            z = len(student)
            for j in range(0, z):
                if student[j][0] <= i <= student[j][1]:
                    receive_count += 1
                    student.pop(j)
                    break
        print(receive_count)