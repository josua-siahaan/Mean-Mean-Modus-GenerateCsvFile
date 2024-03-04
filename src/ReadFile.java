import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class ReadFile {
    public static ArrayList<ArrayList<String>> Read(String filecsv){

        BufferedReader br = null;

        ArrayList<String> lines = new ArrayList<>();
        ArrayList<ArrayList<String>> data = new ArrayList<>();

        try {
            br = new BufferedReader(new FileReader(filecsv));
            String line;

            while ((line = br.readLine()) != null){
                lines.add(line);
            }
            for (String row : lines){
                String[] value = row.split(";");
                ArrayList<String> valueRow = new ArrayList<>();
                Collections.addAll(valueRow, value);
                data.add(valueRow);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return data;
    }
}
