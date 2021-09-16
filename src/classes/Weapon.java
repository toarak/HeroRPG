package src.classes;

import java.util.Arrays;

public class Weapon {

    private String wpnName;
    private int wpnLvl;
    private String wpnSlot;
    private String wpnType;
    private int wpnDmg;
    private double wpnSpeed;

    public Weapon(String wpnName, int wpnLvl, String wpnSlot, String wpnType, int wpnDmg, double wpnSpeed) {
        this.wpnName = wpnName;
        this.wpnLvl = wpnLvl;
        this.wpnSlot = wpnSlot;
        this.wpnType = wpnType;
        this.wpnDmg = wpnDmg;
        this.wpnSpeed = wpnSpeed;
    }

    /**
     * getter, setter section
     **/

    /**
     * function section
     **/

    //equip new Armor
     public boolean equipWeapon(Hero myHero, Profession heroProf){

        //check needed lvl
        if (this.wpnLvl > myHero.getHeroLvl()){
            System.out.println("Can't equip that weapon, your level is too low");
            return false;
        }


        //check if type is allowed
        String[] wpnAllowed = heroProf.getProfWpnAllowed();
        if ( !Arrays.stream(wpnAllowed).anyMatch(this.wpnType :: equals) ){
            System.out.println("Can't equip that weapon, this type is not allowed for your class.");
            return false;
        }

        //all good, so equip it
        switch (this.wpnSlot){
            case "Left":
                myHero.setHeroWpnLeft(this);
                break;
            case "Right":
                myHero.setHeroWpnRight(this);
                break;
            case "TwoHand":
                myHero.setHeroWpnTwoHand(this);
                //special case here, can't carry two weapons or more
                myHero.setHeroWpnLeft(null);
                myHero.setHeroWpnRight(null);
                break;
            default:
                break;
        }
         System.out.println("Your new weapon is equipped now.");
        return true;
    }

    //how many damage can we make?
    public double calculateDPS(double primAttr){
        double dpsValue = 0;

        dpsValue = (this.wpnDmg * this.wpnSpeed) * (1 + (primAttr/100));

        System.out.println("Your current DPS is: " + dpsValue);
        System.out.println("--------------------------------------");

        return dpsValue;
    }


}
