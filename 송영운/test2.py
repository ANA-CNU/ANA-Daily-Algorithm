def solution(queue1, queue2):
    answer = -1
    mid_idx = len(queue1)
    q = queue1 + queue2
    for i in range(len(q)):
        left = sum(q[0:mid_idx])
        right = sum(q[mid_idx:len(q)])
        if left == right:
            answer = i
            break
        elif left > right:
            q.append(q.pop(0))
            mid_idx -= 1
        else:
            mid_idx += 1

    return answer

print(solution([3,2,7,2], [4,6,5,1]))