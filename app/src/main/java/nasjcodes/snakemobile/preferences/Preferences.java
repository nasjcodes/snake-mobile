package nasjcodes.snakemobile.preferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Preferences {
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    public Preferences(Activity c) {
        preferences = PreferenceManager.getDefaultSharedPreferences(c);
    }

    public void setPreferences(String key, String value) {
        editor = preferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public void clearPreferences() {
        editor = preferences.edit();
        editor.clear();
        editor.apply();
    }

    public void setDifficulty(int value) {
        editor = preferences.edit();
        editor.putInt("Difficulty", value);
        editor.apply();
    }

    public int getDifficulty() {
        return preferences.getInt("Difficulty", 1);
    }

    public String getSnakeColor() {
        return preferences.getString("Game Color", "Black");
    }

    public String getAppleColor() {
        return preferences.getString("Apple Color", "Red");
    }
}
