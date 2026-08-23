package game.modelos.itens;

import game.modelos.Pokemon;

public abstract class Item {
    
    // ATRIBUTOS
    private String nome;
    private String descricao;
    
    // =======================================================

    // CONSTRUTOR
    public Item(String nome, String descricao) {
        
        this.nome = nome;
        this.descricao = descricao;
        
    } // FIM DO CONSTRUTOR

    // =======================================================

    // GETTERS E SETTERS
    // Nome do Item
    public String getNome() {return this.nome;}
    public void setNome(String nome) {this.nome = nome;}
    
    // Descricao do Item
    public String getDescricao() {return this.descricao;}
    public void setDescricao(String descricao) {this.descricao = descricao;}
    
    // =======================================================

    // METODO ABSTRATO
    // Os itens podem ser usados de maneiras diferentes.
    public abstract void usar(Pokemon alvo);
    
    // =======================================================
    
} // FIM DA CLASSE
