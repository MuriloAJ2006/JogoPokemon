package game.modelos.golpes;
import game.modelos.Pokemon;
import game.modelos.TipoElemento;

public abstract class Golpe {
    
    // ATRIBUTOS
    private String nome;
    private String descricao;
    private TipoElemento tipo;
    private int ppMax;
    private int ppNow;
    
    // =======================================================

    // CONSTRUTOR
    public Golpe(String nome, String descricao,
                  TipoElemento tipo, int ppMax) {
        
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
        this.ppMax = ppMax;
        this.ppNow = ppMax;
        
    } // FIM DO CONSTRUTOR

    // =======================================================

    // GETTERS E SETTERS
    // Nome do Golpe
    public String getNome() {return this.nome;}
    public void setNome(String nome) {this.nome = nome;}
    
    // Descricao do Golpe
    public String getDescricao() {return this.descricao;}
    public void setDescricao(String descricao) {this.descricao = descricao;}
    
    // Tipo do Golpe
    public TipoElemento getTipo() {return this.tipo;}
    public void setTipo (TipoElemento tipo) {this.tipo = tipo;}
    
    // PP Maximo do Golpe
    public int getPPMax() {return this.ppMax;}
    public void setPPMax(int ppMax) {this.ppMax = ppMax;}
    
    // PP Atual do Golpe
    public int getPPNow() {return this.ppNow;}
    public void setPPNow(int ppNow) {this.ppNow = ppNow;}
    
    // =======================================================

    // METODO ABSTRATO
    // Ha varios tipos de golpes (dano, buffs/debuffs, clima, etc.)
    public abstract void executar(Pokemon atacante, Pokemon defensor);
    
    // =======================================================
    
} // FIM DA CLASSE
