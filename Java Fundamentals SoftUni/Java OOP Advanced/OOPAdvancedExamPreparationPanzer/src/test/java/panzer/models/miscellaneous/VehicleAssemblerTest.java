package panzer.models.miscellaneous;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import panzer.contracts.*;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class VehicleAssemblerTest {

    private Assembler vehicleAssembler;

    private AttackModifyingPart attackModifyingPartMock;
    private DefenseModifyingPart defenseModifyingPartMock;
    private HitPointsModifyingPart hitPointsModifyingPartMock;

    @Before
    public void setUp() throws Exception {
        this.vehicleAssembler = new VehicleAssembler();

        attackModifyingPartMock = Mockito.mock(AttackModifyingPart.class);
        defenseModifyingPartMock = Mockito.mock(DefenseModifyingPart.class);
        hitPointsModifyingPartMock = Mockito.mock(HitPointsModifyingPart.class);

        this.vehicleAssembler.addArsenalPart(attackModifyingPartMock);
        this.vehicleAssembler.addShellPart(defenseModifyingPartMock);
        this.vehicleAssembler.addEndurancePart(hitPointsModifyingPartMock);

    }

    @Test
    public void getTotalWeight() {
        Mockito.when(attackModifyingPartMock.getWeight()).thenReturn(10.0);
        Mockito.when(defenseModifyingPartMock.getWeight()).thenReturn(20.0);
        Mockito.when(hitPointsModifyingPartMock.getWeight()).thenReturn(30.0);

        double actualVehicleAssemblerWeight = this.vehicleAssembler.getTotalWeight();
        double expectedVehicleAssemblerWeight = 60.0;

        Assert.assertEquals(expectedVehicleAssemblerWeight, actualVehicleAssemblerWeight, 0.1);
    }

    @Test
    public void getTotalPrice() {
        Mockito.when(attackModifyingPartMock.getPrice()).thenReturn(BigDecimal.valueOf(20));
        Mockito.when(defenseModifyingPartMock.getPrice()).thenReturn(BigDecimal.valueOf(30));
        Mockito.when(hitPointsModifyingPartMock.getPrice()).thenReturn(BigDecimal.valueOf(40));

        BigDecimal actualVehicleAssemblerPrice = this.vehicleAssembler.getTotalPrice();
        BigDecimal expectedVehicleAssemblerPrice = BigDecimal.valueOf(90);

        Assert.assertEquals(expectedVehicleAssemblerPrice, actualVehicleAssemblerPrice);

    }

    @Test
    public void getTotalAttackModification() {
        Mockito.when(attackModifyingPartMock.getAttackModifier()).thenReturn(30);
        AttackModifyingPart attackModifyingPartMock2 = Mockito.mock(AttackModifyingPart.class);
        this.vehicleAssembler.addArsenalPart(attackModifyingPartMock2);
        Mockito.when(attackModifyingPartMock2.getAttackModifier()).thenReturn(40);

        long actualTotalAttackModification = this.vehicleAssembler.getTotalAttackModification();
        long expectedTotalAttackModification = 70;

        Assert.assertEquals(expectedTotalAttackModification, actualTotalAttackModification);
    }

    @Test
    public void getTotalDefenseModification() {
        Mockito.when(defenseModifyingPartMock.getDefenseModifier()).thenReturn(30);
        DefenseModifyingPart defenseModifyingPartMock2 = Mockito.mock(DefenseModifyingPart.class);
        this.vehicleAssembler.addShellPart(defenseModifyingPartMock2);
        Mockito.when(defenseModifyingPartMock2.getDefenseModifier()).thenReturn(40);

        long actualTotalDefenseModification = this.vehicleAssembler.getTotalDefenseModification();
        long expectedTotalDefenseModification = 70;

        Assert.assertEquals(expectedTotalDefenseModification, actualTotalDefenseModification);
    }

    @Test
    public void getTotalHitPointModification() {
        Mockito.when(hitPointsModifyingPartMock.getHitPointsModifier()).thenReturn(30);
        HitPointsModifyingPart hitPointsModifyingPartMock2 = Mockito.mock(HitPointsModifyingPart.class);
        this.vehicleAssembler.addEndurancePart(hitPointsModifyingPartMock2);
        Mockito.when(hitPointsModifyingPartMock2.getHitPointsModifier()).thenReturn(40);

        long actualTotalHitPointsModification = this.vehicleAssembler.getTotalHitPointModification();
        long expectedTotalHitPointsModification = 70;

        Assert.assertEquals(expectedTotalHitPointsModification, actualTotalHitPointsModification);
    }

    @Test
    public void addArsenalPart() {
        Assembler otherVehicleAssembler = new VehicleAssembler();

        Part attackModifyingPartMock1 = Mockito.mock(AttackModifyingPart.class);
        Part attackModifyingPartMock2 = Mockito.mock(AttackModifyingPart.class);

        Mockito.when(((AttackModifyingPart) attackModifyingPartMock1).getAttackModifier()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(((AttackModifyingPart) attackModifyingPartMock2).getAttackModifier()).thenReturn(Integer.MAX_VALUE);

        otherVehicleAssembler.addArsenalPart(attackModifyingPartMock1);
        otherVehicleAssembler.addArsenalPart(attackModifyingPartMock2);

        long actualAttackModification = otherVehicleAssembler.getTotalAttackModification();
        long expectedAttackModification = (long) Integer.MAX_VALUE + Integer.MAX_VALUE;

        Assert.assertEquals(expectedAttackModification, actualAttackModification);
    }

    @Test
    public void addShellPart() {
        Assembler otherVehicleAssembler = new VehicleAssembler();

        Part defenseModifyingPartMock1 = Mockito.mock(DefenseModifyingPart.class);
        Part defenseModifyingPartMock2 = Mockito.mock(DefenseModifyingPart.class);

        Mockito.when(((DefenseModifyingPart) defenseModifyingPartMock1).getDefenseModifier()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(((DefenseModifyingPart) defenseModifyingPartMock2).getDefenseModifier()).thenReturn(Integer.MAX_VALUE);

        otherVehicleAssembler.addShellPart(defenseModifyingPartMock1);
        otherVehicleAssembler.addShellPart(defenseModifyingPartMock2);

        long actualDefenseModification = otherVehicleAssembler.getTotalDefenseModification();
        long expectedAttackModification = (long) Integer.MAX_VALUE + Integer.MAX_VALUE;

        Assert.assertEquals(expectedAttackModification, actualDefenseModification);
    }

    @Test
    public void addEndurancePart() {
        Assembler otherVehicleAssembler = new VehicleAssembler();

        Part hitPointsModifyingPartMock1 = Mockito.mock(HitPointsModifyingPart.class);
        Part hitPointsModifyingPartMock2 = Mockito.mock(HitPointsModifyingPart.class);

        Mockito.when(((HitPointsModifyingPart) hitPointsModifyingPartMock1).getHitPointsModifier()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(((HitPointsModifyingPart) hitPointsModifyingPartMock2).getHitPointsModifier()).thenReturn(Integer.MAX_VALUE);

        otherVehicleAssembler.addEndurancePart(hitPointsModifyingPartMock1);
        otherVehicleAssembler.addEndurancePart(hitPointsModifyingPartMock2);

        long actualDefenseModification = otherVehicleAssembler.getTotalHitPointModification();
        long expectedAttackModification = (long) Integer.MAX_VALUE + Integer.MAX_VALUE;

        Assert.assertEquals(expectedAttackModification, actualDefenseModification);
    }
}