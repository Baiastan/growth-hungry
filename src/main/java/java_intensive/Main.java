package java_intensive;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {


        int[] nums = {1,2,3,4,5,6,10};

        int[] indices = twoSum(nums, 4);

        System.out.println("Indices: " + indices[0] + " : " +  indices[1]);

    }

    public static int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> comp = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int compliment = target - nums[i];

            if (comp.containsKey((compliment))) {
                return new int[] {comp.get(compliment), i};
            }

            comp.put(nums[i], i);
        }
        return new int []{};

    }
}
