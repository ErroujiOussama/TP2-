import java.io.FileWriter;
import java.io.IOException;

public class DataSaving {
    public String data="";
    public void save(String data) {
        this.data = data;
        try {
            FileWriter writer = new FileWriter("src/tables.html",true);
            writer.append(data);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error");
        }
    }
}
