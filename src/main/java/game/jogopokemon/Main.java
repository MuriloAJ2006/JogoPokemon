package game.jogopokemon;

import game.database.PokemonDatabase;
import game.modelos.pokemon.Pokemon;
import game.modelos.pokemon.PokemonSpecies;
import game.modelos.pokemon.StatsBlock;

public class Main {
    public static void main(String[] args) {
        
        System.out.println("Iniciando o sistema...");

        // 1. Apenas mandamos o Banco de Dados se carregar!
        PokemonDatabase.getInstance().carregarDados();

        // 2. Sempre que precisarmos de um Pokémon no jogo, fazemos um pedido simples:
        PokemonSpecies moldePikachu = PokemonDatabase.getInstance().getEspecie("Pikachu");
        PokemonSpecies moldeBulbasaur = PokemonDatabase.getInstance().getEspecie("Bulbasaur");

        // 3. Vamos provar que funcionou criando o Bulbasaur!
        StatsBlock ivs = new StatsBlock(31, 31, 31, 31, 31, 31);
        Pokemon meuIniciante = new Pokemon(moldeBulbasaur, 5, ivs, false);
        
        System.out.println("\nPokemon invocado: " + meuIniciante.getDisplayName());
        System.out.print("Tipo: " + meuIniciante.getSpecies().getPrimaryType());
        if (meuIniciante.getSpecies().hasSecondaryType()) {
            System.out.println(" / " + meuIniciante.getSpecies().getSecondaryType());
        }
    }
}