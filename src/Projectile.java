public class Projectile extends MovingObject{
    public class Projectile {


        public static final String FILEPATH = "";  // 注意: 这里只给了一个默认空字符串，具体值应根据实际需求给出
        private double xCoordinate;
        private double yCoordinate;
        private Speed speed;
        private double angle;
        private int initialFrame;
        private int lastFrame;


        public Projectile() {

        }


        public void setAngle(Enemy enemy, Guardian guardian) {

        }

        public void setSpeed(Speed speed) {
            this.speed = speed;

        }

        public Object[] getSpeed() {

            return null;
        }

        public void update() {

        }

        public double getXCoordinate() {
            return xCoordinate;
        }

        public double getYCoordinate() {
            return yCoordinate;
        }

        public int getInitialFrame() {
            return initialFrame;
        }

        public int getLastFrame() {
            return lastFrame;
        }

        public void setXCoordinate(Play keyInput) {

        }

        public void setYCoordinate() {

        }

        public void setInitialFrame() {

        }

        public void setLastFrame() {

        }

        public void rotation(double angle) {

        }
    }
}
