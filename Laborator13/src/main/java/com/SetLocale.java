package com;

import app.CommandsLocale;

/**
 * Class to set the application current locale
 */
public class SetLocale {

   public SetLocale(String languageTag) {
            CommandsLocale.setLocale(languageTag);
        }
    }

