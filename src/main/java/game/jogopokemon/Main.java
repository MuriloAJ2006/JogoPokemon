package game.jogopokemon;

import game.database.PokemonDatabase;
import game.modelos.enums.Nature;
import game.modelos.golpes.Move;
import game.modelos.pokemon.Pokemon;
import game.modelos.pokemon.PokemonSpecies;
import game.modelos.pokemon.StatsBlock;
import game.modelos.pokemon.MoveSet.MoveSlot; 
import game.mecanicas.progresso.FormulaUtils;

public class Main {
    public static void main(String[] args) {
        
        System.out.println("Iniciando o sistema...");
        
        // 1. Carregamos as espécies e os golpes na memória
        PokemonDatabase.getInstance().carregarPokemon();
        PokemonDatabase.getInstance().carregarGolpes();

        // 2. Buscamos as plantas (moldes) no banco
        PokemonSpecies moldeBulbasaur = PokemonDatabase.getInstance().getEspecie("Bulbasaur");
        Move tackle = PokemonDatabase.getInstance().getGolpe("Tackle");
        Move growl = PokemonDatabase.getInstance().getGolpe("Growl");
        Move vineWhip = PokemonDatabase.getInstance().getGolpe("Vine Whip");

        // 3. Criamos o Brutus e calculamos seus status
        StatsBlock ivs = new StatsBlock(31, 31, 31, 31, 31, 31);
        Pokemon meuIniciante = new Pokemon(moldeBulbasaur, 5, ivs, false, Nature.MODEST);
        meuIniciante.setNickname("Brutus");
        
        StatsBlock statusCalculados = FormulaUtils.calcStatusFinais(meuIniciante);
        meuIniciante.getStats().updateActualStats(statusCalculados);

        // 4. Ensinamos os ataques para o Brutus (Slots de 0 a 3)
        meuIniciante.getMoves().learnMove(0, tackle);
        meuIniciante.getMoves().learnMove(1, growl);
        meuIniciante.getMoves().learnMove(2, vineWhip);

        // 5. Imprimimos o relatório completo de Status e Golpes!
        System.out.println("\n==================================");
        System.out.println("POKEMON: " + meuIniciante.getDisplayName() + " (Nv. " + meuIniciante.getStats().getLevel() + ")");
        System.out.println("NATURE: " + meuIniciante.getNature());
        System.out.println("==================================");
        System.out.println("HP Max:     " + meuIniciante.getStats().getActualStats().getHp());
        System.out.println("Attack:     " + meuIniciante.getStats().getActualStats().getAttack());
        System.out.println("Defense:    " + meuIniciante.getStats().getActualStats().getDefense());
        System.out.println("Sp. Attack: " + meuIniciante.getStats().getActualStats().getSpAttack());
        System.out.println("Sp. Defense:" + meuIniciante.getStats().getActualStats().getSpDefense());
        System.out.println("Speed:      " + meuIniciante.getStats().getActualStats().getSpeed());
        System.out.println("==================================");
        System.out.println("ATAQUES APRENDIDOS:");
        
        // Loop para imprimir apenas os slots que possuem ataques
        MoveSlot[] slots = meuIniciante.getMoves().getSlots();
        for (int i = 0; i < slots.length; i++) {
            if (slots[i] != null) {
                Move golpe = slots[i].getMove();
                System.out.println("- " + golpe.getName() + " [" + golpe.getType() + "] PP: " + slots[i].getCurrentPP() + "/" + golpe.getTotalPP());
            } else {
                System.out.println("- [Espaco Vazio]");
            }
        }
        System.out.println("==================================");
    }
}