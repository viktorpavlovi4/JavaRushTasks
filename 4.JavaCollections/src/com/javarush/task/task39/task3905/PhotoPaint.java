package com.javarush.task.task39.task3905;

public class PhotoPaint {
    public boolean paintFill(Color[][] image, int r, int c, Color desiredColor) {
        int x = r;
        int y = c;

        if (image == null
                || desiredColor == null
                || x < 0 || y < 0
                || image.length <= y || image[0].length <= x
                || image[y][x] == desiredColor) return false;

        Color originColor = image[y][x];
        image[y][x] = desiredColor;
        if (y != 0 && image[y - 1][x] == originColor) paintFill(image, x, y - 1, desiredColor);
        if (y != image.length - 1 && image[y + 1][x] == originColor) paintFill(image, x, y + 1, desiredColor);
        if (x != 0 && image[y][x - 1] == originColor) paintFill(image, x - 1, y, desiredColor);
        if (x != image[0].length - 1 && image[y][x + 1] == originColor) paintFill(image, x + 1, y, desiredColor);

        return true;
    }
}
