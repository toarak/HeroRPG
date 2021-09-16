package src;
import src.classes.*;

import java.awt.*;

public class main {

    public static void main (String[] args){

        Hero myHero = new Hero("Toarak", "Hunter");
        Profession myProf = new Profession("Hunter");
        Weapon serpentBow = new Weapon("Serpent Bow", 1, "TwoHand", "Sword", 2, 1.6 );
        Armor leatherJacket = new Armor("Leather Jacket", 2, "Body", "Leather", new int[]{1, 0, 2, 0});

        serpentBow.equipWeapon(myHero, myProf);
        leatherJacket.equipArmor(myHero, myProf);

        showCharacterSheet(myHero, myProf);

        serpentBow.calculateDPS(myProf.getTotalDex());

        makeLevelUp(myHero, myProf);

        leatherJacket.equipArmor(myHero, myProf);

        showCharacterSheet(myHero, myProf);

        serpentBow.calculateDPS(myProf.getTotalDex());


    }


    public static void makeLevelUp(Hero myHero, Profession myProf){

        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("Congratulations, you've reached a new level");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        int newLevel = myHero.getHeroLvl() + 1;
        myHero.setHeroLvl(newLevel);
        myProf.levelUp(newLevel, myHero.calculateArmorValues());
    }

    public static void showCharacterSheet(Hero myHero, Profession myProf){

        System.out.println("Character name: " + myHero.getHeroName());
        System.out.println("Character class: " + myHero.getHeroClass());
        System.out.println("Character level: " + myHero.getHeroLvl());
        System.out.println("Vitality: " + myProf.getTotalVit());
        System.out.println("Strength: " + myProf.getTotalStr());
        System.out.println("Dexterity: " + myProf.getTotalDex());
        System.out.println("Intelligence: " + myProf.getTotalInt());
        System.out.println("--------------------------------------");

    }
}
