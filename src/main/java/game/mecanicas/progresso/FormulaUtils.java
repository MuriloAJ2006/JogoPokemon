package game.mecanicas.progresso;

import game.modelos.enums.Nature;
import game.modelos.pokemon.Pokemon;
import game.modelos.pokemon.PokemonSpecies;
import game.modelos.pokemon.StatsBlock;

public class FormulaUtils {
    
    private FormulaUtils () {}
    
    public static StatsBlock calcStatusFinais(Pokemon pokemon) {
        
        PokemonSpecies especie = pokemon.getSpecies();
        int level = pokemon.getStats().getLevel();
        StatsBlock ivs = pokemon.getStats().getIvs();
        StatsBlock evs = pokemon.getStats().getEvs();
        Nature nature = pokemon.getNature();
        
        int hp = ((2 * especie.getBaseHP() + ivs.getHp() + (evs.getHp() / 4)) * level) / 100 + level + 10;
        int attack = calcStatBase(especie.getBaseAttack(), ivs.getAttack(), evs.getAttack(), level, nature.getMultiplier(Nature.CoreStat.ATTACK));
        int defense = calcStatBase(especie.getBaseDefense(), ivs.getDefense(), evs.getDefense(), level, nature.getMultiplier(Nature.CoreStat.DEFENSE));
        int spAttack = calcStatBase(especie.getBaseSpAttack(), ivs.getSpAttack(), evs.getSpAttack(), level, nature.getMultiplier(Nature.CoreStat.SP_ATTACK));
        int spDefense = calcStatBase(especie.getBaseSpDefense(), ivs.getSpDefense(), evs.getSpDefense(), level, nature.getMultiplier(Nature.CoreStat.SP_DEFENSE));
        int speed = calcStatBase(especie.getBaseSpeed(), ivs.getSpeed(), evs.getSpeed(), level, nature.getMultiplier(Nature.CoreStat.SPEED));
        
        return new StatsBlock(hp, attack, defense, spAttack, spDefense, speed);
    
    } // FIM DO CALCULO FINAL
    
    private static int calcStatBase(int base, int iv, int ev, int level, double natureMultiplier) {
        
        int calcBase = ((2 * base + iv + (ev / 4)) * level) / 100 + 5;
        return (int) (calcBase * natureMultiplier);
        
    } // FIM DO CALCULO BASICO
    
} // FIM DA CLASSE
