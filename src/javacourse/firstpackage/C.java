package javacourse.firstpackage;

public class C extends B {

    void printMessageFromC() {
        B b = new B();
        b.publicVariableInB = 1000;
        b.printMessageFromB();
        printMessageFromB();
        b.protectedVariableInB = 400;
        protectedVariableInB = 400;

        b.defaultVariableInB = 1000;

        A a = new A();
    }
}
