package section7;

@FunctionalInterface
interface InvalidFunctionInterface<T>{
    String mkString(T value);
}