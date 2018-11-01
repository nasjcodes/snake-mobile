package nasjcodes.snakemobile.gamecode.gui;

import android.os.Handler;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import nasjcodes.snakemobile.R;
import nasjcodes.snakemobile.gamecode.Direction;
import nasjcodes.snakemobile.gamecode.game.SnakeGame;
import nasjcodes.snakemobile.preferences.Preferences;

//This class is the equivalent of UserInterface
public class Game extends AppCompatActivity implements View.OnClickListener {
    private SnakeGame game;
    private GameBoard gameBoard;
    private int speedCap;
    private int curSpeed;
    Preferences preferences;


    private Handler snakeHandler = new Handler();
    Runnable snakeRunnable = new Runnable() {
        @Override
        public void run() {
            // Moves the Snake 1 step forward
            // similar to old "ActionPerformed" in SnakeGame
            game.performAction();

            //DrawingBoard equivalent
            gameBoard.update();

            if(game.continues()) {

                if(game.getSnake().getLength() > speedCap) {
                    curSpeed = speedCap;
                } else {
                    curSpeed = game.getSnake().getLength();
                }

                snakeHandler.postDelayed(snakeRunnable, 1000 / curSpeed);
            } else {
                //Change game elements to invisible
                View view = findViewById(R.id.game);
                view.setVisibility(View.INVISIBLE);

                //Show game over screen
                FragmentTransaction fragment = getSupportFragmentManager().beginTransaction();
                fragment.replace(R.id.gameOver, new GameOver());
                fragment.commit();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //Initialize snake game with height/width of 20, current speed to 1
        game = new SnakeGame(20, 20);
        curSpeed = 1;

        setPreferences();

        //Initialize game view and board
        ImageView gameView = (ImageView) findViewById(R.id.gameView);
        gameBoard = new GameBoard(game, gameView);

        //Start Runnable 500ms after activity is created
        snakeHandler.postDelayed(snakeRunnable, 500);

        //Directional buttons
        Button upButton = findViewById(R.id.upButton);
        upButton.setOnClickListener(this);

        Button downButton = findViewById(R.id.downButton);
        downButton.setOnClickListener(this);

        Button leftButton = findViewById(R.id.leftButton);
        leftButton.setOnClickListener(this);

        Button rightButton = findViewById(R.id.rightButton);
        rightButton.setOnClickListener(this);

    }

//    @Override
//    public void onPause() {
//        super.onPause();
//        timerHandler.removeCallbacks(timerRunnable);
//        Button b = (Button)findViewById(R.id.button);
//        b.setText("start");
//    }

    @Override
    public void onClick(View v) {

        switch(v.getId()) {

            case R.id.upButton:
                if(game.getSnake().getDirection() != Direction.DOWN) {
                    game.getSnake().setDirection(Direction.UP);
                }
                break;

            case R.id.downButton:
                if(game.getSnake().getDirection() != Direction.UP) {
                    game.getSnake().setDirection(Direction.DOWN);
                }
                break;

            case R.id.leftButton:
                if(game.getSnake().getDirection() != Direction.RIGHT) {
                    game.getSnake().setDirection(Direction.LEFT);
                }
                break;

            case R.id.rightButton:
                if(game.getSnake().getDirection() != Direction.LEFT) {
                    game.getSnake().setDirection(Direction.RIGHT);
                }
                break;
        }

    }

    void setPreferences() {
        //Get and set preferences
        preferences = new Preferences(this);

        //Set speed cap based on difficulty
        switch(preferences.getDifficulty()) {
            case 0:
                speedCap = 4;
                break;
            case 1:
                speedCap = 8;
                break;
            case 2:
                speedCap = 12;
                break;
        }
    }

}
