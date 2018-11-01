package nasjcodes.snakemobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import nasjcodes.snakemobile.preferences.Preferences;

public class Settings extends AppCompatActivity implements View.OnClickListener{
    Spinner difficulty;
    Preferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(0, 0);
        setContentView(R.layout.activity_settings);
        setTitle("Settings");


        preferences = new Preferences(this);
        difficulty = (Spinner) findViewById(R.id.difficulty_spinner);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> difficultyAdapter = ArrayAdapter.createFromResource(
                this, R.array.difficulty, R.layout.spinner_text_item);

        // Specify the layout to use when the list of choices appears
        difficultyAdapter.setDropDownViewResource(R.layout.spinner_text_item);

        // Apply the adapter to the spinner
        difficulty.setAdapter(difficultyAdapter);

        // Set value of settings to saved preferences
        setSettings();

        //Defaults Button
        Button defaultsButton = findViewById(R.id.defaults);
        defaultsButton.setOnClickListener(this);

        //Back Button
        Button backButton = findViewById(R.id.back);
        backButton.setOnClickListener(this);

        //Save Button
        Button saveButton = findViewById(R.id.save);
        saveButton.setOnClickListener(this);

    }

    @Override
    public void onBackPressed () {
        super.onBackPressed();
        overridePendingTransition(0, 0);
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()) {

            case R.id.defaults:
                preferences.clearPreferences();
                setSettings();
                break;

            case R.id.back:
                this.finish();
                overridePendingTransition(0, 0);
                break;

            case R.id.save:
                preferences.setDifficulty(difficulty.getSelectedItemPosition());
                this.finish();
                overridePendingTransition(0, 0);
                break;
        }

    }

    private void setSettings() {
        difficulty.setSelection(preferences.getDifficulty());
    }

}
