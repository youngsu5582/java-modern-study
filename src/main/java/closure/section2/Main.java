package closure.section2;

public class Main {
    private int number = 999;

    public static void main(String[] args) {
        new Main().test();
    }

    private void test() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(number);
            }
        };
        runnable.run();

        Runnable runnable1 = () -> System.out.println(number);
        runnable1.run();
    }
}
