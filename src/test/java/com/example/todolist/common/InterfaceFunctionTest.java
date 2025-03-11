package com.example.todolist.common;

import static java.lang.String.valueOf;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import jdk.swing.interop.SwingInterOpUtils;
import net.minidev.json.JSONUtil;
import org.assertj.core.util.TriFunction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.internal.util.reflection.GenericMetadataSupport.BoundedType;

public class InterfaceFunctionTest {


  @Test
  @DisplayName("인터페이스를 익명 객체 구현하기 Test")
  public void interfaceTest() {
    System.out.println("이터페이스를 익명 객체로 구현:::::: ㄱㄱㄱㄱ");
    TriConsumer<String, Integer, Boolean> voidInterFace = (a, s, d) -> System.out.println(
        "String: " + a + " Integer: " + s + "  Boolean: " + d);

    InterfaceFunctionPrint(voidInterFace);

    TriFunction<Integer, Integer, Integer, String> sum = (a, b, c) -> valueOf(a + b + c);

    System.out.println("SUMMMMMMM =  " + sum.apply(1, 2, 3));


  }

  @DisplayName("Function의 apply 써보기")
  @Test
  public void FunctionTest() {
    Function<Integer, Integer> stringLength = a -> a * a;
    System.out.println("Integer * Integerb ': " + stringLength.apply(2));
  }

  @DisplayName("Predicate Test 써보기")
  @Test
  public void PredicateTest() {
    Predicate<Integer> isEven = num -> num % 2 == 0;
    System.out.println("Integer isEven: " + isEven.test(2));

  }


  @DisplayName("Consumer accept 써보기")
  @Test
  public void ConsumerTest() {
    Consumer<Integer> consumer = m -> System.out.println(" 숫자가 잘 나올까요? : " + m);

    consumer.accept(123123132);

  }


  @DisplayName("Supplier 3개 인자 받는거 만들어서 get 써보기")
  @Test
  public void SupplierTest() {

    Supplier<String> supplier = () -> "네 잘 나옵니다.";

    TriSuplier<Integer, Integer, Integer, String> supplierMadeByYeo = (a, b, c) -> valueOf(
        get(a, b, c));

    System.out.println("--------------->" + supplierMadeByYeo.get(1, 2, 3));

    System.out.println("supplier 잘 나와요? :  " + supplier.get());

  }


  private static Integer get(Integer a, Integer b, Integer c) {
    return a + b + c;
  }


  @DisplayName("BiFunction  apply 써보기")
  @Test
  public void BiFunctionTest() {

    BiFunction<String, String, Integer> biFunctionTest = (a, b) -> Integer.parseInt(a)
        + Integer.parseInt(b);

    Integer getInteger = biFunctionTest.apply("10", "10");

    System.out.println("biFunctionTest 두개더한 값 잘 나옵니까.??? " + getInteger);

  }


  @DisplayName("UnaryOperator apply 써보기")
  @Test
  public void UnaryOperatorTest() {

    UnaryOperator<String> unaryOperatorTest = s -> s + "<---옆에 붙임";

    System.out.println(unaryOperatorTest.apply("UnaryOperator 붙여보았어요 "));

  }


  @DisplayName("BinaryOperator  apply 써보기")
  @Test
  public void BinaryOperatorTest() {

    BinaryOperator<String> binary = (a,b) -> a+b;

    String getStringVal = binary.apply("1더하기"," 2는?");

    System.out.println( getStringVal  + " = 3" );
  }


  @DisplayName("BiConsumer  써보기")
  @Test
  public void BiConsumerTest() {

    BiConsumer<String,String> biConsumer = ( String a, String b) -> System.out.println( a+b +"올림픽 ㅋ");

     biConsumer.accept("8","8");

  }



  private static void InterfaceFunctionPrint(TriConsumer<String, Integer, Boolean> voidInterface) {
    voidInterface.accept("스트링", 1000000, true);

  }

  public static void InterfaceFunctionSumPrint(
      TriConsumer<Integer, Integer, Integer> voidInterface) {
    voidInterface.accept(1, 2, 3);

  }

}
