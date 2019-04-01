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

    public String getValue(String s_name, String p_name) throws IniConfigException{
        try {
            return configMap.get(s_name).get(p_name);
        } catch (NullPointerException e) {
            throw new IniConfigException("There is no parameter: " + s_name + "." + p_name, e);
        }
    }

    public int getIntegerValue(String s_name, String p_name) throws IniConfigException {
        try {
            return Integer.parseInt(this.getValue(s_name, p_name));
        } catch (NumberFormatException e) {
            throw new IniConfigException("Wrong parameter type: int", e);
        }
    }

    public double getDoubleValue(String s_name, String p_name) throws IniConfigException{
        try {
            return Double.parseDouble(this.getValue(s_name, p_name));
        }  catch (NumberFormatException e) {
            throw new IniConfigException("Wrong parameter type: double", e);
        }
    }


}
