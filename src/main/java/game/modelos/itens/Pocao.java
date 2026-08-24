package game.modelos.itens;
import game.modelos.Pokemon;

public class Pocao extends Item {
    
    // ATRIBUTOS ESPECIFICOS
    private int poderCura;
    
    // =======================================================
    
    // CONSTRUTOR
    public Pocao(String nome, String descricao, int poderCura, int quantidade) {
        
        super(nome, descricao, CategoriaItem.MEDICINES, quantidade, 999, true);
        this.poderCura = poderCura;
        
    } // FIM DO CONSTRUTOR
    
    // =======================================================
    
    // GETTERS E SETTERS
    public int getPoderCura() {return this.poderCura;}
    public void setPoderCura(int poderCura) {this.poderCura = poderCura;}
    
    // =======================================================
    
    // METODOS SOBRESCRITOS
    @Override
    public void usar(Pokemon alvo) {
        
        System.out.println("Usando " + this.getNome() + " em " + alvo.getName() + ".");
        alvo.curarPocao(this.getPoderCura());
        
    } // FIM DO USAR POCAO
    
    @Override
    public Item clonar() {
        
        return new Pocao(this.getNome(), this.getDescricao(), this.poderCura, this.getQuantidade());
        
    } // FIM DA CLONAGEM DO ITEM
    
    // =======================================================
    
} // FIM DA CLASSE
