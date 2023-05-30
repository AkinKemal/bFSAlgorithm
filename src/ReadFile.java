import java.io.FileReader;
import java.io.BufferedReader;

public class ReadFile {

    LinkedListOperations linkedListOperations = new LinkedListOperations();
    public int size = 0;

    public ReadFile() {

    }

    public void readerFromFile(String fileName) {
        try {
            String line = "";
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            while ((line = bufferedReader.readLine()) != null) {
                String[] arraySplit = line.split(" ");
                if (line.length() == 1) {
                    if (size < Integer.parseInt(arraySplit[0])) {
                        size = Integer.parseInt(arraySplit[0]);
                    }
                } else {
                    int from = Integer.parseInt(arraySplit[0]);
                    int to = Integer.parseInt(arraySplit[1]);

                    linkedListOperations.add(from, to);

                    int max = Math.max(from, to);

                    if (size < max) {
                        size = max;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(fileName + e);
        }
    }

}