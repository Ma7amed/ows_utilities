package sample;



/**
 * Created by m80028770 on 5/4/2017.
 */
public class TestDrive {



    public static void main(String[] args) {

        String x = "1   2 3   4";
        String[] y = x.split(" +");

        for(int i=0;i<y.length;i++){
            System.out.println("TestDrive.main: " + y[i]);
        }

    }


}
