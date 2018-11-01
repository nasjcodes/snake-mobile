package nasjcodes.snakemobile.gamecode.gui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.widget.ImageView;

import nasjcodes.snakemobile.gamecode.domain.Piece;
import nasjcodes.snakemobile.gamecode.game.SnakeGame;

class GameBoard {
    private SnakeGame game;
    private ImageView gameView;
    private Canvas board;
    private Paint paint;
    private boolean firstUpdate;
    private int pieceLength;
    private int padding;


    GameBoard(SnakeGame game, ImageView gameView) {
        this.game = game;
        this.gameView = gameView;
        this.paint = new Paint();

        this.firstUpdate = true;
    }

    void update() {
        if(firstUpdate) {
            doFirstUpdate();
            firstUpdate = false;
        }

        //Reset whole board colours
        board.drawColor(Color.GRAY);
        //Paint Snake
        paint.setColor(Color.WHITE);
        for (Piece piece : game.getSnake().getPieces()) {
            board.drawRect(piece.getX() * pieceLength + padding, piece.getY() * pieceLength + padding,
                    (piece.getX() + 1) * pieceLength - padding, (piece.getY() + 1) * pieceLength - padding,
                    paint);
        }

        //Paint Apple
        paint.setColor(Color.RED);
        board.drawRect(game.getApple().getX() * pieceLength + padding, game.getApple().getY() * pieceLength + padding,
                (game.getApple().getX() + 1) * pieceLength - padding, (game.getApple().getY() + 1) * pieceLength - padding,
                paint);

        gameView.invalidate();
    }

    private void doFirstUpdate() {
        int vWidth = gameView.getWidth();
        int vHeight = gameView.getHeight();
        this.pieceLength = vWidth / 20;
        this.padding = 2;

        // Associate the bitmap to the ImageView.
        Bitmap bitmap = Bitmap.createBitmap(vWidth, vHeight, Bitmap.Config.RGB_565);
        gameView.setImageBitmap(bitmap);

        // Create a Canvas with the bitmap.
        board = new Canvas(bitmap);
    }

}
