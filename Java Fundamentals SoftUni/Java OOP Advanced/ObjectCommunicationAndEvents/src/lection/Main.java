package lection;

import lection.commands.GroupAttackCommand;
import lection.commands.GroupTargetCommand;
import lection.implementations.*;
import lection.interfaces.*;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Handler combatLogger = new CombatLogger();
        Handler eventLogger = new EventLogger();

        combatLogger.setSuccessor(eventLogger);

        Observer warrior = new Warrior("Gosho1", 10, combatLogger);
        Observer warrior1 = new Warrior("Gosho2", 10, combatLogger);
        Observer warrior2 = new Warrior("Gosho3", 10, combatLogger);
        Observer warrior3 = new Warrior("Gosho4", 10, combatLogger);
        Subject target = new Dragon("Dragon", 40, 10, combatLogger);
        target.register(warrior);
        target.register(warrior1);
        target.register(warrior2);
        target.register(warrior3);

        AttackGroup group = new Group();
        group.addMember((Attacker) warrior);
        group.addMember((Attacker) warrior1);
        group.addMember((Attacker) warrior2);
        group.addMember((Attacker) warrior3);

        Command groupTargetCommand = new GroupTargetCommand(group, (Target) target);
        Command attackTargetCommand = new GroupAttackCommand(group);

        groupTargetCommand.execute();
        attackTargetCommand.execute();

    }
}
