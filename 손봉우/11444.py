def multiply(m1, m2):
    result = [0, 0, 0, 0]
    result[0] = (m1[0]*m2[0] + m1[1]*m2[2]) % 1000000007
    result[1] = (m1[0]*m2[1] + m1[1]*m2[3]) % 1000000007
    result[2] = (m1[2]*m2[0] + m1[3]*m2[2]) % 1000000007
    result[3] = (m1[2]*m2[1] + m1[3]*m2[3]) % 1000000007
    return result

def power(m, n):
    if (n > 1):
        m = power (m, n//2)

        m = multiply (m, m)
        if n % 2 == 1:
            m = multiply(m, [1,1,1,0])
    return m

N = int(input())

mat = power ([1,1,1,0], N)
print (mat[1]%1000000007)