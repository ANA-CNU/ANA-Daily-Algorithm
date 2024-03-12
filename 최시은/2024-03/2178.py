from collections import deque

def main():
    n, m = map(int, input().split())
        
    maze = []
    for _ in range(n):
        input_line = list(input())
        int_line = list(map(int, input_line))
        maze.append(int_line)
        
    print(bfs(maze, 0, 0, n, m))
    

def bfs(maze, y, x, n, m):
    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]
    
    queue = deque()   
    queue.append((y, x))
    
    while queue:
        node = queue.popleft()
        c_y, c_x = node
        
        for i in range(4):
            n_x = c_x + dx[i]
            n_y = c_y + dy[i]
        
            if n_x != -1 and n_x != m and n_y != -1 and n_y != n:
                if maze[n_y][n_x] == 1:
                    queue.append((n_y, n_x))
                    maze[n_y][n_x] = maze[c_y][c_x] + 1
                    
    return maze[n-1][m-1]



if __name__ == '__main__':
    main()