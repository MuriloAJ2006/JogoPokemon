package game.modelos;
import game.modelos.itens.Item;
import game.modelos.golpes.Golpe;
import java.util.Scanner;

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
    private Item itemSegurado;
    private Golpe[] golpes;
    
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
        this.golpes = new Golpe[4];
        
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
        this.golpes = new Golpe[4];
        
        // Faz com que o segundo tipo seja "Nulo".
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
    
    // Item segurado pelo Pokemon (SOMENTE GETTER)
    public Item getItemSegurado() {return this.itemSegurado;}
    
    // Golpes do Pokemon
    public Golpe getGolpe(int slot) {
        
        if (slot < 0 || slot > 3) {
            return null;
        } // FIM DO IF
        
        return this.golpes[slot];
        
    } // FIM DO GETTER DE GOLPES
    
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

    public void curarReviver(int porcentagemCura) {
        
        // Se o pokemon nao desmaiou, nao revive.
        if (this.getHPNow() > 0) {
            System.out.println(this.getName() + " ja esta acordado! Nao foi possivel utilizar o reviver.");
            return;
        } // FIM DO IF
        
        // Revive o pokemon desmaido.
        this.setHPNow((this.getHPMax()*porcentagemCura)/100);
        this.setDesmaiado(false);
        
    } // FIM DO CURAR COM REVIVER
    
    // -------------------------------------------------------
    
    public void darSegurar(Item item) {
        
        // Verifica se o Pokemon ja esta segurando um item.
        if (this.getItemSegurado() != null) {
            System.out.println(this.getName() + " ja esta segurando " + this.getItemSegurado().getNome() + "!");
            return;
        } // FIM DO IF
        
        // Dah o item para o Pokemon segurar.
        this.itemSegurado = item;
        System.out.println(this.getName() + " agora esta segurando " + this.getItemSegurado().getNome() + ".");
        
    } // FIM DO DAR ITEM PARA O POKEMON SEGURAR
    
    // -------------------------------------------------------
    
    public Item pegarSegurar () {
        
        // Verifica se o Pokemon tem algum item.
        if (this.getItemSegurado() == null) {
            System.out.println(this.getName() + " nao esta segurando nenhum item.");
            return null;
        } // FIM DO IF
        
        // Guarda o item numa variavel temporaria,
        // esvazia a mao e devolve o item.
        Item itemDevolvido = this.getItemSegurado();
        this.itemSegurado = null;
        System.out.println("Voce pegou " + itemDevolvido.getNome() + " de " + this.getName() + ".");
        return itemDevolvido;
        
    } // FIM DO PEGAR ITEM SEGURADO PELO POKEMON
    
    // -------------------------------------------------------
    
    public boolean aprenderGolpe(Golpe novoGolpe) {
        
        for (int i = 0; i < this.golpes.length; i++) {
            
            // Percorre os 4 slots buscando um espaco vazio.
            if (this.golpes[i] == null){
                this.golpes[i] = novoGolpe;
                System.out.println(this.getName() + " aprendeu " + novoGolpe.getNome() + ".");
                return true;     // Impede a execucao do restante do metodo.
            } // FIM DO IF
            
        } // FIM DO FOR
        
        return false;
        
    } // FIM DO APRENDER GOLPE
    
    // -------------------------------------------------------
    
    public void substituirGolpe(int slot, Golpe novoGolpe) {
        if (slot < 0 || slot > 3) {
            System.out.println("Erro do sistema: Tentativa de acessar slot inexistente!");
            return;
        } // FIM DO IF
        
        Golpe golpeEsquecido = this.golpes[slot];
        this.golpes[slot] = novoGolpe;
        
        System.out.println("1, 2 e... Poof!");
        System.out.println(this.getName() + " esqueceu " + golpeEsquecido.getNome() + ".");
        System.out.println("E... " + this.getName() + " aprendeu " + novoGolpe.getNome() + "!");
        
    } // FIM DO SUBSTITUIR GOLPE
    
    // -------------------------------------------------------
    
    public void usarGolpe(int slot, Pokemon alvo) {
        
        if (slot < 0 || slot > 3) {
            System.out.println("Erro do sistema: Tentativa de acessar slot inexistente!");
            return;
        } // FIM DO IF
        
        Golpe golpeEscolhido = this.golpes[slot];
        golpeEscolhido.executar(this, alvo);
        
    } // FIM DO USAR GOLPE
    
    // =======================================================

} // FIM DA CLASSE