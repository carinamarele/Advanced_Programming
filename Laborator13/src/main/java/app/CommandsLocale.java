package app;

import java.text.DateFormatSymbols;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Currency;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Contains the implementations for all commands
 */
public class CommandsLocale
{
    private static final String baseName = "Messages";
    private static Locale locale;
    private static ResourceBundle resourceBundle; //folosit pentru gasirea fisierelor de tipul properties

    public static String message(String key, String ... arguments) {
        String pattern = resourceBundle.getString(key);
        String message = new MessageFormat(pattern).format(arguments);
        return message;
    }
    public static void setLocale(String languageTag) {
        CommandsLocale.locale = Locale.forLanguageTag(languageTag);
        CommandsLocale.resourceBundle = ResourceBundle.getBundle(baseName, locale);
        message("locale.set", languageTag);
    }

    public static void displayLocales() {
        System.out.println(CommandsLocale.message("locales"));
        for (Locale locale : Locale.getAvailableLocales())
        {
            System.out.println(locale.toString());
        }
    }
    public static void localeInfo() {
        System.out.println(CommandsLocale.message("locale.set", CommandsLocale.getLocale().getDisplayName()));
        Currency currency  = Currency.getInstance(CommandsLocale.getLocale());
        DateFormatSymbols fo = DateFormatSymbols.getInstance(CommandsLocale.getLocale());
        System.out.println("Country: "+ CommandsLocale.getLocale().getCountry());
        System.out.println("Language: "+ CommandsLocale.getLocale().getLanguage());
        System.out.println("Currency: "+currency.getCurrencyCode());
        System.out.print("Week Days: ");
        for (String s : fo.getWeekdays()) {
            System.out.print(s+" ");
        }
        System.out.println();
        System.out.print("Months: ");
        for (String s : fo.getMonths()) {
            System.out.print(s + " ");
        }
        System.out.println();
        System.out.print("Today: ");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMM yyyy", CommandsLocale.getLocale());
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
    }

    public static Locale getLocale()
    {
        return CommandsLocale.locale;
    }
}