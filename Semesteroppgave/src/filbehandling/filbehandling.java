package filbehandling;
import java.io.*;

public class filbehandling {

    public static void main(String[] args) throws Exception {

        Save nyobj = new Save();

        File saveFile = new File("obj.txt");
        FileOutputStream fos = new FileOutputStream(saveFile);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(nyobj);

    }
}

class Save implements Serializable {
    int i = 10;
}
