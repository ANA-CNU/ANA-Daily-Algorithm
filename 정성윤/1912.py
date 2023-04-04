n = int(input()) # n 입력 받기
nums = list(map(int,input().split())) # list 안에 값 넣기
sum = [nums[0]] # 첫번쨰 인덱스 넣기
for i in range(len(nums)-1): # for문 돌기 첫번째 인덱스 넣었으니까 -1
    sum.append(max(sum[i] + nums[i + 1], nums[i + 1])) # 이전꺼 합과 현재 값 비교후 max 함루를 통해 큰걸 sum에 append
print(max(sum)) #sum에서 제일 큰 값 print