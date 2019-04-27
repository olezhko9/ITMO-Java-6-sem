public class Main {
    public static void main(String[] args) {
        try {
            // resource
//            Main.class.getResourceAsStream("/config.txt");
        IniParser iniParser = new IniParser("\\home\\olezhko\\Документы\\Java\\ITMO-Java-6-sem\\lab 2 OOP\\src\\config.ini");
        ConfigMap config = iniParser.parse();
        int value = config.getIntegerValue("NCMD", "SampleRate");
        System.out.println(value);
        } catch (IniConfigException e) {
            System.out.println(e.getMessage());
            e.getInnerException().printStackTrace();
        }
    }
}
