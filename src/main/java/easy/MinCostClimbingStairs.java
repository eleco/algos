package easy;

public class MinCostClimbingStairs {

    public static void main(String[] args) {
        System.out.println( minCostClimbingStairs(new int[]{10,15,20}));
    }
    static int[]mem= new int[1001];

    static int minCostClimbingStairs(int[] cost) {

        if (cost==null) return 0;
        if (cost.length==1) return cost[0];
        mem = new int[1001];

        return Math.min(dfs(cost,0), dfs(cost,1));
    }

    static int dfs(int [] cost, int idx) {

        if (idx>cost.length-1) return 0;

        if (mem[idx]!=0){
            return mem[idx];
        }

        int t1= cost[idx]+dfs(cost, idx+1);
        int t2= cost[idx] + dfs(cost, idx+2);
        int v=  Math.min(t1,t2);

        mem[idx]=v;
        return v;

    }
}
