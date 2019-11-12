package Entity;

import java.awt.image.BufferedImage;

abstract public class Tower extends AbstractEntity {
    private double range;
    private double power;
    private BufferedImage UnderImage;
    protected Bullet testBullet = new Bullet(x,y);
//    public ArrayList<Bullet> bullets = new ArrayList<>(10);
    private Enemy target;
    private double reloadTime=0;
    private double lastAttackTime;
    private double angleOfRotation;
    private double enemyDistanMaximun=300;




    public Tower(double x, double y) {
        super(x, y);
    }

    public Enemy getTarget(Enemy enemy) {
        return target;
    }

    public void setTarget(Enemy target) {
        this.target = target;
    }

    public double getEnemyDistanMaximun() {
        return enemyDistanMaximun;
    }

    public void setEnemyDistanMaximun(double enemyDistanMaximun) {
        this.enemyDistanMaximun = enemyDistanMaximun;
    }

    public double getAngleOfRotation() {
        if(target !=null)
            angleOfRotation = (180/Math.PI)*Math.atan2(target.getY()-y, target.getX()-x);
        return angleOfRotation;
    }

    public void setLastAttackTime(double lastAttackTime) {
        this.lastAttackTime = lastAttackTime;
    }
    public boolean canAttack(){
        if(this.target.distance((int)x,(int)y,(int)this.target.getX(),(int)this.target.getY())<this.enemyDistanMaximun){
            testBullet.setTargetX(target.getX());
            testBullet.setTargetY(target.getY());
            return true;
        }
        return false;
    }

    public BufferedImage getUnderImage() {
        return UnderImage;
    }

    public void setUnderImage(BufferedImage UnderImage) {
        this.UnderImage = UnderImage;
    }
    @Override
    public void update(){
        testBullet.update();
    }
}

