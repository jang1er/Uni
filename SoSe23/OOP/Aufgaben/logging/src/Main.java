import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main (String[] args){
        // log datei einlesen
        // pattern matching für warnungen
        // capture groups
        Path filePath = Path.of("build.log");
        String file = null;
        try {
            file = Files.readString(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(file == null)return;
        Pattern p = Pattern.compile("Warning (\\d+)((.*(\\n+\\s+.*?){2}?)at )((/[\\w+.-]*)+)(\\sline\\s)(\\d+)");
        Matcher matcher = p.matcher(file);

        int sumErrors = 0;
        while(matcher.find()){
            sumErrors++;
            System.out.println("Warning " + matcher.group(1) + " at line " + matcher.group(8) + " in file " + matcher.group(5));
        }
        System.out.println("\n" + sumErrors + " were found in log file");
    }
}
