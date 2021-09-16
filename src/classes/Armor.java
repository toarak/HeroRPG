package src.classes;

import java.util.Arrays;

public class Armor {

    private String armName;
    private int armLvl;
    private String armSlot;
    private String armType;
    private int[] armAttr;

    public Armor(String armName, int armLvl, String armSlot, String armType, int[] armAttr) {
        this.armName = armName;
        this.armLvl = armLvl;
        this.armSlot = armSlot;
        this.armType = armType;
        this.armAttr = armAttr;
    }

    /**
     * Getter, setter section
     **/

    public int[] getArmAttr() {
        return armAttr;
    }

    /**
     * function section
     **/


    //equip new Armor
    public boolean equipArmor(Hero myHero, Profession heroProf){

        //check needed lvl
        if (this.armLvl > myHero.getHeroLvl()){
            System.out.println("Can't equip that armor, your level is too low");
            return false;
        }

        //check if type is allowed
        String[] armAllowed = heroProf.getProfArmAllowed();
        if ( !Arrays.stream(armAllowed).anyMatch(this.armType :: equals) ) {
            System.out.println("Can't equip that armor, this type not allowed for your class.");
            return false;
        }

        //all good, so equip it
        switch (this.armSlot){
            case "Body":
                myHero.setHeroBody(this);
                break;
            case "Head":
                myHero.setHeroHead(this);
                break;
            case "Legs":
                myHero.setHeroLegs(this);
            case "Feed":
                myHero.setHeroFeet(this);
            default:
                break;
        }

        System.out.println("Your new armor is equipped now.");
        return true;
    }
}
