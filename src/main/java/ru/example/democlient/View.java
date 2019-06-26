package ru.example.democlient;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import ru.example.democlient.service.Cell;
import ru.example.democlient.service.CellService;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;

public class View {

    JFrame lifeFrame = new JFrame();
    LifePanel lifePanel = new LifePanel();
    public static final int CELL_SIZE = 10;
    public static final int LIFE_AREA = 150;
    HashSet<Cell> listOfCells;

    private CellService cellService;
    //Настраиваем gui
    public View() {

        ApplicationContext ctx = SpringApplication.run(DemoClientApplication.class);
        cellService = ctx.getBean(CellService.class);

    }

    public void setGui() {
        lifeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lifeFrame.setSize(700,700);
        lifeFrame.getContentPane().add(lifePanel);
        lifeFrame.setVisible(true);
        lifePanel.repaint();
    }

    public void start(){

        while(true) {
            lifePanel.repaint();
            listOfCells = cellService.getNextGeneration();
        }

    }

    class LifePanel extends JPanel {
        public void paintComponent(Graphics g) {
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            listOfCells = cellService.getNextGeneration();
            for(Cell tempCell: listOfCells) {
                int x = tempCell.getX();
                int y = tempCell.getY();
                g.setColor(Color.CYAN);
                g.fillRect((this.getWidth() - LIFE_AREA)/2 + x,(this.getHeight() - LIFE_AREA)/2 + y,CELL_SIZE, CELL_SIZE);
                g.setColor(Color.BLACK);
                g.drawRect((this.getWidth() - LIFE_AREA)/2 + x,(this.getHeight() - LIFE_AREA)/2 + y,CELL_SIZE,CELL_SIZE);
            }
        }
    }
}
