package com.example.todolist.common.FunctionalInterface;

@FunctionalInterface
public interface TriSuplier<T,U,V,R> {

  R get(T t, U u, V v);

}
