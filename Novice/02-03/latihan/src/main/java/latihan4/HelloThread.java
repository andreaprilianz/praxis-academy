package latihan4;

public class HelloThread extends Thread{

    public void run(){
        System.out.println("Hello from a threas!");
    }

    public static void main(String[] args) {
        (new HelloThread()).start();
    }
}