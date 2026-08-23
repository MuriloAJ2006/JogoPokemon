package game.modelos.golpes;
import game.modelos.Pokemon;
import game.modelos.TipoElemento;

public class GolpeDano extends Golpe{
    
    // ATRIBUTOS
    private int dano;
    
    // =======================================================

    // CONSTRUTOR
    public GolpeDano(String nome, String descricao,
                  TipoElemento tipo, int ppMax, int dano) {
        
        super(nome, descricao, tipo, ppMax);
        this.dano = dano;
        
    } // FIM DO CONSTRUTOR

    // =======================================================

    // GETTERS E SETTERS
    // Dano do Golpe
    public int getDano() {return this.dano;}
    public void setDano(int dano) {this.dano = dano;}
    
    // =======================================================

    // METODO ABSTRATO
    // Os itens podem ser usados de maneiras diferentes.
    @Override
    public void executar(Pokemon atacante, Pokemon defensor){
        
        System.out.println("\n" + atacante.getName() + " usou " + this.getNome() + "!");
        
        // Verifica se tem PP suficiente
        if (this.getPPNow() <= 0) {
            System.out.println("Mas falhou! Nao tem mais PP para este ataque.");
            return;
        } // FIM DO IF
        
        // Consome 1 PP
        this.setPPNow(this.getPPNow() - 1);
        
        // Calcula o dano (PROVISORIO)
        int danoCausado = this.dano + (atacante.getAtack() / 10);
        
        // Aplica o dano ao defensor
        defensor.receberDano(danoCausado);
        System.out.println("Causou " + danoCausado + " de dano!");
        
    } // FIM DO EXECUTAR DANO
    
    // =======================================================
    
} // FIM DA CLASSE
