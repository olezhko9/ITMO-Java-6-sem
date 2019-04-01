public class Main {
    public static void main(String[] args) {
        try {
        IniParser iniParser = new IniParser("C:\\Users\\Oleg Naumov\\YandexDisk\\Учеба\\6 семестр\\Технологии программирования\\lab 2 OOP\\src\\config.ini");
        ConfigMap config = iniParser.parse();
        int value = config.getIntegerValue("NCMD", "SampleRate");
        System.out.println(value);
        } catch (IniConfigException e) {
            System.out.println(e.getMessage());
            e.getInnerException().printStackTrace();
        }
    }
}
