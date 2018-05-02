package filbehandling;
import java.io.*;

public class Filbehandling {

    public static final String filename = "TestOutput.sav";

    public static void main(String[] args) {

        SaveData nyobj = new SaveData();
        System.out.println(nyobj.toString());

        save(nyobj);


    }


    public static void save(Serializable objectToSerialise) {
        FileOutputStream fos = null;


        try {
            fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(objectToSerialise);
            oos.flush();
            oos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void load(){
        if(checkFileExists()){
            FileInputStream fis = null;

            try{
                fis = new FileInputStream(filename);
                ObjectInputStream ois = new ObjectInputStream(fis);
                SaveData loadedObject = (SaveData) ois.readObject();
                ois.close();
            } catch (ClassNotFoundException | IOException e){
                e.printStackTrace();
            }
        }
    }

    public static boolean checkFileExists(){
        return new File(filename).isFile();
    }
}
