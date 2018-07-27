package Java2;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private static final int POS_X = 600;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWindow();
            }
        });
    }

    MainWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Circles");

        GameCanvas gameCanvas = new GameCanvas(this);


        add(gameCanvas, BorderLayout.CENTER);
        initGame();
        setVisible(true);

    }

    Sprite[] sprites = new Sprite[10];
    Sprite[] backgrouds = new Sprite[10];

    private void initGame() {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i] = new Ball();
            backgrouds[i] = new Background();
        }

    }

    public void onDrawFrame(GameCanvas canvas, Graphics g, float deltaTime)  {
        update(canvas, deltaTime);
        render(canvas, g);
        update1(canvas, deltaTime);
    }

    private void update(GameCanvas canvas, float deltaTime)  {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].update(canvas, deltaTime);

        }
    }



        private void update1(GameCanvas canvas, float deltaTime)  {

        if (System.nanoTime() != deltaTime){
            for (int i = 0; i < deltaTime; i++){

                backgrouds[i] = new Background();
                backgrouds[i].update(canvas, deltaTime);

                // Такой слипер тормозит всю прогрумму((((
                /*try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/

            }
        }
        }


    private void render(GameCanvas canvas, Graphics g) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].render(canvas, g);
        }
    }
}

// Background
//Ctrl + v

/*package Java2;

import javax.swing.*;
import java.awt.*;

public class Background extends Sprite {
    private final Color color = new Color(
            (int)(Math.random() * 255),
            (int)(Math.random() * 255),
            (int)(Math.random() * 255)
    );


    @Override
    void update(GameCanvas canvas, float deltaTime){

        canvas.setBackground(color);


    }

}*/
