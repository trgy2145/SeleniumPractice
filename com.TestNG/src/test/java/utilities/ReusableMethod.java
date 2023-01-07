package utilities;

public class ReusableMethod {
    public static void wait(int second){
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {

        }
    }
}
