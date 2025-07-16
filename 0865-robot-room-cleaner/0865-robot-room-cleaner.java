/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

class Solution {
    Set<List<Integer>> visited; 
    int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public void cleanRoom(Robot robot) {
        visited = new HashSet<>();
        explore(robot, 0, 0, 0);
    }

    public void explore(Robot robot, int row, int col, int dir){
        visited.add(Arrays.asList(row,col));
        robot.clean();
        for(int i = 0; i < 4; i++){
            int newDir = (dir+i)%4;
            int newRow = row + direction[newDir][0];
            int newCol = col + direction[newDir][1];
            if(!visited.contains(Arrays.asList(newRow, newCol))&& robot.move()){
                explore(robot, newRow, newCol, newDir);
                moveBack(robot);
            }
            robot.turnRight();
        }
    }

    public void moveBack(Robot robot){
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
}
