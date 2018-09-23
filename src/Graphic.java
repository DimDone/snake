import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Graphic extends JPanel {
    private static final int GRID_SIZE = 20;


    private GameField game;
    private Timer timerDrawGame;
    private Image background, body, head, emptyField, finishGame;
    private JLabel scoreLabel;
    private JButton restartGameButton, closeGameButton;

    Graphic(){
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
        restartGameButton.setForeground(Color.YELLOW);
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
            // TODO: - draw snake
        g.setColor(Color.BLUE);
        for (int i = 0; i<= this.game.field.length; i++){
            g.drawLine(10 + i * GRID_SIZE, 10,10 + i * GRID_SIZE, 610);
            g.drawLine(10,10 + i * GRID_SIZE, 610, 10 + i * GRID_SIZE);
        }
    }
}

