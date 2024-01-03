package function.section6;


public class Main {
    public static void main(String[] args) {
        TriFunction<String, String, String, String> f1 = (s, s2, s3) -> s + " and " + s2 + s3;
        println("Youngsu", "Yejin", f1);

        TriFunction<Long, String, String, String> f2 =
                (id, name, email) -> "User info: ID=" + id + ", name=" + name + ", email=" + email;
        println(1L, "Youngsu", "test@email.com",f2);
    }

    private static <T1, T2, T3> void println(T1 t1, T2 t2, TriFunction<T1, T2, String, String> f) {
        System.out.println(f.apply(t1, t2, " !!"));
    }

    private static <T1, T2, T3> void println(T1 t1, T2 t2, T3 t3, TriFunction<T1, T2, T3, String> f) {
        System.out.println(f.apply(t1, t2, t3));
    }
}
