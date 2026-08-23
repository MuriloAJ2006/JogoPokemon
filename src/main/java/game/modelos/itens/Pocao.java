package game.modelos.itens;
import game.modelos.Pokemon;

public class Pocao extends Item {
    
    // ATRIBUTOS ESPECIFICOS
    private int poderCura;
    
    // =======================================================
    
    // CONSTRUTOR
    public Pocao(String nome, String descricao, int poderCura) {
        
        super(nome, descricao);
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
    
    // =======================================================
    
} // FIM DA CLASSE
