public class Main {
    public static void main(String[] args) {
        IniParser iniParser = new IniParser("C:\\Users\\Oleg Naumov\\YandexDisk\\Учеба\\6 семестр\\Технологии программирования\\lab 2 OOP\\src\\config.ini");
        ConfigMap config = iniParser.parse();
//        int LogNCMD = Integer.parseInt(config.getValue("COMMON", "LogNCMD"));
        double value = config.getDoubleValue("NCMD", "SampleRate");
//        float SampleRate = Float.parseFloat("");
        System.out.println(value);
    }
}
