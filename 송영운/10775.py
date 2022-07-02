def find(n):
    if gate_root[n] == n:
        return n
    gate_root[n] = find(gate_root[n])
    return gate_root[n]

input = __import__('sys').stdin.readline
if __name__ == "__main__":
    g = int(input())
    p = int(input())
    gate_root = [i for i in range(g+1)]
    gi = [int(input()) for _ in range(p)]

    answer = 0
    for i in gi:
        root = find(i)
        if root == 0:
            break
        answer+=1
        gate_root[root] = gate_root[root-1]
    print(answer)

