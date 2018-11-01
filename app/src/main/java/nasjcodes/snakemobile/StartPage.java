package nasjcodes.snakemobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import nasjcodes.snakemobile.gamecode.gui.Game;

public class StartPage extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(0, 0);
        setContentView(R.layout.activity_start_page);

        //Start Button
        Button startButton = findViewById(R.id.startGame);
        startButton.setOnClickListener(this);

        //Settings Button
        Button settingsButton = findViewById(R.id.settings);
        settingsButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch(v.getId()) {

            case R.id.startGame:
                startActivity(new Intent(getApplicationContext(), Game.class));
                break;

            case R.id.settings:
                startActivity(new Intent(getApplicationContext(), Settings.class));
                break;
        }

    }


}
