package game.jogopokemon;
import game.modelos.Pokemon;
import game.modelos.TipoElemento;

public class JogoPokemon {

    public static void main(String[] args) {
        
        System.out.println("===== INICIANDO O JOGO =====");
        
        // Nome, Nivel, HP Maximo, Velocidade,
        // Ataque, Ataque Especial, Defesa, Defesa Especial
        Pokemon pokemon4 = new Pokemon("Charmander", 10, 39, 65, 52, 60, 43, 50, TipoElemento.FOGO);
        Pokemon pokemon6 = new Pokemon("Charizard", 40, 78, 100, 84, 109, 78, 85, TipoElemento.FOGO, TipoElemento.VOADOR);
        
        System.out.println("Um " + pokemon6.getName() + " apareceu!");
        System.out.print("Tipo(s): " + pokemon6.getTipo1());
        if(pokemon6.getTipo2() == TipoElemento.NENHUM) {
            System.out.println("");
        } else {
            System.out.println(" | " + pokemon6.getTipo2());
        } // FIM DO IF-ELSE
        System.out.println("Nivel: " + pokemon6.getLevel());
        System.out.println("HP: " + pokemon6.getHPNow() + "/" + pokemon6.getHPMax());
        System.out.println("Fainted?: " + pokemon6.isDesmaiado());
        
        System.out.println("Um " + pokemon4.getName() + " apareceu!");
        System.out.print("Tipo(s): " + pokemon4.getTipo1());
        if(pokemon4.getTipo2() == TipoElemento.NENHUM) {
            System.out.println("");
        } else {
            System.out.println(" | " + pokemon4.getTipo2());
        } // FIM DO IF-ELSE
        System.out.println("Nivel: " + pokemon4.getLevel());
        System.out.println("HP: " + pokemon4.getHPNow() + "/" + pokemon4.getHPMax());
        System.out.println("Fainted?: " + pokemon4.isDesmaiado());
        
        System.out.println("\n===== SIMULANDO UM ATAQUE =====");
        
        // Testando o receber dano
        System.out.println(pokemon6.getName() + " tomou 15 de dano!");
        pokemon6.receberDano(15);
        System.out.println("HP: " + pokemon6.getHPNow() + "/" + pokemon6.getHPMax());
        System.out.println("Fainted?: " + pokemon6.isDesmaiado() + "\n");

        // Testando receber reviver (desmaiado false)
        System.out.println("Utilizando reviver (30% HP Max)");
        pokemon6.curarRevive(30);
        System.out.println("HP: " + pokemon6.getHPNow() + "/" + pokemon6.getHPMax());
        System.out.println("Fainted?: " + pokemon6.isDesmaiado() + "\n");
        
        // Testando receber pocao (desmaiado false)
        System.out.println("Utilizando pocao (+20 HP)");
        pokemon6.curarPocao(20);
        System.out.println("HP: " + pokemon6.getHPNow() + "/" + pokemon6.getHPMax());
        System.out.println("Fainted?: " + pokemon6.isDesmaiado() + "\n");

        // Testando o receber dano (crítico)
        System.out.println(pokemon6.getName() + " tomou 100 de dano!");
        pokemon6.receberDano(100);
        System.out.println("HP: " + pokemon6.getHPNow() + "/" + pokemon6.getHPMax());
        System.out.println("Fainted?: " + pokemon6.isDesmaiado() + "\n");
        
        // Testando receber pocao (desmaiado true)
        System.out.println("Utilizando super pocao (+60 HP)");
        pokemon6.curarPocao(60);
        System.out.println("HP: " + pokemon6.getHPNow() + "/" + pokemon6.getHPMax());
        System.out.println("Fainted?: " + pokemon6.isDesmaiado() + "\n");
        
        // Testando receber reviver (desmaiado false)
        System.out.println("Utilizando reviver (30% HP Max)");
        pokemon6.curarRevive(30);
        System.out.println("HP: " + pokemon6.getHPNow() + "/" + pokemon6.getHPMax());
        System.out.println("Fainted?: " + pokemon6.isDesmaiado() + "\n");
        
    } // FIM DA MAIN
    
} // FIM DA CLASSE