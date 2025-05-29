package heaps;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class HeapsInsert {
    static class Heap{
        ArrayList<Integer> arr =new ArrayList<>();

        public void insert(int val){
            arr.add(val);
            int x=arr.size()-1; //child index
            int par=(x-1)/2; //par index
            while(arr.get(x) < arr.get(par)){
                //swap
                int temp=arr.get(x);
                arr.set(x,arr.get(par));
                arr.set(par,temp);
            }

        }

        public int peek(){
            return arr.get(0);
        }

//        public int remove(){
//
//        }

    }

    public static void main(String[] args) {
        Heap h=new Heap();
//        System.out.println(h.insert(10));
    }
}
