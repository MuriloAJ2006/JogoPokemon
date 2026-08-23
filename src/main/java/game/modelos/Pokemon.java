package game.modelos;

public class Pokemon {
    
    // ATRIBUTOS
    private String name;
    private TipoElemento tipo1;
    private TipoElemento tipo2;
    private int level;
    private int hpNow;
    private int hpMax;
    private int speed;
    private int atack;
    private int specAtk;
    private int defense;
    private int specDef;
    private boolean desmaiado;
    
    // =======================================================
    
    // CONSTRUTOR - Pokemon de 2 Tipos
    public Pokemon (String name,int level, int hpMax, int speed,
                    int atack, int specAtk, int defense, int specDef,
                    TipoElemento tipo1, TipoElemento tipo2){
        
        this.name = name;
        this.level = level;
        this.hpNow = hpMax;
        this.hpMax = hpMax;
        this.speed = speed;
        this.atack = atack;
        this.specAtk = specAtk;
        this.defense = defense;
        this.specDef = specDef;
        this.desmaiado = false;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
        
    } // FIM DO CONSTRUTOR
    
    // -------------------------------------------------------

    // CONSTRUTOR - Pokemon de 1 Tipo
    public Pokemon (String name,int level, int hpMax, int speed,
                    int atack, int specAtk, int defense, int specDef,
                    TipoElemento tipo1){
        
        this.name = name;
        this.level = level;
        this.hpNow = hpMax;
        this.hpMax = hpMax;
        this.speed = speed;
        this.atack = atack;
        this.specAtk = specAtk;
        this.defense = defense;
        this.specDef = specDef;
        this.desmaiado = false;
        this.tipo1 = tipo1;
        
        // Faz com que o segundo tipo seja "Nulo"
        this.tipo2 = TipoElemento.NENHUM;
        
    } // FIM DO CONSTRUTOR
    
    // =======================================================

    // GETTERS E SETTERS
    // Nome do Pokemon
    public String getName() {return this.name;}
    public void setName(String name) {this.name = name;}
    
    // Tipos/Elementos do Pokemon
    public TipoElemento getTipo1() {return this.tipo1;}
    public void setTipo1(TipoElemento tipo1) {this.tipo1 = tipo1;}
    public TipoElemento getTipo2() {return this.tipo2;}
    public void setTipo2(TipoElemento tipo2) {this.tipo2 = tipo2;}
    
    // Nivel do Pokemon
    public int getLevel() {return this.level;}
    public void setLevel(int level) {this.level = level;}
    
    // Pontos de Vida Atuais do Pokemon
    public int getHPNow() {return this.hpNow;}
    public void setHPNow(int hpNow) {this.hpNow = hpNow;}
    
    // Pontos de Vida Maximo do Pokemon
    public int getHPMax() {return this.hpMax;}
    public void setHPMax(int hpMax) {this.hpMax = hpMax;}
    
    // Pontos de Velocidade do Pokemon
    public int getSpeed() {return this.speed;}
    public void setSpeed(int speed) {this.speed = speed;}
    
    // Pontos de Ataque Comum do Pokemon
    public int getAtack() {return this.atack;}
    public void setAtack(int atack) {this.atack = atack;}
    
    // Pontos de Ataque Especial do Pokemon
    public int getSpecAtk() {return this.specAtk;}
    public void setSpecAtk(int specAtk) {this.specAtk = specAtk;}
    
    // Pontos de Defesa Comum do Pokemon
    public int getDefense() {return this.defense;}
    public void setDefense(int defense) {this.defense = defense;}
    
    // Pontos de Defesa Especial do Pokemon
    public int getSpecDef() {return this.specDef;}
    public void setSpecDef(int specDef) {this.specDef = specDef;}
    
    // Pokemon desmaiado
    public boolean isDesmaiado() {return this.desmaiado;}
    public void setDesmaiado(boolean desmaiado) {this.desmaiado = desmaiado;}
    
    // =======================================================

    // METODOS
    public void receberDano(int dano) {
        
        // Reduz o HP do pokemon.
        this.setHPNow(this.getHPNow() - dano);
        
        // Se a reducao resultar em negativo, deixa em zero.
        if (this.getHPNow() < 0) {
            this.setHPNow(0);
            this.setDesmaiado(true);
        } // FIM DO IF
        
    } // FIM DO RECEBER DANO
    
    // -------------------------------------------------------
    
    public void curarPocao(int quantidade) {
        
        // Se o pokemon desmaiou, nao eh possivel usar pocao.
        if (this.getHPNow() <= 0) {
            System.out.println(this.getName() + " esta desmaiado! Nao foi possivel utilizar a pocao.");
            return;
        } // FIM DO IF
        
        // Cura o pokemon.
        this.setHPNow(this.getHPNow() + quantidade);
        
        // Se o HP atual ultrapassa o max, reduz para o max.
        if (this.getHPNow() > this.getHPMax()) {
            this.setHPNow(this.getHPMax());
        } // FIM DO IF
        
    } // FIM DO CURAR COM POCAO
    
    // -------------------------------------------------------

    public void curarRevive(int porcentagemCura) {
        
        // Se o pokemon nao desmaiou, nao revive
        if (this.getHPNow() > 0) {
            System.out.println(this.getName() + " ja esta acordado! Nao foi possivel utilizar o reviver.");
            return;
        } // FIM DO IF
        
        // Revive o pokemon desmaido
        this.setHPNow((this.getHPMax()*porcentagemCura)/100);
        this.setDesmaiado(false);
        
    } // FIM DO CURAR COM REVIVER
    
    // =======================================================

} // FIM DA CLASSE