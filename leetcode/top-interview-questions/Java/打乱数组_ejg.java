import java.util.Random;
class Solution {

    private int[] original;
    private int[] array;
    private Random rand;
    private int N;

    private int randomInd(int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    public Solution(int[] nums) {
        original = nums.clone();
        array = nums;
        rand = new Random();
        N = nums.length;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        array = original.clone();
        return array;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle1() {
        for (int i = 0; i < N; i++) {
            int ind = randomInd(i, N);
            int temp = array[i];
            array[i] = array[ind];
            array[ind] = temp;
        }
        return array;
    }

    public int[] shuffle() {
        List<Integer> temp = Arrays.stream(original).boxed().collect(Collectors.toList());
        for (int i = 0; i < N; i++) {
            int ind = rand.nextInt(temp.size());
            array[i] = temp.get(ind);
            temp.remove(ind);
        }
        return array;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */