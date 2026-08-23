package game.jogopokemon;
import game.modelos.Pokemon;

public class JogoPokemon {

    public static void main(String[] args) {
        
        System.out.println("===== INICIANDO O JOGO =====");
        
        // Nome, Nivel, HP Maximo, Velocidade,
        // Ataque, Ataque Especial, Defesa, Defesa Especial
        Pokemon meuPokemon = new Pokemon("Charizard", 40, 78, 100, 84, 109, 78, 85);
        
        System.out.println("Um " + meuPokemon.getName() + " apareceu!");
        System.out.println("Nivel: " + meuPokemon.getLevel());
        System.out.println("HP: " + meuPokemon.getHPNow() + "/" + meuPokemon.getHPMax());
        System.out.println("Fainted?: " + meuPokemon.isDesmaiado());
        
        System.out.println("\n===== SIMULANDO UM ATAQUE =====");
        
        // Testando o receber dano
        System.out.println(meuPokemon.getName() + " tomou 15 de dano!");
        meuPokemon.receberDano(15);
        System.out.println("HP: " + meuPokemon.getHPNow() + "/" + meuPokemon.getHPMax());
        System.out.println("Fainted?: " + meuPokemon.isDesmaiado() + "\n");

        // Testando receber reviver (desmaiado false)
        System.out.println("Utilizando reviver (30% HP Max)");
        meuPokemon.curarRevive(30);
        System.out.println("HP: " + meuPokemon.getHPNow() + "/" + meuPokemon.getHPMax());
        System.out.println("Fainted?: " + meuPokemon.isDesmaiado() + "\n");
        
        // Testando receber pocao (desmaiado false)
        System.out.println("Utilizando pocao (+20 HP)");
        meuPokemon.curarPocao(20);
        System.out.println("HP: " + meuPokemon.getHPNow() + "/" + meuPokemon.getHPMax());
        System.out.println("Fainted?: " + meuPokemon.isDesmaiado() + "\n");

        // Testando o receber dano (crítico)
        System.out.println(meuPokemon.getName() + " tomou 100 de dano!");
        meuPokemon.receberDano(100);
        System.out.println("HP: " + meuPokemon.getHPNow() + "/" + meuPokemon.getHPMax());
        System.out.println("Fainted?: " + meuPokemon.isDesmaiado() + "\n");
        
        // Testando receber pocao (desmaiado true)
        System.out.println("Utilizando super pocao (+60 HP)");
        meuPokemon.curarPocao(60);
        System.out.println("HP: " + meuPokemon.getHPNow() + "/" + meuPokemon.getHPMax());
        System.out.println("Fainted?: " + meuPokemon.isDesmaiado() + "\n");
        
        // Testando receber reviver (desmaiado false)
        System.out.println("Utilizando reviver (30% HP Max)");
        meuPokemon.curarRevive(30);
        System.out.println("HP: " + meuPokemon.getHPNow() + "/" + meuPokemon.getHPMax());
        System.out.println("Fainted?: " + meuPokemon.isDesmaiado() + "\n");
        
    } // FIM DA MAIN
    
} // FIM DA CLASSE