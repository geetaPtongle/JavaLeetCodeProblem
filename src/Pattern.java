public class Pattern {
    public static void main(String[] args) {
        hollw_Rectangle(10,7);
    }

    private static void hollw_Rectangle(int rowCount, int colCount) {
        for(int i=1; i<= rowCount; i++){
            for(int j=1; j<= colCount; j++){
                if(i== 1 || i == rowCount || j== 1 || j == colCount){
                    System.out.print("*");
                }else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
