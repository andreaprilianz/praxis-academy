package com.java2novice.generics;
 
public class Main {
 
    public static void main(String a[]){
         
        //Creating object of implementation class X called Y and 
        //passing it to BoundExmp as a type parameter.
        BoundExmp<Y> bey = new BoundExmp<Y>(new Y());
        bey.doRunTest();
        //Creating object of implementation class X called Z and 
        //passing it to BoundExmp as a type parameter.
        BoundExmp<Z> bez = new BoundExmp<Z>(new Z());
        bez.doRunTest();
        //If you uncomment below code it will throw compiler error
        //becasue we restricted to only of type X  implementation classes.
        //BoundExmp<String> bes = new BoundExmp<String>(new String());
        //bea.doRunTest();
    }
}
 