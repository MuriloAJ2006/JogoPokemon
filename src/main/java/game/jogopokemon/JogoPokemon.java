package game.jogopokemon;
import game.modelos.Pokemon;
import game.modelos.TipoElemento;
//import game.modelos.itens.*;
import game.modelos.golpes.*;

public class JogoPokemon {

    public static void main(String[] args) {
        
        System.out.println("===== INICIANDO O JOGO =====");
        
        // Nome, Nivel, HP Maximo, Velocidade,
        // Ataque, Ataque Especial, Defesa, Defesa Especial
        Pokemon charizard = new Pokemon("Charizard",40,78,100,84,109,78,85,TipoElemento.FOGO,TipoElemento.VOADOR);
        Pokemon blastoise = new Pokemon("Blastoise",40,79,78,83,85,100,105,TipoElemento.AGUA);
        
        System.out.println(charizard.getName() + " VS " + blastoise.getName());
        
        System.out.println("===== ENSINANDO GOLPES =====");
        GolpeDano lancaChamas = new GolpeDano("Lanca-Chamas", "Forte ataque de fogo", TipoElemento.FOGO, 15, 90);
        GolpeDano arremessoSismico = new GolpeDano("Arremesso Sismico", "Forte ataque lutador", TipoElemento.LUTADOR, 10, 100);
        
        charizard.aprenderGolpe(lancaChamas);
        charizard.aprenderGolpe(arremessoSismico);
        
        System.out.println("===== FIGHT TIME =====");
        System.out.println("Um " + blastoise.getName() + " apareceu!");
        System.out.println("Nivel: " + blastoise.getLevel() + " | HP: " + blastoise.getHPNow() + "/" + blastoise.getHPMax());
        
        System.out.println("\nVai " + charizard.getName() + "!");
        System.out.println("Nivel: " + charizard.getLevel() + " | HP: " + charizard.getHPNow() + "/" + charizard.getHPMax());
        
        charizard.usarGolpe(1, blastoise);
        
        System.out.println("===== RESULTADS DO TURNO =====");
        System.out.println("Blastoise");
        System.out.println("HP: " + blastoise.getHPNow() + "/" + blastoise.getHPMax());
        
        System.out.println("Charizard");
        System.out.println("HP: " + charizard.getHPNow() + "/" + charizard.getHPMax());
        for (int i = 0; i < 4; i++) {
            if (charizard.getGolpe(i) == null) {
                continue;
            } // FIM DO IF
            System.out.println(charizard.getGolpe(i).getNome() + " | PP: " + charizard.getGolpe(i).getPPNow() + "/" + charizard.getGolpe(i).getPPMax());
        } // FIM DO FOR


        
    } // FIM DA MAIN
    
} // FIM DA CLASSE