import java.util.HashSet;

/**
 * @author： chenr
 * @date： Created on 2020/7/5 22:04
 * @version： v1.0
 * @modified By:
 * 模拟行走机器人
 */
public class RobotSim {
    public static void main(String[] args) {
        int [] commands = {4,-1,4,-2,4};
        int [] []  obstacles = {{2,4}};
        int result = new RobotSim().robotSim(commands,obstacles);
        System.out.println(result);
    }
    public int robotSim(int[] commands, int[][] obstacles) {
        //direction表当前朝向，0123 表 北东南西
        int ans = 0,direction = 0,x = 0,y = 0;
        //每个朝向上的数据变化，比如朝北时取Direction[0]  ->   {0,1}
        //那么x轴的变化为x+0，y轴变化为y+1;
        int[][] Direction = {{0,1},{1,0},{0,-1},{-1,0}};

        HashSet<String> set = new HashSet<>();
        //将所有障碍物坐标组合成字符串存入set中方便查询
        for (int[] arr : obstacles) {
            set.add(arr[0] + "，" + arr[1]);
        }
        for (int com : commands) {
            //定义下一步的坐标
            int next_x = 0,next_y = 0;
            //当命令为前进，开始移动
            if (com >= 0 ){
                for(int i = 0; i < com; i++){
                    //取得下一步的坐标
                    next_x = x + Direction[direction][0];
                    next_y = y + Direction[direction][1];
                    //若下一步有障碍物，结束当前命令，跳至下一命令
                    if(set.contains(next_x+"，"+next_y)) {
                        break;
                    }
                    //否则更新坐标与最远距离
                    x = next_x;
                    y = next_y;
                    ans = Math.max(ans, x*x + y*y);
                }
            }else{
                //改变朝向
                direction = com == -1 ? (direction + 1) % 4 : (direction + 3) % 4;
            }
        }
        return ans;
    }


}
