public class Main {
    public static void main(String[] args) {
        System.out.println(args);
        IniParser config = new IniParser("C:\\Users\\Oleg Naumov\\YandexDisk\\Учеба\\6 семестр\\Технологии программирования\\lab 2 OOP\\src\\config.ini");
        config.parse();
//        int LogNCMD = Integer.parseInt(config.getValue("COMMON", "LogNCMD"));
        String value = config.getValue("NCMD", "SampleRat");
//        float SampleRate = Float.parseFloat("");
//        System.out.println(SampleRate);
    }
}
