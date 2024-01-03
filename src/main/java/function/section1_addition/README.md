### 기본적 예시


```java
public Integer calculate(Character calculation, int num1, int num2) {  
    if (calculation.equals('+')) {  
        return num1 + num2;  
    }
```

이렇게 , 숫자 두개에 대한 연산을 하는 Calculator 를 구현하라

#### Simple Code
```java
public class CalculatorService {  
    public Integer calculate(Character calculation, int num1, int num2) {  
        if (calculation.equals('+')) {  
            return num1 + num2;  
        } else if (calculation.equals('-')) {  
            return num1 - num2;  
        } else if (calculation.equals('*')) {  
            return num1 * num2;  
        } else if (calculation.equals('/')){  
            return num1 / num2;  
        }  
        throw new IllegalArgumentException("Not Exist Calculation");  
    }  
}
```

- 이렇게 , if 문 과 else if 문을 남발
  -> 물론 , 이렇게 코드 짜는 사람은 이제 없겠지만 단순 예시
- if 문 과 else if 문으로 인해 가독성이 떨어진다.

#### Code With Injection
```java
public interface ICalculation {  
    Integer calculate(Integer num1, Integer num2);  
}
```

```java
public class CalculatorWithInjectionService {  
    private ICalculation calculation;  
    public CalculatorWithInjectionService(ICalculation calculation) {  
        this.calculation = calculation;  
    }  
    public Integer calculate(Integer num1, Integer num2) {  
        return calculation.calculate(num1, num2);  
    }  
}
```

- 연산을 주입받아서 수행
- 한 연산마다 Service 를 하나씩 차지

#### Code With FP
```java
public class CalculatorWithFpService {  
    public Integer calculate(ICalculation calculation,Integer num1, Integer num2){  
        return calculation.calculate(num1,num2);  
    }  
}
```

- 여기까지만 보면 , 단순히 위의 코드에서도 주입해서 사용하면 되는거 아니야? 라고 생각할 수 있다.
```java
ICalculation addition = (num1, num2) -> num1+num2;  
calculatorWithFpService.calculate(addition,11,4);
```

- 이렇게 , Lambda 를 사용해서 주입이 가능하다!
- 매우 간결하게 사용이 가능

=> 솔직히 , 아직까지도 왜 필요한지 까지는 모르겠다.
결국 , Lambda 식이 주입되는건 동일한 거 같다.


### First Class Citizen

일급 시민 객체

- Function 의 Parameter 으로 넘길 수 있어야 한다.
- Function 의 Return 으로 반환할 수 있어야 한다.
- Data Structure 로 저장이 될 수 있어야 한다.
  -> `List<Element> list = ...;`

총 3가지를 만족하는 것이 일급 객체라고 한다.
그리고 모던 자바 이전( Before Java8 )에서는 Object 만이 First Class Citizen 이였다.

#### Function

```java
public String getName(){}

findByName(getName);  => ❌
public doSomething(){
	return getName;  => ❌
}
List<?> list = Arrays.asList(getName);  => ❌
```

Function 을 넣을 수 없었다.
-> Function 은 First Class Citizen 이 아니다.
#### Lambda

Java8 이후 추가된 Lambda 는 First Class Citizen 의 조건을 만족한다.

```java
Consumer<String> printer = s -> System.out.println(s);
printSomething(printer,"Hello World!");

void printSomething(Consumer<String> consumer , String s){
	consumer.accept(s);
}
```

Lambda 를 Parameter 로 넘김으로써 첫번째 조건 만족

```java
Supplier<String> createSupplier(){
	return () -> "Supplier";
}
Supplier<String> supplier = createSupplier();
System.out.println(supplier.get());
```
Lambda 를 Return 으로 반환함으로써 두번째 조건 만족

```java
List<BinaryOperator<Integer>> operators = new ArrayList<>();
operators.add((a, b) -> a + b);
```

Lambda 를 Data Structure 에 넣음으로써 세번째 조건 만족

