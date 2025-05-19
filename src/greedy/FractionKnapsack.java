package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class FractionKnapsack {
    static class ItemComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            double a1 = (1.0 * a[0]) / a[1];  // value / weight
            double b1 = (1.0 * b[0]) / b[1];
            return Double.compare(b1, a1);  // descending order
        }
    }
    public static void main(String[] args) {
    int val[]={60, 100,120};
    int weigth[]= {10,20,30};
    int capacity=50;

    double ratio[][]=new double[val.length][2];
    for(int i=0;i<val.length;i++){
        ratio[i][0]=i;
        ratio[i][1]=val[i]/(double)weigth[i];
    }
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));
    int finalVal=0;
    for(int i=ratio.length-1;i>=0;i--){
        int idx= (int) ratio[i][0];
        if(capacity>=weigth[idx]){
            finalVal+=val[idx];
            capacity-=weigth[idx];
        }else{
            finalVal+=(int)(capacity*ratio[i][1]);
            break;
        }
    }
        System.out.println(finalVal);
    }
}
