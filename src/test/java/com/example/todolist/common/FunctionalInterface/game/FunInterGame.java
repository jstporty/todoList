package com.example.todolist.common.FunctionalInterface.game;

import com.example.todolist.common.FunctionalInterface.TriConsumer;
import com.example.todolist.common.FunctionalInterface.TriSuplier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import org.assertj.core.util.TriFunction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FunInterGame {

  @DisplayName("FunInterPlint")
  @Test
  public void funInterGame() {
    //단어 세팅
    List<String> words = Arrays.asList("same", "NAME", "JAME", "dfs", "sdf", "aa", "GAME", "d");
    // Predicate: 'e'로 끝나는 단어만 필터링
    Predicate<String> endWithE = word -> word.endsWith("E");
    // Function: 단어의 길이를 반환
    Function<String, Integer> wordLenth = s -> s.length();
    // Consumer: 길이를 출력하는 소비자

    Consumer<Integer> printLen = System.out::println;

    Function<String, Integer> result = this::calc;

    Consumer<Integer> resultPlint = System.out::println;

    words.stream().filter(i -> i.trim().isBlank()).map(result).forEach(resultPlint);
    words.stream().filter(endWithE).map(wordLenth).forEach(printLen);

  }

  private Integer calc(String value) {
    int a = value.length();
    return a * 2;
  }

  @DisplayName("함수형 이터페이스 스트림 으로 구현해보기")
  @Test
  public void funInterStreamTest() {

    List<String> words = Arrays.asList("+", "*", "ㅋ");

    BiFunction<Integer, Integer, String> plusLogic = (a, b) -> String.valueOf(a + b);
    BiFunction<Integer, Integer, String> multiplLogin = (a, b) -> String.valueOf(a * b);

    Consumer<String> print = System.out::println;

    words.stream().map(i -> {
      if (Objects.equals(i, "*")) {
        return multiplLogin.apply(3, 3);
      } else if (Objects.equals(i, "+")) {
        return plusLogic.apply(3, 3);
      } else {
        return "계산 할 수 없는 인자가 넘어 왔습니다.";
      }
    }).forEach(print);

    // BiFunction<Integer, Integer, Integer> biFunction = (ab) ->
  }

  @DisplayName("함수형 이터페이스 스트림 으로 구현해보기2")
  @Test
  public void funInterStreamTest2() {

    List<String> words = Arrays.asList("+", "*", "ㅋ");

    BiFunction<Integer, Integer, String> plusLogic = (a, b) -> String.valueOf(a + b);
    BiFunction<Integer, Integer, String> multiplLogin = (a, b) -> String.valueOf(a * b);

    Consumer<String> print = System.out::println;

    Map<String, BiFunction<Integer, Integer, String>> operationMap = new HashMap<>();
    operationMap.put("+", plusLogic);
    operationMap.put("*", multiplLogin);

    words.stream().map(i -> operationMap.getOrDefault(i, (a, b) -> "계산 할 수 없는 인자가 넘어 왔습니다."
    ).apply(3, 3)).forEach(print);

  }

  @DisplayName("함수형 이터페이스 스트림 으로 구현해보기3")
  @Test
  public void funInterStreamTest3() {

    List<String> words = Arrays.asList("+", "*");

    BiFunction<Integer, Integer, String> plusLogic = (a, b) -> String.valueOf(a + b);
    BiFunction<Integer, Integer, String> multiplLogin = (a, b) -> String.valueOf(a * b);

    Consumer<String> print = System.out::println;

    Function<String, BiFunction<Integer, Integer, String>> operationFunction = op ->
        op.equals("+") ? plusLogic : op.equals("*") ? multiplLogin : (a, b) -> "Invalid operator";

    words.stream().map(operationFunction).map(i -> i.apply(3, 3)).forEach(print);

    words.stream().map(i -> operationFunction.apply(i).apply(3, 3)).forEach(print);

  }


  @DisplayName("함수형 이터페이스 스트림 으로 구현해보기4")
  @Test
  public void funInterStreamTest4() {

    List<String> words = Arrays.asList("+", "*", "ㅋ");

    //참고용
    // BiFunction<Integer, Integer, String> plusLogic = (a, b) -> String.valueOf(a + b);
    // BiFunction<Integer, Integer, String> multiplLogin = (a, b) -> String.valueOf(a * b);

    Consumer<String> print = System.out::println;

    enum operation {

      ADD("+", (a, b) -> String.valueOf(a + b)),
      MULTIPLE("*", (a, b) -> String.valueOf(a * b));


      private final String simbol;
      private final BiFunction<Integer, Integer, String> logic;


      operation(String simbol, BiFunction<Integer, Integer, String> logic) {
        this.simbol = simbol;
        this.logic = logic;
      }

      public static BiFunction<Integer, Integer, String> getLogicBySimbol(String symbol) {

        for (operation op : operation.values()) {
          if (op.simbol.equals(symbol)) {
            return op.logic;
          }
        }
        return (a, b) -> "계산 할 수 없는 로직 입니다.";
      }
    }
    words.stream().map(i -> operation.getLogicBySimbol(i).apply(3, 3)).forEach(print);
  }

}
