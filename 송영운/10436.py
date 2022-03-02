input = __import__('sys').stdin.readline
def checkleft(p, q):
    if p - q <= 0:
        return False
    else:
        return True
def checkright(p, q):
    if q - p <= 0:
        return False
    else:
        return True

def upleft(p, q):
    upcount = p//q
    p = p%q
    return p, q, upcount
def downleft(p, q):
    q += p
    return p, q
def upright(p, q):
    q -= p
    return p, q
def downright(p, q):
    p += q
    return p, q

if __name__ == "__main__":
    t = int(input())
    for _ in range(t):
        t_n, p_q = input().split()
        p, q = map(int, p_q.split('/'))
        if p < q:
            p, q = upright(p, q)
            p, q = downright(p, q)
        elif p > q:
            if q == 1:
                q += p
                p = 1
            else:
                p, q, upcount = upleft(p, q)
                p, q = upright(p, q)
                p, q = downright(p, q)
                q += p*upcount
        else:
            q = 2

        print(t_n, f"{p}/{q}")

