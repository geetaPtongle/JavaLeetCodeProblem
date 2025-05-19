package javacourse.secondpackage;

import javacourse.firstpackage.A;
import javacourse.firstpackage.B;

public class D extends B {
    void printMessageFromD(){
        A a = new A();
        a.publicVariableInA = 60;
        //a.protectedVariableInA = 20;
        //a.printMessageFromA();

        B b = new B();
        b.publicVariableInB = 60;
        printMessageFromB();
        protectedVariableInB = 100;
    }
}
