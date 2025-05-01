package array;

public class MaxSubArray {
    public static void main(String[] args) {
        int numbers[] ={1, -2, 6, -1, 3};
        maxSubArraySumKadanAlgo(numbers);
    }

    public static void maxSubArraySumPrefix(int[] numbers) {
        int currSum =0;
        int maxSum =Integer.MIN_VALUE;
        int preFix[] = new int[numbers.length];
        preFix[0] = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            preFix[i] = preFix[i-1] + numbers[i];
        }
        for (int i = 1; i < numbers.length; i++) {
            int start = i;
            for (int j = start; j < numbers.length; j++) {
                int end = j;
                currSum= start == 0? preFix[end] :
                        preFix[end] - preFix[start -1];
                if(maxSum < currSum){
                    maxSum = currSum;
                }
            }
        }
        System.out.println(maxSum);
    }

    public static void maxSubArraySumKadanAlgo(int[] numbers){
        int ms= Integer.MIN_VALUE;
        int cs=0;
        for(int i=0;i<numbers.length;i++){
            cs= cs+ numbers[i];
            if(cs < 0){
                cs=0;
            }
            ms = Math.max(ms,cs);
        }
        System.out.println("maxSubArraySumKadanAlgo:  " + ms);
    }
}
