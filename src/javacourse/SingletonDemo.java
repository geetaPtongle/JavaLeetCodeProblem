package javacourse;

import jdk.jshell.execution.Util;

public class SingletonDemo {
    static SingletonDemo instance = null;
    public int x = 10;

    private SingletonDemo() {
    }

    static public SingletonDemo getInstance() {
        if (instance == null)
            instance = new SingletonDemo();
        return instance;
    }
}

class Main {
    public static void main(String[] args) {
        SingletonDemo singletonDemo1 = SingletonDemo.getInstance();
        SingletonDemo singletonDemo2 = SingletonDemo.getInstance();
        singletonDemo1.x = singletonDemo1.x + 10;
        System.out.println("Value of x in singletonDemo1 : " + singletonDemo1.x);
        System.out.println("Value of x in singletonDemo2 : " + singletonDemo2.x);
    }
}

