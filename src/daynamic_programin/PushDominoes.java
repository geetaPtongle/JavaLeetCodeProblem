package daynamic_programin;

public class PushDominoes {
    public String pushDominoes(String dominoes) {
        char []arr= new char[dominoes.length() +2];
        arr[0]='L';
        arr[arr.length-1]='R';
        for(int i=1; i< arr.length-1; i++){
            arr[i]=dominoes.charAt(i-1);
        }
       int k=0, j=0;
       while(j < arr.length){
           while(arr[k] =='.'){
               k++;
           }
           if(j-k > 1)
           solveConfiguration(arr, k,j);
           j=k;
           k++;
       }
       StringBuilder sb=new StringBuilder();
       for(int i=1; i< arr.length-1; i++){
           sb.append(arr[i]);
       }
        return sb.toString();
    }

    private void solveConfiguration(char[] arr, int k, int j) {
        if(arr[k] == 'L' && arr[k] == 'L'){
            for(int i=k+1; i< j; i++){
                arr[i]='L';
            }
        }
        else if(arr[k] == 'R' && arr[k] == 'R'){
            for(int i=k+1; i> j; i--){
                arr[i]='R';
            }
        }
        else if(arr[k] == 'L' && arr[k+1] == 'R'){

        }
        else{
            int diff =j-k ;
            int mid=(k+j)/2;
                    if(diff%2==0){ //odd
                        for(int i=k+1; i<mid; i++){
                            arr[i] ='R';
                        }
                    }
        }
    }

    public static void main(String[] args) {
        PushDominoes pd = new PushDominoes();
        System.out.println(pd.pushDominoes("L.R...LR..L.."));
    }
}
