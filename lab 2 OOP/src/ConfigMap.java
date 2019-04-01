import java.util.HashMap;

public class ConfigMap {
    private HashMap<String, HashMap<String, String>> configMap = new HashMap<>();

    public void addSection(String s_name){
        HashMap<String, String> section_map = new HashMap<>();
        configMap.put(s_name, section_map);
    }

    public void addParameter(String s_name, String p_name, String p_value){
        configMap.get(s_name).put(p_name, p_value);
    }

    public int getIntegerValue(String s_name, String p_name){
        try {
            return Integer.parseInt(configMap.get(s_name).get(p_name));
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public double getDoubleValue(String s_name, String p_name){
        try {
            return Double.parseDouble(configMap.get(s_name).get(p_name));
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public String getValue(String s_name, String p_name){
        return configMap.get(s_name).get(p_name);
    }
}
