package com.owen;

import java.awt.*;

/**
 * @author OwenHuang
 * @since 2022/11/5 18:54
 */
public class BulletWithLifeStatus2 {
    private static final int WIDTH = 10;
    private static final int HEIGHT = 10;
    private static final int SPEED = 10;
    private int x, y;
    private Direction direction;

    private TankFrame13 tankFrame;

    boolean alive = true;

    public BulletWithLifeStatus2(int x, int y, Direction direction, TankFrame13 tankFrame) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.tankFrame = tankFrame;
    }

    private void move() {
        switch (direction) {
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            default:
                break;
        }
        if (x < 0 || y < 0 || x > TankFrame12.GAME_WIDTH || y > TankFrame12.GAME_HEIGHT) {
            alive = false;
        }
    }

    /**
     * 游戏桌面的paint方法最终会调用桌面里面的所有元素的paint方法，所以每个元素的处理逻辑放在元素的paint方法里面
     * @param graphics 图形的上下文引用，所有画图操作都通过这个对象进行实现
     */
    public void paint(Graphics graphics) {
        /**
         * 此处需要将子弹从游戏桌面移除，所以需要持有游戏桌面的引用
         */
        if (!alive) {
            tankFrame.bullets.remove(this);
        }
        Color color = graphics.getColor();
        graphics.setColor(Color.RED);
        graphics.fillOval(x, y, WIDTH, HEIGHT);
        graphics.setColor(color);
        move();
    }
}