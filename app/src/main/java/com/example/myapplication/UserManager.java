package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;

public class UserManager {
    private static final String PREF_NAME = "UserPrefs";
    private static final String KEY_PREFIX = "user_";
    private SharedPreferences preferences;

    public UserManager(Context context) {
        preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public boolean registerUser(String username, String password) {
        if (userExists(username)) {
            return false;
        }
        preferences.edit().putString(KEY_PREFIX + username, password).apply();
        return true;
    }

    public boolean validateLogin(String username, String password) {
        String storedPassword = preferences.getString(KEY_PREFIX + username, null);
        return storedPassword != null && storedPassword.equals(password);
    }

    private boolean userExists(String username) {
        return preferences.contains(KEY_PREFIX + username);
    }
}
