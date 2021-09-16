package test;

import org.junit.jupiter.api.*;
import src.classes.*;

class HeroTest {

    Hero myHero;
    Profession myProf;
    Weapon myWeapon;
    Weapon notMyWeapon;
    Armor myArmor;
    Armor notMyArmor;

    @BeforeEach
    void setUp(){
        myHero = new Hero("TestHero", "Warrior");
        myProf = new Profession("Warrior");
        myWeapon = new Weapon("Java Battle Axe", 1, "TwoHand", "Axe", 7, 1.1);
        notMyWeapon = new Weapon("C# Bow", 1, "TwoHand", "Bow", 12, 0.8);
        myArmor = new Armor("JUnit Body Plate", 1, "Body", "Plate", new int[]{1,0,0,2});
        notMyArmor = new Armor("VB Plate Legs", 3, "Legs", "Plate", new int[]{4,0,0,2});
    }

    @Test
    @Order(1)
    @DisplayName("Armor calculation without armor")
    void TestCalculateArmorValues_Valid_NoArmor() {
        Assertions.assertArrayEquals(new int[]{0,0,0,0}, myHero.calculateArmorValues(), "Armor values should be zero");
    }

    @Test
    @Order(2)
    @DisplayName("Equip wrong Armor")
    void TestEquipArmor_inValid_WrongLvl() {
        Assertions.assertEquals(false, notMyArmor.equipArmor(myHero, myProf), "Armor lvl is too high");
    }

    @Test
    @Order(3)
    @DisplayName("Equip wrong Armor")
    void TestEquipArmor_Valid_GoodLvl() {
        Assertions.assertEquals(true, myArmor.equipArmor(myHero, myProf), "Armor is equipped");
    }

    @Test
    @Order(4)
    @DisplayName("Armor calculation with armor")
    void TestCalculateArmorValues_Valid_WithArmor() {
        Assertions.assertArrayEquals(new int[]{0,0,0,0}, myHero.calculateArmorValues(), "Armor values should be 1,0,0,2");
    }

    @Test
    @Order(5)
    @DisplayName("Equip correct weapon")
    void TestEquipWeapon_Valid_LvlOk(){
        Assertions.assertEquals(true, myWeapon.equipWeapon(myHero, myProf), "Weapon shall be equipped");
    }

    @Test
    @Order(6)
    @DisplayName("Equip incorrect weapon")
    void TestEquipWeapon_inValid_WrongType(){
        Assertions.assertEquals(false, notMyWeapon.equipWeapon(myHero, myProf), "Weapon shall not be equipped");
    }

    @Test
    @Order(7)
    @DisplayName("Calculate DPS")
    void TestCalculateDPS_valid_DPS(){
       Assertions.assertEquals(8.085, myWeapon.calculateDPS(myProf.getTotalStr()), "DPS should be 8.085");
    }
}