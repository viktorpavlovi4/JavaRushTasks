package com.javarush.task.task35.task3513;

import java.util.*;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private boolean isSaveNeeded = true;
    private Stack previousStates = new Stack();
    private Stack previousScores = new Stack();
    private Tile[][] gameTiles;
    int score = 0;
    int maxTile = 2;

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    public Model() {
        resetGameTiles();
    }

    public void autoMove() {
        PriorityQueue<MoveEfficiency> moves = new PriorityQueue<>(4, Collections.reverseOrder());

        moves.offer(getMoveEfficiency(this :: left));
        moves.offer(getMoveEfficiency(this :: right));
        moves.offer(getMoveEfficiency(this :: up));
        moves.offer(getMoveEfficiency(this :: down));
        /*
        moves.offer(getMoveEfficiency(new Move() {
            @Override
            public void move() {
                left();
            }
        }));
        moves.offer(getMoveEfficiency(new Move() {
            @Override
            public void move() {
                right();
            }
        }));
        moves.offer(getMoveEfficiency(new Move() {
            @Override
            public void move() {
                up();
            }
        }));
        moves.offer(getMoveEfficiency(new Move() {
            @Override
            public void move() {
                down();
            }
        }));
*/
        moves.peek().getMove().move();
    }

    public MoveEfficiency getMoveEfficiency(Move move) {
        MoveEfficiency moveEfficiency;
        move.move();
        if (hasBoardChanged()) {
            moveEfficiency = new MoveEfficiency(getEmptyTiles().size(), score, move);
        } else {
            moveEfficiency = new MoveEfficiency(-1, 0, move);
        }
        rollback();
        return moveEfficiency;
    }

    public boolean hasBoardChanged() {
        int sum1 = 0;
        int sum2 = 0;
        if (!previousStates.isEmpty()) {
            Tile[][] prevGameTiles = (Tile[][]) previousStates.peek();
            for (int i = 0; i < FIELD_WIDTH; i++) {
                for (int j = 0; j < FIELD_WIDTH; j++) {
                    sum1 += gameTiles[i][j].value;
                    sum2 += prevGameTiles[i][j].value;
                }
            }
        }
        return sum1 != sum2;
    }

    public void randomMove() {
        int n = ((int) (Math.random() * 100)) % 4;
        switch (n) {
            case 0:
                left();
            case 1:
                right();
            case 2:
                up();
            case 3:
                down();
        }
    }

    public void rollback() {
        if (!previousStates.isEmpty()) {
            gameTiles = (Tile[][]) previousStates.pop();
        }
        if (!previousScores.isEmpty()) {
            score = (int) previousScores.pop();
        }
    }

    private void saveState(Tile[][] tile) {
        Tile[][] newTile = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < tile.length; i++) {
            for (int j = 0; j < tile[i].length; j++) {
                newTile[i][j] = new Tile(tile[i][j].value);
            }
        }
        previousStates.push(newTile);
        previousScores.push(score);
        isSaveNeeded = false;
    }

    private List<Tile> getEmptyTiles() {
        List<Tile> emptyTiles = new ArrayList<>();
        for (Tile[] gameTile : gameTiles) {
            for (Tile tile : gameTile) {
                if (tile.isEmpty() || tile.value == 0)
                    emptyTiles.add(tile);
            }
        }
        return emptyTiles;
    }

    boolean canMove() {
        if (!getEmptyTiles().isEmpty())
            return true;
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 1; j < gameTiles.length; j++) {
                if (gameTiles[i][j].value == gameTiles[i][j - 1].value)
                    return true;
            }
        }
        for (int j = 0; j < gameTiles.length; j++) {
            for (int i = 1; i < gameTiles.length; i++) {
                if (gameTiles[i][j].value == gameTiles[i - 1][j].value)
                    return true;
            }
        }
        return false;
    }

    private void addTile() {
        List<Tile> emptyTiles = getEmptyTiles();
        if (!emptyTiles.isEmpty())
            emptyTiles.get((int) (Math.random() * getEmptyTiles().size())).value = (Math.random() < 0.9 ? 2 : 4);
    }

    protected void resetGameTiles() {
        gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
    }

    private boolean compressTiles(Tile[] tiles) {
        boolean isChanged = false;
        for (int i = 1; i < tiles.length; i++) {
            for (int j = 1; j < tiles.length; j++) {
                if (tiles[j - 1].isEmpty() && !tiles[j].isEmpty()) {
                    isChanged = true;
                    tiles[j - 1] = tiles[j];
                    tiles[j] = new Tile();
                }
            }
        }
        return isChanged;
    }

    private boolean mergeTiles(Tile[] tiles) {
        boolean isChanged = false;
        for (int i = 1; i < tiles.length; i++) {
            if ((tiles[i - 1].value == tiles[i].value) && !tiles[i - 1].isEmpty() && !tiles[i].isEmpty()) {
                isChanged = true;
                tiles[i - 1].value *= 2;
                score += tiles[i - 1].value;
                maxTile = maxTile > tiles[i - 1].value ? maxTile : tiles[i - 1].value;
                tiles[i] = new Tile();
                compressTiles(tiles);
            }
        }
        return isChanged;
    }

    void left() {
        boolean isChanged = false;
        if (isSaveNeeded) {
            saveState(gameTiles);
        }
        for (int i = 0; i < gameTiles.length; i++) {
            if (compressTiles(gameTiles[i]) | mergeTiles(gameTiles[i]))
                isChanged = true;
        }
        if (isChanged) {
            addTile();
        }
        isSaveNeeded = true;
    }

    void right() {
        saveState(gameTiles);
        rotateMatrixRight();
        rotateMatrixRight();
        left();
        rotateMatrixRight();
        rotateMatrixRight();
    }

    void up() {
        saveState(gameTiles);
        rotateMatrixRight();
        rotateMatrixRight();
        rotateMatrixRight();
        left();
        rotateMatrixRight();
    }

    public void down() {
        saveState(gameTiles);
        rotateMatrixRight();
        left();
        rotateMatrixRight();
        rotateMatrixRight();
        rotateMatrixRight();
    }

    public void rotateMatrixRight() {
        for (int i = 0; i < FIELD_WIDTH / 2; i++) {
            for (int j = i; j < FIELD_WIDTH - 1 - i; j++) {
                Tile tmp = gameTiles[i][j]; // 0  2
                gameTiles[i][j] = gameTiles[FIELD_WIDTH - 1 - j][i]; // 0  2 = 1  0
                gameTiles[FIELD_WIDTH - 1 - j][i] = gameTiles[FIELD_WIDTH - 1 - i][FIELD_WIDTH - 1 - j]; // 1 0 = 3 1
                gameTiles[FIELD_WIDTH - 1 - i][FIELD_WIDTH - 1 - j] = gameTiles[j][FIELD_WIDTH - 1 - i]; // 3 1 = 2 3
                gameTiles[j][FIELD_WIDTH - 1 - i] = tmp; // 2 3 = 0 2
            }
        }
    }
}
