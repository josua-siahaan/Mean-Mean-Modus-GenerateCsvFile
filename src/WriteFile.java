import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile{
    public static void write(String csvFile, String data){
        try {
            File file = new File(csvFile);
            if (file.createNewFile()){
                System.out.println("new file is created");
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(data);
            bw.newLine();
            bw.flush();
            bw.close();
//            System.out.println("\nSuccesfull written to a file");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
