N = int(input())
answer = 0
enter= dict()
out = []
for i in range(N):
	car = input()
	enter[car] = i
for _ in range(N):
	car = input()
	out.append(car)
 
for i in range(N-1):
	for j in range(i+1, N):
		if enter[out[i]] > enter[out[j]]:
			answer += 1
			break
print(answer)