package app;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;
import java.util.Scanner;
import static java.lang.System.exit;

/**
 * Read commands from the keyboard and execute them.
 * @author Carina Marele 2A4
 */
public class LocaleExplorer {
    Properties commands = new Properties();
    public void start() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, IOException {
        //folosesc un fisier de proprietati Locales.properties pentru a putea apela clasele comenzilor
        commands.load(this.getClass().getClassLoader().getResourceAsStream("Locales.properties"));
        //setez pe limba romana, pentru engleza vom folosi en-US
        CommandsLocale.setLocale("ro-RO");
        Scanner scanner = new Scanner(System.in);//pentru citirea comenzilor de la tastatura
        while (true) {
            System.out.print(CommandsLocale.message("prompt"));
            String command = scanner.nextLine();
            if (command.equals("exit")) break;
            String[] params = command.trim().split("\\s+");
            switch (params[0]) {
                case "locales" : {
                    Class clazz = Class.forName(commands.getProperty("display-locale.impl"));
                    clazz.getConstructor().newInstance();
                    break;
                }
                case "set" : {
                    Class clazz = Class.forName(commands.getProperty("set-locale.impl"));
                    clazz.getConstructor(String.class).newInstance(params[1]);
                    break;
                }
                case "info" : {
                    Class clazz = Class.forName(commands.getProperty("info-locale.impl"));
                    clazz.getConstructor().newInstance();
                    break;
                }
                case "close" : {
                    System.out.println("Program ended");
                    exit(1);
                }
                default : System.out.println(CommandsLocale.message("invalid"));

            }
        }
    }


    public static void main(String args[]) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException {
        new LocaleExplorer().start();
    }
}