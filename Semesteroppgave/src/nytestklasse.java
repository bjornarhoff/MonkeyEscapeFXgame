import java.io.*;

public class nytestklasse {

    public static void main(String[] args) throws Exception{

        System.out.println("Dette er feature-gaute");
        File loadFile = new File("obj.txt");

        FileInputStream fis = new FileInputStream(loadFile);
        ObjectInputStream ois = new ObjectInputStream(fis);
        


    }


}
