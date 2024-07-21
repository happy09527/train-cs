package leetcode.eveyday;

/**
 * @author: ZhangX
 * @createDate: 2024/7/21
 * @description:
 */
public class MinLevel {
    public static void main(String[] args) {
        new MinLevel().minimumLevels(new int[]{1,0,1,0});
    }
    public int minimumLevels(int[] possible) {
        int sum =0, alice = 0;
        if(possible[0]==0){
            alice -= possible[0];
        }else{
            alice += possible[0];
        }
        for(int i=1;i<possible.length;i++) {
            if(possible[i]==0) {
                sum--;
            }else{
                sum++;
            }
        }
        if(alice > sum) {
            return 1;
        }
        for(int i=1; i<possible.length-1;i++) {
            if(possible[i]==0) {
                alice--;
                sum--;
            }else{
                alice++;
                sum--;
            }

            if(alice>sum) {
                return i+1;
            }
        }
        return -1;
    }
}
