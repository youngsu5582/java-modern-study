package closure.section1;

public class Main {
    protected Integer number = 999;

    @Override
    public String toString() {
        return new StringBuilder("Closure-Example")
                .append("number=")
                .append(number)
                .append('}')
                .toString();
    }

    public static <T> String toString(T value) {
        return "This Value is " + String.valueOf(value);
    }

    public static void main(String[] args) {
        Main main = new Main();
//        main.test1();
//        main.test2();
//        main.test3();
        main.test4();

    }

    public void test1() {
        Integer number = 100;

        testClosure("Anonymous Class", new Runnable() {
            @Override
            public void run() {
                System.out.println(Main.this.number);
            }
        });
        testClosure("Lambda Expression", () -> {
            System.out.println(this.number);
        });
    }

    public void test2() {

        testClosure("Anonymous Class", new Runnable() {
            @Override
            public void run() {
                System.out.println("this.toString() : " + this.toString());
            }
        });
        testClosure("Anonymous Class", new Runnable() {
            @Override
            public void run() {
                System.out.println("Closure this.toString() : " + Main.this.toString());
            }
        });
        testClosure("Lambda Expression", () -> {
            System.out.println("this.toString() : " + this.toString());
        });
    }

    public void test3() {
        testClosure("Anonymous Class", new Runnable() {
            @Override
            public void run() {
                System.out.println("ClosureExample this.toString(): " + Main.toString("Test"));
            }
        });
        testClosure(
                "Lambda Expression",
                () -> System.out.println("this.toString(): " + toString("Test"))
        );
    }
    public void test4(){
        int number = 100;
        testClosure("Anonymous Class", new Runnable() {
            @Override
            public void run() {
                int number = 50;
                System.out.println(number);
            }
        });
        testClosure("Lambda Expression(number) : ",()-> System.out.println(number));
        testClosure("Lambda Expression(this.number) : ",()-> System.out.println(this.number));
    }

    private static final void testClosure(final String name, final Runnable runnable) {
        System.out.println("========================================");
        System.out.println(name + ": ");
        runnable.run();
    }

}
