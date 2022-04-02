import sys

n = int(sys.stdin.readline())
users = []
for _ in range(n):
    user, prov = sys.stdin.readline().strip().split("@")
    user = user.replace(".", "")
    if "+" in user:
        user = user[:user.index("+")]
    if (user, prov) not in users:
        users.append((user, prov))
print(len(users))