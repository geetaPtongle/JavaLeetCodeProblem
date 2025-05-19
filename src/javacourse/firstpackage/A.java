package javacourse.firstpackage;

/*
Public > Protected > Default > Private

 */

public class A {
    private int privateVariableInA;
    int defaultVariableInA;
    public int publicVariableInA;
    protected int protectedVariableInA;

    protected void printMessageFromA(){
        privateVariableInA = 1000;
        protectedVariableInA = 100;
    }
}
