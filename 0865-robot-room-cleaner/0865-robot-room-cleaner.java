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
    public void cleanRoom(Robot robot) {
        visited = new HashSet<>();
        visited.add(Arrays.asList(0,0));
        explore(robot, 0, 0, new int[]{1, 0});
    }

    public void explore(Robot robot, int row, int col, int[] dir){
        robot.clean();
        for(int i = 0; i < 4; i++){
            if(!visited.contains(Arrays.asList(row + dir[0], col + dir[1]))){
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                visited.add(Arrays.asList(newRow, newCol));
                boolean canMove = robot.move();
                if (canMove){
                    explore(robot, newRow, newCol, dir);
                    turnArround(robot, dir);
                    robot.move();
                    turnArround(robot, dir);
                }
            }
            turnRight(robot, dir);
        }
    }

    public void turnRight(Robot robot, int[] dir){
        if(dir[0] == 0){
            dir[0] = dir[1];
            dir[1] = 0;
        }else{
            dir[1] = -1 * dir[0];
            dir[0] = 0;
        }
        robot.turnRight();
    }
    public void turnArround(Robot robot, int[] dir){
        dir[0] = -1*dir[0];
        dir[1] = -1*dir[1];
        robot.turnRight();
        robot.turnRight();
    }
}
