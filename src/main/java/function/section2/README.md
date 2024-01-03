
# 02. Function, The Transformer

### Functional

```java
R apply(T t);
```

- T type 을 받아서 , R type 을 반환
- 일반적인 Mapper Function ( T 타입을 받아 , R 타입으로 변환 )
- 물론 같은 type 을 반환도 가능 - Identity ( 이는 , static Method 를 사용 - 차후 설명 )

#### Identity?

- Type을 받아 , 그 Type 과 Value 를 그대로 반환

```java
public String f(String value){
	return "value is "+value; => ❌
}
```

- String Type 은 일치하나 , 값이 변환되므로 Identity 가 아니다.
```java
public String identity(String value){
	return value;
}
```
- 이렇게 , Type 과 Value 가 변환되지 않아야만 Identity 이다.

```java
        final Function<Integer,Integer> identity = Function.identity();  
        System.out.println(identity.apply(999));  
  
        final Function<Integer,Integer> identity = t -> t;  
        System.out.println(identity.apply(20));
```
- 두 가지 방법으로 구현 가능

=> 자칫 보면 , 왜 필요한지 의문이 들 수 있음 ( 차후 설명할 예정 )

### Example

숫자 문자열을 -> 정수로 변환

```java
Function<String,Integer> toInteger = new Function<String, Integer>() {  
    @Override  
    public Integer apply(String s) {  
        return Integer.parseInt(s);  
    }  
};
```

( 물론 그냥 Integer.parseInt 를 해도 되나 , 함수형의 원형을 보여주는 예제 )

```java
System.out.println(toInteger.apply("5"));
```

- Scala 나 , JavaScript 에서는 바로 toInteger("100"); 같은 형식도 가능하나,
  Java 에서는 apply 메소드를 사용해줘야 한다.

```java
Function<String,Integer> toInteger = new Function<String, Integer>() {  
    public Integer process(String s){  
        return Integer.parseInt(s)+50;  
    }  
};  
toInteger.process("10");
```

- 이렇게는 당연히 사용히 불가능하다.
  ( Function 타입이나 , Function Type에 Custom Method 를 추가할 수 없으므로 )
```java
interface ExtendedFunction<T, R> extends Function<T, R> { 
	R process(T t); 
}
```

이렇게 Custom Function Type 을 만들어줘야 가능하다.

```java
Function<String,Integer> function = (element) -> Integer.parseInt(element);
```

- Method 가 하나라면 , 이렇게 Lambda 식으로도 선언 가능!
- element 는 무조건 String Type , return Type 은 무조건 Integer Type임을 안다.
