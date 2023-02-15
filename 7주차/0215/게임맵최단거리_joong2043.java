import java.util.*;
class Solution {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] visit;
    static int min = Integer.MAX_VALUE;
    static int answer = -1;

    class Point{
        int x;
        int y;
        int count;

        Point(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public int solution(int[][] maps) {
        // int answer = 0;
        visit = new boolean[maps.length][maps[0].length];

        bfs(maps);
        if(min == Integer.MAX_VALUE){
            return -1;
        }
        else{
            return min;
        }
    }


    public void bfs(int[][] maps){
        Point point = new Point(0,0,1);

        Queue<Point> queue = new LinkedList<>();

        queue.add(point);
        visit[0][0] = true;

        while(!queue.isEmpty()){
            Point curPoint = queue.poll();

            if(curPoint.x == maps.length-1& curPoint.y == maps[0].length-1){
                if(min > curPoint.count){
                    min = curPoint.count;
                }
            }

            for(int i =0; i<4; i++){
                int nx = dx[i] + curPoint.x;
                int ny = dy[i] + curPoint.y;

                if(nx<0 || ny<0 || nx>=maps.length || ny>=maps[0].length){
                    continue;
                }

                if(visit[nx][ny] == false && maps[nx][ny]==1){
                    queue.add(new Point(nx,ny,curPoint.count+1));
                    visit[nx][ny] = true;

                    // System.out.println("nx,ny : "+nx+","+ny+","+curPoint.count);

                }
            }
        }

    }
}