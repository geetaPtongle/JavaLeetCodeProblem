package javacourse;

public class StaticNestedDemo {
    private int x;
    int y;
    private static int z = 100;

    class Nested {
        void method1() {
            System.out.println(x);
            System.out.println(y);
            System.out.println(z);
        }
    }

    static class StaticNested{
        public void method1(){
            System.out.println("Nested static method");
            //System.out.println(x);
            //System.out.println(y);
            System.out.println(z);
        }
    }

    public static void main(String[] args) {
        //Nested nested = new Nested();
        StaticNestedDemo nestedDemo = new StaticNestedDemo();
        StaticNestedDemo.Nested nested = nestedDemo.new Nested();
        nested.method1();

        StaticNestedDemo.StaticNested staticNested = new StaticNestedDemo.StaticNested();
        staticNested.method1();
    }
}


