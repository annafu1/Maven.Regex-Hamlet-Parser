import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser(){
        this.hamletData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData(){
        return hamletData;
    }

    //find hamlet words and replace to leon
    public int findHamletReplaceLeon() {
     int count = 0;
     Pattern pattern = Pattern.compile("hamlet");
     Matcher matcher = pattern.matcher(hamletData);
     count += matcher.groupCount();
     hamletData = matcher.replaceAll("Leon");
     return count;
    }

    public int findHamlet() {
        int count = 0;
        Pattern pattern = Pattern.compile("hamlet");
        Matcher matcher = pattern.matcher(hamletData);
        while (matcher.find()) {
            count++;
        }
        return count;
    }



    //find horatio words and replace to tariq
    public int findHoratioReplaceTariq() {
        int count = 0;
        Pattern pattern = Pattern.compile("horatio");
        Matcher matcher = pattern.matcher(hamletData);
        count += matcher.groupCount();
        hamletData = matcher.replaceAll("Tariq");
        return count;
    }

    public int findHoratio() {
        int count = 0;
        Pattern pattern = Pattern.compile("horatio");
        Matcher matcher = pattern.matcher(hamletData);
        while (matcher.find()) {
            count++;
        }
        return count;
    }
}
