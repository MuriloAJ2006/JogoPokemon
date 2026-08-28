package game.mecanicas.batalha;

import game.modelos.enums.Type;
import game.modelos.pokemon.PokemonSpecies;

public class TypeMachupUtils {
    
    private TypeMachupUtils() {}
    
    public static double getMultiplier(Type attackType, PokemonSpecies defender) {
        
        double multiplier = getSingleMultiplier(attackType, defender.getPrimaryType());
        
        if(defender.hasSecondaryType()) {
            multiplier *= getSingleMultiplier(attackType, defender.getSecondaryType());
        } // FIM DO IF
        
        return multiplier;
        
    } // FIM DO CALCULO DO MULTIPLICADOR/POKEMON
    
    private static double getSingleMultiplier(Type atk, Type def) {
        switch(def){
            
            case NORMAL:
                // Fraco contra...
                if(atk == Type.FIGHTING) return 2.0;
                // Imune contra...
                if(atk == Type.GHOST) return 0.0;
                break;
            case FIGHTING:
                // Fraco contra...
                if(atk == Type.FLYING || atk == Type.PSYCHIC || atk == Type.FAIRY) return 2.0;
                // Resistente contra...
                if(atk == Type.DARK || atk == Type.ROCK || atk == Type.BUG) return 0.5;
                break;
            case FLYING:
                // Fraco contra...
                if(atk == Type.ELECTRIC || atk == Type.ROCK || atk == Type.ICE) return 2.0;
                // Resistente contra...
                if(atk == Type.GRASS || atk == Type.FIGHTING || atk == Type.BUG) return 0.5;
                // Imune contra...
                if(atk == Type.GROUND) return 0.0;
                break;
            case POISON:
                // Fraco contra...
                if(atk == Type.GROUND || atk == Type.PSYCHIC) return 2.0;
                // Resistente contra...
                if(atk == Type.POISON || atk == Type.BUG || atk == Type.FAIRY || atk == Type.FIGHTING || atk == Type.GRASS) return 0.5;
                break;
            case GROUND:
                // Fraco contra...
                if(atk == Type.WATER || atk == Type.GRASS || atk == Type.ICE) return 2.0;
                // Resistente contra...
                if(atk == Type.POISON || atk == Type.ROCK) return 0.5;
                // Imune contra...
                if(atk == Type.ELECTRIC) return 0.0;
                break;
            case ROCK:
                // Fraco contra...
                if(atk == Type.PSYCHIC || atk == Type.FAIRY) return 2.0;
                // Resistente contra...
                if(atk == Type.POISON || atk == Type.NORMAL || atk == Type.FIRE || atk == Type.FLYING) return 0.5;
                break;
            case BUG:
                // Fraco contra...
                if(atk == Type.FIRE || atk == Type.FLYING || atk == Type.ROCK) return 2.0;
                // Resistente contra...
                if(atk == Type.FIGHTING || atk == Type.GRASS || atk == Type.GROUND) return 0.5;
                break;
            case GHOST:
                // Fraco contra...
                if(atk == Type.GHOST || atk == Type.DARK) return 2.0;
                // Resistente contra...
                if(atk == Type.POISON || atk == Type.BUG) return 0.5;
                // Imune contra...
                if(atk == Type.NORMAL || atk == Type.FIGHTING) return 0.0;
                break;
            case STEEL:
                // Fraco contra...
                if(atk == Type.FIRE || atk == Type.GROUND || atk == Type.FIGHTING) return 2.0;
                // Resistente contra...
                if(atk == Type.ICE || atk == Type.NORMAL || atk == Type.GRASS || atk == Type.FLYING || atk == Type.ROCK || atk == Type.PSYCHIC || atk == Type.DRAGON || atk == Type.FAIRY || atk == Type.STEEL || atk == Type.BUG) return 0.5;
                // Imune contra...
                if(atk == Type.POISON) return 0.0;
                break;
            case FIRE:
                // Fraco contra...
                if(atk == Type.WATER || atk == Type.GROUND || atk == Type.ROCK) return 2.0;
                // Resistente contra...
                if(atk == Type.STEEL || atk == Type.FIRE || atk == Type.GRASS || atk == Type.ICE || atk == Type.BUG || atk == Type.FAIRY) return 0.5;
                break;
            case WATER:
                // Fraco contra...
                if(atk == Type.GRASS || atk == Type.ELECTRIC) return 2.0;
                // Resistente contra...
                if(atk == Type.FIRE || atk == Type.WATER || atk == Type.ICE || atk == Type.STEEL) return 0.5;
                break;
            case GRASS:
                // Fraco contra...
                if(atk == Type.FIRE || atk == Type.FLYING || atk == Type.ICE || atk == Type.POISON || atk == Type.BUG) return 2.0;
                // Resistente contra...
                if(atk == Type.WATER || atk == Type.GRASS || atk == Type.GROUND || atk == Type.ELECTRIC) return 0.5;
                break;
            case ELECTRIC:
                // Fraco contra...
                if(atk == Type.GROUND) return 2.0;
                // Resistente contra...
                if(atk == Type.ELECTRIC || atk == Type.FLYING || atk == Type.STEEL) return 0.5;
                break;
            case PSYCHIC:
                // Fraco contra...
                if(atk == Type.BUG || atk == Type.GHOST || atk == Type.DARK) return 2.0;
                // Resistente contra...
                if(atk == Type.PSYCHIC || atk == Type.FIGHTING) return 0.5;
                break;
            case ICE:
                // Fraco contra...
                if(atk == Type.FIRE || atk == Type.ROCK || atk == Type.FIGHTING || atk == Type.STEEL) return 2.0;
                // Resistente contra...
                if(atk == Type.ICE) return 0.5;
                break;
            case DRAGON:
                // Fraco contra...
                if(atk == Type.DRAGON || atk == Type.ICE || atk == Type.FAIRY) return 2.0;
                // Resistente contra...
                if(atk == Type.ELECTRIC || atk == Type.FIRE || atk == Type.WATER || atk == Type.BUG) return 0.5;
                break;
            case DARK:
                // Fraco contra...
                if(atk == Type.FIGHTING || atk == Type.BUG || atk == Type.FAIRY) return 2.0;
                // Resistente contra...
                if(atk == Type.DARK || atk == Type.GHOST) return 0.5;
                // Imune contra...
                if(atk == Type.PSYCHIC) return 0.0;
                break;
            case FAIRY:
                // Fraco contra...
                if(atk == Type.POISON || atk == Type.STEEL) return 2.0;
                // Resistente contra...
                if(atk == Type.DARK || atk == Type.FIGHTING || atk == Type.BUG) return 0.5;
                // Imune contra...
                if(atk == Type.DRAGON) return 0.0;
                break;
                
        } // FIM DO SWITCH-CASE
        
        return 1.0;
        
    } // FIM DO CALCULO DOS MULTIPLIERS/TIPO
    
} // FIM DA CLASSE
