import java.io.*;

public class IniParser {

    private String filename;
    public IniParser(String filename){
        this.filename = filename;
    }

    public ConfigMap parse(){
        ConfigMap configuration = new ConfigMap();
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
                    configuration.addSection(section_name);
                } else {
                    int equal_pos = line.indexOf('=');
                    if (equal_pos != -1) {
                        String parameter_name = line.substring(0, equal_pos - 1).trim();
                        String parameter_value = line.substring(equal_pos + 1).trim();
                        configuration.addParameter(section_name, parameter_name, parameter_value);
                    }
                }
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File " + this.filename + " not found");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Something wrong with IO");
            e.printStackTrace();
        }
        return configuration;
    }
}
