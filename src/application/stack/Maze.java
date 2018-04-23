package application.stack;

import stack.LinkStack;
import stack.Stack;

// 迷宫路线问题
public class Maze {
    // 迷宫的分布. '#'代表墙壁, ' '代表通路.
    private final char[][] maze = {
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', ' ', ' ', '#', ' ', ' ', ' ', '#', ' ', '#'},
            {'#', ' ', ' ', '#', ' ', ' ', ' ', '#', ' ', '#'},
            {'#', ' ', ' ', ' ', ' ', '#', '#', ' ', ' ', '#'},
            {'#', ' ', '#', '#', '#', ' ', ' ', ' ', ' ', '#'},
            {'#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#'},
            {'#', ' ', '#', ' ', ' ', ' ', '#', ' ', ' ', '#'},
            {'#', ' ', '#', '#', '#', ' ', '#', '#', ' ', '#'},
            {'#', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}
    };
    private final int maxRow = 10, maxColumn = 10;
    private static class Position{
        int x;
        int y;
        Position(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    private boolean canMove(int x, int y){
        if(x < 0 || x >= maxRow || y < 0 || y >= maxColumn)
            return false;
        if(maze[x][y] == '#')
            return false;
        // '*'代表该通道已经走过, 不能重复
        if(maze[x][y] == '*')
            return false;
        return true;
    }
    // 打印路径
    private void printPath(){
        System.out.println("步数： " + S.length());
        System.out.print(" ");
        for(int i = 0; i < maxColumn; i++)
            System.out.print(i);
        System.out.println();
        for(int i = 0; i < maxRow; i++){
            for(int j = 0; j < maxColumn; j++){
                if(j == 0)
                    System.out.print(i);
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
        System.out.println("--------------------");
    }
    Stack<Position> S = new LinkStack<>();
    int[][] moves = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public void mazePath(Position start, Position end){
        S.push(start);
        maze[start.x][start.y] = '*';
        if(start.x == end.x && start.y == end.y) {
            printPath();
            return;
        }
        for(int i = 0; i < 4; i++){
            int dx = moves[i][0] + start.x;
            int dy = moves[i][1] + start.y;
            if(canMove(dx, dy)){
                Position newStart = new Position(dx, dy);
                mazePath(newStart, end);
                maze[dx][dy] = ' ';
                S.pop();
            }
        }
    }

    public static void main(String[] args) {
        Position start = new Position(1, 1);
        Position end = new Position(8, 8);
        new Maze().mazePath(start, end);
    }
}
