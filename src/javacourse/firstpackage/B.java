package javacourse.firstpackage;

public class B {
    int defaultVariableInB;
    private int privateVariableInB;
    public int publicVariableInB;
    protected int protectedVariableInB;

    protected void printMessageFromB(){
        A a = new A();
        a.defaultVariableInA = 100;

        a.printMessageFromA();
        a.publicVariableInA = 50;
        a.protectedVariableInA = 500;
        protectedVariableInB = 100;
    }
}
