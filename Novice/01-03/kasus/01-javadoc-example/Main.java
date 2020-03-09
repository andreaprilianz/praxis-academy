/**
* Example of program that using random    
* annotation with good javadoc documentation
*/

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
* Example annotation
*/
@Documented
@Retention(RetentionPolicy.RUNTIME)
@ interface TestAnnotation
{
    String Developer() default "Rahul";
    String Expirydate();
}

class Test
{
    /**
    * PrintLn Test method 1
    *
    * @TestAnnotation(Developer="data", Expirydate="01-10-2020")
    */
    void fun1()
    {
        System.out.println("Test method 1");
    }

    /**
    * PrintLn Test method 1
    *
    * @TestAnnotation(Developer="fair", Expirydate="01-10-2020")
    */
    void fun2()
    {
        System.out.println("Test method 2");
    }

    /**
    * Main Method here
    */
    public static void main(String args[])
    {
        /**
        * PrintLn
        */
        System.out.println("Hello");
    }
}