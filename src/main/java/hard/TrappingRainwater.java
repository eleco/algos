package hard;

public class TrappingRainwater {

    public static void main(String[] args) {

        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    public static int trap(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int maxLeft = 0;
        int maxRight = 0;
        int total = 0;
        while (left <= right) {

            if (maxLeft < maxRight) {
                if (height[left] > maxLeft) {
                    maxLeft = height[left];
                } else {
                    total += maxLeft - height[left];
                }
                left++;
            } else {
                if (height[right] > maxRight) {
                    maxRight = height[right];
                } else {
                    total += maxRight - height[right];
                    right--;
                }

            }
        }
        return total;
    }
}


