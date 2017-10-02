package com.javarush.task.task35.task3513;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static java.awt.event.KeyEvent.*;

public class Controller extends KeyAdapter {
    private static final int WINNING_TILE = 2048;
    private Model model;
    private View view;

    public Controller(Model model) {
        this.model = model;
        this.view = new View(this);
    }

    public Tile[][] getGameTiles() {
        return model.getGameTiles();
    }

    public int getScore() {
        return model.score;
    }

    public void resetGame() {
        model.score = 0;
        view.isGameWon = false;
        view.isGameLost = false;
        model.resetGameTiles();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == VK_ESCAPE) {
            resetGame();
        }
        if (e.getKeyCode() == VK_Z) {
            model.rollback();
        }
        if (!model.canMove()) {
            view.isGameLost = true;
        }
        if (!view.isGameLost && !view.isGameWon) {
            if (e.getKeyCode() == VK_LEFT) {
                model.left();
            }
            if (e.getKeyCode() == VK_RIGHT) {
                model.right();
            }
            if (e.getKeyCode() == VK_UP) {
                model.up();
            }
            if (e.getKeyCode() == VK_DOWN) {
                model.down();
            }
            if (e.getKeyCode() == VK_R) {
                model.randomMove();
            }
            if (e.getKeyCode() == VK_A) {
                model.autoMove();
            }
        }
        if (model.maxTile == WINNING_TILE) {
            view.isGameWon = true;
        }
        view.repaint();
    }

    public View getView() {
        return view;
    }
}
