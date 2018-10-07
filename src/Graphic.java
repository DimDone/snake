import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.*;

public class Graphic extends JPanel {
    private static final int GRID_SIZE = 20;
    private static final int MARGIN_LEFT = 10;
    private static final int MARGIN_RIGHT = 610;

    private GameField game;
    private Timer timerDrawGame;
    private Image background, body, head, fruit, tail, finishGame;
    private JLabel scoreLabel;
    private JButton restartGameButton, closeGameButton;

    Graphic() {
        try {
            background = ImageIO.read(new File("D:/Project/Snake/res/background.jpg"));
            body = ImageIO.read(new File("D:/Project/Snake/res/snakeBody.png"));
            head = ImageIO.read(new File("D:/Project/Snake/res/snakeHead.png"));
            tail = ImageIO.read(new File("D:/Project/Snake/res/snakeTail.png"));
            fruit = ImageIO.read(new File("D://Project//Snake//res//fruit.jpg"));
            finishGame = ImageIO.read(new File("D:/Project/Snake/res/end_game.jpg"));

        }catch (IOException e){
            e.printStackTrace();
        }

        game = new GameField();
        game.startGame();

        timerDrawGame = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        timerDrawGame.start();
        setLayout(null);

        scoreLabel = new JLabel("Score: ");
        scoreLabel.setForeground(Color.BLACK);
        scoreLabel.setFont(new Font("serif", 0, 35));
        scoreLabel.setBounds(630,200,150,150);
        add(scoreLabel);


        restartGameButton = new JButton("New Game");
        restartGameButton.setForeground(Color.BLACK);
        restartGameButton.setFont(new Font("serif", 2, 35));
        restartGameButton.setBounds(630,30,150,50);
        restartGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        add(restartGameButton);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < game.field.length; i++) {
            for (int j = 0; j < game.field[i].length; j++) {
                if (game.field[i][j] != 0) {
                    if (game.field[i][j] == 1) {
                        g.drawImage(head,
                                MARGIN_LEFT + GRID_SIZE * j,
                                MARGIN_LEFT + GRID_SIZE * i,
                                GRID_SIZE,
                                GRID_SIZE, null);
                    }
                    if (game.field[i][j] == -1) {
                        g.drawImage(fruit,
                                MARGIN_LEFT + GRID_SIZE * j,
                                MARGIN_LEFT + GRID_SIZE * i,
                                GRID_SIZE,
                                GRID_SIZE, null);
                    }
                }
            }
        }
        g.setColor(Color.WHITE);
        for (int i = 0; i <= this.game.field.length; i++) {
            g.drawLine(MARGIN_LEFT + i * GRID_SIZE,
                    MARGIN_LEFT,
                    MARGIN_LEFT + i * GRID_SIZE,
                    MARGIN_RIGHT);
            g.drawLine(MARGIN_LEFT,
                    MARGIN_LEFT + i * GRID_SIZE,
                    MARGIN_RIGHT,
                    MARGIN_LEFT + i * GRID_SIZE);
        }
    }
}

