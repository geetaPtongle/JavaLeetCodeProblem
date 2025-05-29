package javacourse;

public class FinalVariables {
    final int finalDemo;
    final static int staticDemo;
    static int staticNormal;

    {
        //finalDemo = 200;
        System.out.println("Inside instance block");
    }

    static {
        System.out.println("Inside static block");
        staticDemo = 100;
    }

    public FinalVariables() {
        finalDemo = 200;
    }


    public static void main(String[] args) {
        final int a = 100;
        System.out.println(a);
        //a = 50;
        FinalVariables finalVariables = new FinalVariables();
        FinalVariables finalVariables1 = new FinalVariables();
        //finalVariables.finalDemo = 200;
        System.out.println(finalVariables.finalDemo);
        finalVariables.method1(400);

    }

    public void method1(final int a){
        //a = 100;
        System.out.println("In method : " + a);
    }
}
