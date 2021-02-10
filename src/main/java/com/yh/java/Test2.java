package com.yh.java;

public class Test2 {
    public  class A{
        public  void   go(){
            System.out.println("A go()");
        }
    }
    public   static  class B{
        public  void   go(){
            System.out.println("B go()");
        }
    }
    public static void main(String[] args) {
A  a=new Test2().new A();
  a.go();
        B  b=new B();
    b.go();
    }
}