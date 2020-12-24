package homework5;

public enum Animal {
    DOG(false,4,true),
    CAT(false, 4,true),
    PARROT(true,2,false),
    RABBIT(false,4,true);

    private final boolean canFly;
    private final int numberOfLegs;
    private final boolean hasFur;

    Animal(boolean canFly, int numberOfLegs, boolean hasFur){
        this.canFly = canFly;
        this.numberOfLegs = numberOfLegs;
        this.hasFur = hasFur;
    }
    public boolean getCanFly(){ return this.canFly;}
    public int getNumberOfLegs(){ return this.numberOfLegs;}
    public boolean getHasFur(){ return this.hasFur;}


}
