package app.entities;

import app.entities.benders.Bender;
import app.entities.monuments.Monument;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//public class Nation {
//
//    private List<Bender> benders;
//    private List<Monument> monuments;
//    private String nationName;
//
//    public Nation(String nationName) {
//        this.benders = getBenders();
//        this.monuments = getMonuments();
//        this.nationName = nationName;
//    }
//
//    private int nationTotalPower = 0;
//
//    private void calculateTotalPower() {
//        benders.forEach(baseBender -> {
//            this.nationTotalPower += baseBender.calculateTotalPower();
//        });
//
//        monuments.forEach(baseMonument -> {
//            this.nationTotalPower += (this.nationTotalPower / 100) * baseMonument.getAffinity();
//        });
//    }
//
//    public List<Bender> getBenders() {
//        return Collections.unmodifiableList(this.benders);
//    }
//
//    public List<Monument> getMonuments() {
//        return Collections.unmodifiableList(this.monuments);
//    }
//}
