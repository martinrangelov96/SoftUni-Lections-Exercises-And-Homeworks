package lection.abstractions;

import lection.enums.LogType;
import lection.interfaces.Attacker;
import lection.interfaces.Handler;
import lection.interfaces.Observer;
import lection.interfaces.Target;

public abstract class AbstractHero implements Attacker, Observer {

    private static final String TARGET_NULL_MESSAGE = "lection.interfaces.Target null";
    private static final String NO_TARGET_MESSAGE = "%s has no target";
    private static final String TARGET_DEAD_MESSAGE = "%s is dead";
    private static final String SET_TARGET_MESSAGE = "%s targets %s";
    private Handler logger;

    private String id;
    private int dmg;
    private Target target;

    public AbstractHero(Handler logger, String id, int dmg) {
        this.logger = logger;
        this.id = id;
        this.dmg = dmg;
    }

    public void setTarget(Target target) {
        if (target == null) {
            this.logger.handle(LogType.TARGET, TARGET_NULL_MESSAGE);
        } else {
            this.target = target;
            this.logger.handle(LogType.TARGET, String.format(SET_TARGET_MESSAGE, this, target));
        }
    }

    protected Handler getLogger() {
        return this.logger;
    }

    public final void attack() {
        if (this.target == null) {
            this.logger.handle(LogType.ERROR, String.format(NO_TARGET_MESSAGE, this));
        } else if (this.target.isDead()) {
            this.logger.handle(LogType.ERROR, String.format(TARGET_DEAD_MESSAGE, target));
        } else {
            this.executeClassSpecificAttack(this.target, this.dmg);
        }
    }

    @Override
    public void update(int value) {
        this.dmg += value;
    }

    public String getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return this.id;
    }

    protected abstract void executeClassSpecificAttack(Target target, int dmg);
}
