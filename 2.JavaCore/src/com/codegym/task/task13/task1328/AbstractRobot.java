package com.codegym.task.task13.task1328;

public abstract class AbstractRobot implements CanAttack, CanDefend{
    private static int hitCount;
    public BodyPart attack() {
        BodyPart attackedBodyPart = null;
        hitCount = (int) (Math.random() * 3.9);

        if (hitCount == 0) {
            attackedBodyPart = BodyPart.ARM;
        } else if (hitCount == 1) {
            attackedBodyPart = BodyPart.HEAD;
        } else if (hitCount == 2) {
            attackedBodyPart = BodyPart.LEG;
        } else if (hitCount == 3) {
            attackedBodyPart = BodyPart.CHEST;

        }
        return attackedBodyPart;
    }

    public BodyPart defend() {
        BodyPart defendedBodyPart = null;
        hitCount = (int) (Math.random() * 3.9);

        if (hitCount == 0) {
            defendedBodyPart = BodyPart.HEAD;
        } else if (hitCount == 1) {
            defendedBodyPart = BodyPart.LEG;
        } else if (hitCount == 2) {
            defendedBodyPart = BodyPart.ARM;
        } else if (hitCount == 3) {
            defendedBodyPart = BodyPart.CHEST;

        }
        return defendedBodyPart;
    }

    public abstract Object getName();
}
