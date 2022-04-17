def find(n):
    while n != root_node[n]:
        n = root_node[n]
    return n

from heapq import heappush, heappop
input = __import__('sys').stdin.readline
if __name__ == "__main__":
    n = int(input())
    m = int(input())
    node = []
    root_node = [i for i in range(n+1)]
    for i in range(m):
        u, v, c = map(int, input().split())
        heappush(node, (c, u, v))

    ans = 0
    while node:
        c, u, v = heappop(node)
        u_root = find(u)
        v_root = find(v)
        if u_root < v_root:
            root_node[v_root] = u_root
            ans += c
        elif u_root > v_root:
            root_node[u_root] = v_root
            ans += c
    print(ans)