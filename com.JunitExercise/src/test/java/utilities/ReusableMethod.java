package utilities;

public class ReusableMethod {

    public static void wait(int second){
        //throws yapma yoksa cagırdıgın yerdede throws yapman lazım
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            System.out.println("yeniden kontrol et..");
        }
    }
}
