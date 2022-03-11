def find(n):
    while n != root_node[n]:
        n = root_node[n]
    return n

from queue import PriorityQueue
input = __import__('sys').stdin.readline
if __name__ == "__main__":
    v, e = map(int, input().split())
    root_node = [i for i in range(v+1)]

    pq = PriorityQueue()
    min_price = 0
    for _ in range(e):
        a, b, c = map(int, input().split())
        pq.put((c, a, b))

    while not pq.empty():
        c, a, b = pq.get()
        root_a = find(a)
        root_b = find(b)
        if root_a != root_b:
            min_price += c
            if root_a > root_b:
                root_node[root_a] = root_b
            else:
                root_node[root_b] = root_a
    print(min_price)