package game.modelos.pokemon;

public class StatsBlock {
    
    // ATRIBUTOS:
    // ======================================
    private int hp;
    private int attack;
    private int defense;
    private int spAttack;
    private int spDefense;
    private int speed;
    // ======================================
    
    // CONSTRUTOR:
    // ======================================
    public StatsBlock() {
        
        this.hp = 0;
        this.attack = 0;
        this.defense = 0;
        this.spAttack = 0;
        this.spDefense = 0;
        this.speed = 0;
        
    } // FIM DO CONSTRUTOR
    // --------------------------------------
    public StatsBlock(int hp, int atk, int def, int spA, int spD, int spe) {
        
        this.hp = hp;
        this.attack = atk;
        this.defense = def;
        this.spAttack = spA;
        this.spDefense = spD;
        this.speed = spe;
    
    } // FIM DO CONSTRUTOR
    // ======================================
    
    // GETTERS E SETTERS:
    // ======================================
    public int getHp() {return hp;}
    public void setHp(int hp) {this.hp = hp;}
    
    public int getAttack() {return attack;}
    public void setAttack(int attack) {this.attack = attack;}
    
    public int getDefense() {return defense;}
    public void setDefense(int defense) {this.defense = defense;}
    
    public int getSpAttack() {return spAttack;}
    public void setSpAttack(int spAttack) {this.spAttack = spAttack;}
    
    public int getSpDefense() {return spDefense;}
    public void setSpDefense(int spDefense) {this.spDefense = spDefense;}
    
    public int getSpeed() {return speed;}
    public void setSpeed(int speed) {this.speed = speed;}
    // ======================================
    
} // FIM DA CLASSE