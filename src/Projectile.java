import bagel.DrawOptions;
import bagel.Image;

import java.util.List;

public class Projectile{

    private static final double SPEED = 6.0;
    private static final Image img = new Image("res/arrow.png");
    private static final int xmax = 1024;
    private static final int ymax = 768;
    private double xCoordinate;
    private double yCoordinate;
    private double xDirection;
    private double yDirection;
    private double radius;

    public Projectile(double startX, double startY, double endX, double endY) {
        this.xCoordinate = startX;
        this.yCoordinate = startY;

        // culculate the direction of the projectile
        double totalDistance = Math.sqrt(Math.pow(endX - startX, 2) + Math.pow(endY - startY, 2));
        this.xDirection = (endX - startX) / totalDistance;
        this.yDirection = (endY - startY) / totalDistance;
        this.radius = Math.atan2(endY - 600.0, endX - 800.0);
    }

    public void update() {
        this.xCoordinate += xDirection * SPEED;
        this.yCoordinate += yDirection * SPEED;

        double rotationAngle = Math.atan2(yDirection, xDirection); // 计算投掷物应该旋转的角度
        img.draw(xCoordinate, yCoordinate, new DrawOptions().setRotation(radius));
    }

    public boolean hasCollidedWith(Enemy enemy) {
        double distance = Math.sqrt(Math.pow(xCoordinate - enemy.getXCoordinate(), 2) + Math.pow(yCoordinate - enemy.getYCoordinate(), 2));
        return distance <= 62.0;
    }

    public boolean outOfBounds() {
        return xCoordinate < 0 || xCoordinate > xmax || yCoordinate < 0 || yCoordinate > ymax;
    }

    public static Enemy findNearestEnemy(List<Enemy> enemies) {
        Enemy nearestEnemy = null;
        double minDistance = 1281.0;

        for (Enemy enemy : enemies) {
            double distance = Math.sqrt(Math.pow(800.0 - enemy.getXCoordinate(), 2) + Math.pow(600.0 - enemy.getYCoordinate(), 2));

            if (distance < minDistance) {
                minDistance = distance;
                nearestEnemy = enemy;
            }
        }

        return nearestEnemy;
    }

}
