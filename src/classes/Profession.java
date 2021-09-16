package src.classes;

public class Profession {
    //the basics
    private String profName;
    private int[] profUp;

    //base values
    private int baseVit;
    private int baseStr;
    private int baseDex;
    private int baseInt;

    //total values
    private int totalVit;
    private int totalStr;
    private int totalDex;
    private int totalInt;

    //what the class can use
    private String[] profWpnAllowed;
    private String[] profArmAllowed;

    /**
     * getter and setter section
     */
    public String[] getProfWpnAllowed() {
        return profWpnAllowed;
    }

    public String[] getProfArmAllowed() {
        return profArmAllowed;
    }

    public int getTotalVit() {
        return totalVit;
    }

    public int getTotalStr() {
        return totalStr;
    }

    public int getTotalDex() {
        return totalDex;
    }

    public int getTotalInt() {
        return totalInt;
    }

    /**
     * Constructor
     */

    public Profession(String profName) {
        this.profName = profName;

        /**
         * Default settings per class
         */
        switch (profName){
            case "Mage":
                this.baseVit = 5;
                this.baseStr = 1;
                this.baseDex = 1;
                this.baseInt = 8;
                this.profUp = new int[]{3, 1, 1, 5};
                this.profWpnAllowed = new String[]{"Staff", "Wand"};
                this.profArmAllowed = new String[]{"Cloth"};
                break;
            case "Hunter":
                this.baseVit = 8;
                this.baseStr = 1;
                this.baseDex = 7;
                this.baseInt = 1;
                this.profUp = new int[]{2, 1, 5, 1};
                this.profWpnAllowed = new String[]{"Bow"};
                this.profArmAllowed = new String[]{"Leather", "Mail"};
                break;
            case "Rogue":
                this.baseVit = 8;
                this.baseStr = 2;
                this.baseDex = 6;
                this.baseInt = 1;
                this.profUp = new int[]{3, 1, 4, 1};
                this.profWpnAllowed = new String[]{"Dagger", "Sword"};
                this.profArmAllowed = new String[]{"Leather", "Mail"};
                break;
            case "Warrior":
                this.baseVit = 10;
                this.baseStr = 5;
                this.baseDex = 2;
                this.baseInt = 1;
                this.profUp = new int[]{5, 3, 2, 1};
                this.profWpnAllowed = new String[]{"Axe", "Hammer", "Sword"};
                this.profArmAllowed = new String[]{"Mail", "Plate"};
                break;
            default:
                System.out.println("Class not known. Choose between Mage, Hunter, Rogue or Warrior");
                break;
        }

        //make first total calculation
        levelUp(0, new int[]{0, 0, 0, 0});
    }

    /**
     * function section
     */

    public void levelUp(int newLevel, int[] armorValues) {

        this.totalVit = this.baseVit + (newLevel * profUp[0]) + armorValues[0];
        this.totalStr = this.baseStr + (newLevel * profUp[1]) + armorValues[1];
        this.totalDex = this.baseDex + (newLevel * profUp[2]) + armorValues[2];
        this.totalInt = this.baseInt + (newLevel * profUp[3]) + armorValues[3];

    }



}




