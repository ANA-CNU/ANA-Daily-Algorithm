def find(n):
    idx = n
    node = root_node[n]
    while node != idx:
        idx = node
        node = root_node[idx]
    return node
input = __import__('sys').stdin.readline
if __name__ == "__main__":
    n, m = map(int, input().split())
    root_node = [i for i in range(n+1)]

    for _ in range(m):
        o, a, b = map(int, input().split())
        a_root = find(a)
        b_root = find(b)
        if o == 0:
            if a_root != b_root:
                if a_root > b_root:
                    root_node[b_root] = a_root
                else:
                    root_node[a_root] = b_root
        else:
            if a_root == b_root:
                print('YES')
            else:
                print('NO')