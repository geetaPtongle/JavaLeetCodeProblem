import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static int linearMethodCall(int arr[], int key){
    for(int i=0;i<arr.length;i++){
        if(arr[i]==key){
            return i;
        }
    }
    return -1;
    }
    public static void main(String[] args) {
        int arr[]= {12,23,34,56,55,78,9,90,67,22,45,46,5,765,8,86,86,68};
        int key =5;
        int index= linearMethodCall(arr, key);
        if(index==-1){
            System.out.println("Not found");
        }else {
            System.out.println("Key is at index: "+ index);
        }
    }
}