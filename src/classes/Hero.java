package src.classes;

public class Hero {

    //basics
    private String heroName;
    private String heroClass;
    private int heroLvl = 1 ;

    //armor
    private Armor heroBody;
    private Armor heroHead;
    private Armor heroLegs;
    private Armor heroFeet;

    //weapons
    private Weapon heroWpnLeft;
    private Weapon heroWpnRight;
    private Weapon heroWpnTwoHand;

    /**
     * Constructor
     */
    public Hero(String heroName, String heroClass) {
        this.heroName = heroName;
        this.heroClass = heroClass;

        //no nacked ones here
        this.heroHead = new Armor("Loin hood",0, "Head", "", new int[]{0,0,0,0});
        this.heroBody = new Armor("Loin shirt",0, "Body", "", new int[]{0,0,0,0});
        this.heroLegs = new Armor("Loin trouser",0, "Legs", "", new int[]{0,0,0,0});
        this.heroFeet = new Armor("Loin slipper",0, "Feet", "", new int[]{0,0,0,0});
    }


    /**
     * Getter, setter section
     */

    public void setHeroLvl(int heroLvl) {
        this.heroLvl = heroLvl;
    }

    public String getHeroName() {
        return heroName;
    }

    public String getHeroClass() {
        return heroClass;
    }

    public int getHeroLvl() {
        return heroLvl;
    }

    public void setHeroBody(Armor heroBody) {
        this.heroBody = heroBody;
    }

    public void setHeroHead(Armor heroHead) {
        this.heroHead = heroHead;
    }


    public void setHeroLegs(Armor heroLegs) {
        this.heroLegs = heroLegs;
    }


    public void setHeroFeet(Armor heroFeet) {
        this.heroFeet = heroFeet;
    }


    public void setHeroWpnLeft(Weapon heroWpnLeft) {
        this.heroWpnLeft = heroWpnLeft;
    }


    public void setHeroWpnRight(Weapon heroWpnRight) {
        this.heroWpnRight = heroWpnRight;
    }


    public void setHeroWpnTwoHand(Weapon heroWpnTwoHand) {
        this.heroWpnTwoHand = heroWpnTwoHand;
    }

    /**
     * functions section
     */

    public int[] calculateArmorValues(){

        int[] totalArmor = new int[]{0,0,0,0};
        int[] headArmor = this.heroHead.getArmAttr();
        int[] bodyArmor = this.heroBody.getArmAttr();
        int[] legsArmor = this.heroBody.getArmAttr();
        int[] feedArmor = this.heroBody.getArmAttr();

       for( int i=0; i<4; i++){
           totalArmor[i] = headArmor[i] + bodyArmor[i] + legsArmor[i] + feedArmor[i];
        }
        return totalArmor;

    }

}

