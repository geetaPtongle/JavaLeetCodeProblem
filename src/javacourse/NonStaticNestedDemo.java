package javacourse;

public class NonStaticNestedDemo {
    private int x;
    int y;

    class Nested {
        void method1() {
            System.out.println(x);
            System.out.println(y);
        }
    }

    public static void main(String[] args) {
        //Nested nested = new Nested();
         NonStaticNestedDemo nestedDemo = new NonStaticNestedDemo();
        NonStaticNestedDemo.Nested nested = nestedDemo.new Nested();
        nested.method1();
    }
}


