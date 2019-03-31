import java.util.HashMap;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.NullPointerException;

public class IniParser {

    String filename;
    private HashMap<String, HashMap<String, String>> configuration = new HashMap<>();

    public IniParser(){}

    public IniParser(String filename){
        this.filename = filename;
    }

    private void addSection(String s_name){
        HashMap<String, String> section_map = new HashMap<>();
        configuration.put(s_name, section_map);
    }

    private void addParameter(String s_name, String p_name, String p_value){
        configuration.get(s_name).put(p_name, p_value);
    }

    public void parse(){

        try {
            FileReader fr = new FileReader(new File(this.filename));
            BufferedReader reader = new BufferedReader(fr);


            String section_name = "DEFAULT_SECTION";
            String line = reader.readLine();
            while (line != null) {

                int comment_pos = line.indexOf(';');
                if (comment_pos != -1){
                    line = line.substring(0, comment_pos);
                }

                if (line.length() == 0) {
                    line = reader.readLine();
                    continue;
                }

                int open_bracket_pos = line.indexOf('[');
                if (open_bracket_pos != -1) {
                    int close_bracket_pos = line.indexOf(']');
                    section_name = line.substring(open_bracket_pos + 1, close_bracket_pos);
                    this.addSection(section_name);
                } else {
                    int equal_pos = line.indexOf('=');
                    if (equal_pos != -1) {
                        String parameter_name = line.substring(0, equal_pos - 1).trim();
                        String parameter_value = line.substring(equal_pos + 1).trim();
                        this.addParameter(section_name, parameter_name, parameter_value);
                    }
                }
//                System.out.println(line);
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getValue(String s_name, String p_name){
//        try {
//            return configuration.get(s_name).get(p_name);
//        } catch (NullPointerException e) {
//            return null;
//        }
        return configuration.get(s_name).get(p_name);
    }
}
