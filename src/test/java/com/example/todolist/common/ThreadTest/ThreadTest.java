package com.example.todolist.common.ThreadTest;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;


public class ThreadTest {

  @Test
  @DisplayName("스레드 테스트")
  public void test() throws InterruptedException {
    for (int i = 0; i < 10; i++) {
      Thread thread = new Thread(() -> {
        System.out.println("Thread Name :::::: " + Thread.currentThread().getName() + "실행 중");
        try {
          Thread.sleep(1000); // 1초 대기
        } catch (Exception e) {
          e.printStackTrace();
        }
        System.out.println("Thread Name :::::: " + Thread.currentThread().getName() + " 종료");
      });
      thread.start();

    }
  }

  @Test
  @DisplayName("스레드 테스트sssssssssss")
  public void mainsaa() throws InterruptedException {

    List<Thread> threads = new ArrayList<>();  // 스레드를 저장할 리스트

    // 5개의 스레드 생성 및 실행
    for (int i = 0; i < 5; i++) {
      Thread thread = new Thread(() -> {
        System.out.println(Thread.currentThread().getName() + " 실행 중");
        try {
          Thread.sleep(1000); // 1초 대기
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 종료");
      });
      threads.add(thread);  // 스레드를 리스트에 추가
      thread.start();
    }

    // 모든 스레드가 종료될 때까지 대기
    for (Thread thread : threads) {
      thread.join();  // 각 스레드가 종료될 때까지 대기
    }

    // 메인 스레드 종료 후 출력
    System.out.println("메인 스레드: " + Thread.currentThread().getName());
  }


  @Test
  @DisplayName("스레드 테스트sssssssssss")
  public void mainsasddda() throws InterruptedException {

    // 가상 스레드 생성 및 실행
    for (int i = 0; i < 5; i++) {
      Thread thread = Thread.ofVirtual().name("my-virtual-thread-" + i).start(() -> {
        System.out.println(Thread.currentThread().getName() + " 실행 중");
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 종료");
      });

      // 메인 스레드 종료 대기

    }
  }
}


