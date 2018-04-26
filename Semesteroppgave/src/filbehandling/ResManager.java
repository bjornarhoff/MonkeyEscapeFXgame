package filbehandling;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ResManager {

    // Metode som lager en Path, slik at filen kan bli lagret og vi kan lese den fra outputStream.
    public static void save (Serializable data, String filename) throws Exception {
        try (ObjectOutputStream output = new ObjectOutputStream(Files.newOutputStream(Paths.get(filename)))) {
            output.writeObject(data);
        }
    }

    // Metode som leser filen fra et objekt, og returnerer objektet
    public static Object load (String filename) throws Exception {
        try (ObjectInputStream input = new ObjectInputStream(Files.newInputStream(Paths.get(filename)))) {
            return input.readObject();
        }
    }
}
