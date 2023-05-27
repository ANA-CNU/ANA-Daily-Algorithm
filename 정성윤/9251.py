word1, word2 = input().strip(), input().strip() # word1과 word2를 입력받는다.
h, w = len(word1), len(word2) # word1과 word2의 길이를 구한다.
cache = [[0] * (w+1) for _ in range(h+1)] # cache를 0으로 초기화한다.
for i in range(1, h+1): # word1의 길이만큼 반복한다.
    for j in range(1, w+1): # word2의 길이만큼 반복한다.
        if word1[i-1] == word2[j-1]: # word1과 word2의 문자가 같다면
            cache[i][j] = cache[i-1][j-1] + 1 # cache[i][j]에 cache[i-1][j-1] + 1을 저장한다.
        else: # word1과 word2의 문자가 다르다면
            cache[i][j] = max(cache[i][j-1], cache[i-1][j]) # cache[i][j]에 cache[i][j-1]과 cache[i-1][j] 중 큰 값을 저장한다.
print(cache[-1][-1]) # cache의 마지막 값을 출력한다.

