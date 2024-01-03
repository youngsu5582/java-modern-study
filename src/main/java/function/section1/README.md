## Section 1

### 요구 사항

```java
List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9,10);
```
이런 배열이 있다고 할 시 ,
> 1 : 2 : 3 : ... : 10

과 같이 출력하게 하는 코드를 짜라

#### Non - Stream , Non - Iterator
```java
final List<Integer> numbers = IntStream.rangeClosed(1, 10).boxed().toList();  
final StringBuilder stringBuilder = new StringBuilder();  
  
for (int i = 0; i < size; i++) {  
    stringBuilder.append(numbers.get(i));  
    if (i != size - 1) {  
        stringBuilder.append(" : ");  
    }  
}
System.out.println(stringBuilder.toString());
```

- Human Error 가 발생하기 쉽다! ( size - 1 에서 , -2? )
- i 의 값을 수정할 시 , 에러를 발생 시킬 수 있다.

#### Non - Stream , Iterator

```java
final List<Integer> numbers = IntStream.rangeClosed(1, 10).boxed().toList();  
final StringBuilder stringBuilder = new StringBuilder();    
  
for(Integer element : numbers){  
    stringBuilder.append(element).append(" : ");  
}  
if (stringBuilder.length() > 0){
	stringBuilder.delete(stringBuilder.length() - 3, stringBuilder.length() -1);
}
System.out.println(stringBuilder.toString());
```

- delete 의 시작 부분 , 끝 부분 삭제!
  -> 이는 API 마다 달라질 수 있다. + Human Error 발생 가능


=> 결국 , 이들은 변화에 유연하지 못하다!

#### Stream ⭐️
```java
final String result = numbers.stream()  
        .map(String::valueOf)  
        .collect(Collectors.joining(" : "))  
        .toString();  
        
System.out.println(result);
```

- 매우 간단하며 , 실수를 유발할 수 없는 코드!
- 특히 , 위의 코드들은 해당 코드에서 사용하는 변수명들을 전부 기억을 하고 있어야 한다.