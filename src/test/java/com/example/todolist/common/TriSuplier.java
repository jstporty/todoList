package com.example.todolist.common;

@FunctionalInterface
public interface TriSuplier<T,U,V,R> {

  R get(T t, U u, V v);

}
