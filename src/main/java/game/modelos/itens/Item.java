package game.modelos.itens;
import game.modelos.pokemon.Pokemon;

public abstract class Item {
    
    // ATRIBUTOS
    private String nome;
    private String descricao;
    private ItemCategory categoria;
    private int quantidade;
    private int limiteStack;
    private boolean consumivel;
    
    // =======================================================

    // CONSTRUTOR
    public Item(String nome, String descricao, ItemCategory categoria,
                int quantidade, int limiteStack, boolean consumivel) {
        
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.limiteStack = limiteStack;
        this.consumivel = consumivel;
        
    } // FIM DO CONSTRUTOR

    // =======================================================

    // GETTERS E SETTERS
    // Nome do Item
    public String getNome() {return this.nome;}
    public void setNome(String nome) {this.nome = nome;}
    
    // Descricao do Item
    public String getDescricao() {return this.descricao;}
    public void setDescricao(String descricao) {this.descricao = descricao;}
    
    // Categoria do Item
    public ItemCategory getCategoria() {return this.categoria;}
    public void setCategoria(ItemCategory categoria) {this.categoria = categoria;}
    
    // Quantidade do Item
    public int getQuantidade() {return this.quantidade;}
    public void setQuantidade(int quantidade) {this.quantidade = quantidade;}
    
    // Limite de Itens por Stack
    public int getLimiteStack() {return this.limiteStack;}
    public void setLimiteStack(int limiteStack) {this.limiteStack = limiteStack;}
    
    // Se o Item eh Consumivel
    public boolean isConsumivel() {return this.consumivel;}
    public void setConsumivel(boolean consumivel) {this.consumivel = consumivel;}
    
    // =======================================================

    // METODO ABSTRATO
    // Os itens podem ser usados de maneiras diferentes.
    public abstract void usar(Pokemon alvo);
    
    // Todo item filho deve retornar uma copia de si mesmo.
    public abstract Item clonar();
    
    // =======================================================
    
} // FIM DA CLASSE
