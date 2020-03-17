package latihan4;

public class SleepMessages {
    public static void main(String args []) 
        throws InterruptedException {
        String importantInfo[] = {
            "Mares eat oats",
            "Does eat oats",
            "Little lambs eat ivy too"
            };
        
        for(int i = 0; i < importantInfo.length; i++){
            //pause for 4 second 
            Thread.sleep(4000);
            //print a massage
            System.out.println(importantInfo[i]);
        }
        }
    }