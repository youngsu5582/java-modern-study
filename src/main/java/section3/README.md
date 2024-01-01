# 03. Consumer , The Spartan

### Consumer

```java
Consumer<T>
```

```java
void accept(T t);
```

- T Type 을 받은 후 , void 를 반환

### Example

앞에 문자열을 붙혀 , println 을 실행

```java
final Consumer<String> printHelloWithConsumer = new Consumer<String>() {  
    @Override  
    public void accept(String s) {  
        System.out.println("Hello : " + s);  
    }  
};  
printHelloWithConsumer.accept("Youngsu");
```

Function 과 동일

```java
final Consumer<String> printByeWithLambda = (element) -> System.out.println("Bye : "+element);  
printByeWithLambda.accept("Youngsu");
```

Function 처럼 Lambda 역시 가능

#### Not Function?

여기 까지만 보면 , Function<String,void> 와 같이 구현이 불가능한지 생각할 수 있다.
```java
final Function<String,void> print2 = value -> System.out.println(value);
```

해당 코드는
`Bad return type in lambda expression: void cannot be converted to R`
와 같은 에러를 발생시킨다.

void 는 Primitive Type 이므로 , 애초에 들어갈 수 없음 +
Consumer 와 Function 은 기대하는 코드가 애초에 다름


Type 을 받아서 , 아무것도 반환하지 않으므로 Spartan

##### Give Them Nothing but Take from Them Everything
=> 모든 것을 빼앗으나 , 아무것도 주지 않으므로
