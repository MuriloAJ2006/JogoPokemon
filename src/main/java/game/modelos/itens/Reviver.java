package game.modelos.itens;
import game.modelos.Pokemon;

public class Reviver extends Item {
    
    // ATRIBUTOS ESPECIFICOS
    private int porcentagemCura;
    
    // =======================================================
    
    // CONSTRUTOR
    public Reviver(String nome, String descricao, int porcentagemCura) {
        
        super(nome, descricao);
        this.porcentagemCura = porcentagemCura;
        
    } // FIM DO CONSTRUTOR
    
    // =======================================================
    
    // GETTERS E SETTERS
    public int getPorcentagemCura() {return this.porcentagemCura;}
    public void setPorcentagemCura(int porcentagemCura) {this.porcentagemCura = porcentagemCura;}
    
    // =======================================================
    
    // METODOS SOBRESCRITOS
    @Override
    public void usar(Pokemon alvo) {
        
        System.out.println("Usando " + this.getNome() + " em " + alvo.getName() + ".");
        alvo.curarReviver(this.getPorcentagemCura());
        
    } // FIM DO USAR POCAO
    
    // =======================================================
    
} // FIM DA CLASSE