import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;


public class TextToGradeBook {

    public static GradeBook process(String fileName) {
        GradeBook output = new GradeBook();
        ArrayList<String> data = readFile(fileName);

        for (int i = 0; i < data.size(); i++) {
            String line = data.get(i);
            String[] primaryObjects = line.split(";");
            output.addStudent(new Student(primaryObjects[0]));

            for (int j = 1; j < primaryObjects.length; j++) {
                String[] secondaryObjects = primaryObjects[j].split(",");
                output.getStudent(i).addAssignment(secondaryObjects[0], Double.parseDouble(secondaryObjects[1]), Double.parseDouble(secondaryObjects[2]));
            }
        }
        return output;
    }

    public static ArrayList<String> readFile(String filePath) {
        ArrayList<String> output = new ArrayList<String>();
        File file = new File("/Users/lisapham/IdeaProjects/Java2021/src/Grade Book.txt");
        FileReader fr;
        try {
            fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                output.add(line);
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println("Failed to read file");
        }
        return output;
    }
}
