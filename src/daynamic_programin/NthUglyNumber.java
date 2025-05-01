package daynamic_programin;

public class NthUglyNumber {
    public int nthUglyNumber1(int n) {
        int count =1;
        if(n==1) return 1;
        int ans =0;
        for(int i=2; i<Integer.MAX_VALUE; i++){
            int temp = i;
            while(temp %2 ==0) temp /=2;
            while(temp %3 ==0) temp /=3;
            while(temp %5 ==0) temp /=5;
            if(temp ==1){
                count++;

                if(count == n){
                    ans=i;
                    break;
                }

            }
        }
        return ans;
    }

    public int nthUglyNumber(int n) {
        int[] arr = new int[1690];
        int ugly = 0, i2 = 0, i3 = 0, i5 = 0;
        arr[0] = 1;
        for (int i = 1; i < 1690; i++) {
            arr[i] = Math.min(Math.min(arr[i2] * 2, arr[i3] * 3), arr[i5] * 5);
            ugly = arr[i];
            if (ugly == arr[i2] * 2)
                i2++;
            if (ugly == arr[i3] * 3)
                i3++;
            if (ugly == arr[i5] * 5)
                i5++;
        }
        return arr[n - 1];
    }
    public static void main(String[] args) {
        NthUglyNumber ntn = new NthUglyNumber();
        System.out.println(ntn.nthUglyNumber(10));
    }
}
