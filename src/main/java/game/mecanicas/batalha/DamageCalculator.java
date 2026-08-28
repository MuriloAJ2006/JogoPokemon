package game.mecanicas.batalha;

import game.modelos.pokemon.Pokemon;
import game.modelos.golpes.Move;
import game.modelos.enums.MoveCategory;

public class DamageCalculator {
    
    private DamageCalculator() {}
    
    public static int calcDamage(Pokemon atacante, Pokemon defensor, Move golpe) {
        
        if (golpe.getCategory() == MoveCategory.STATUS) return 0;
        
        int level = atacante.getStats().getLevel();
        int power = golpe.getPower();
        int atk, def;
        
        if (golpe.getCategory() == MoveCategory.PHYSICAL) {
            atk = atacante.getStats().getActualStats().getAttack();
            def = defensor.getStats().getActualStats().getDefense();
        } else{
            atk = atacante.getStats().getActualStats().getSpAttack();
            def = defensor.getStats().getActualStats().getSpDefense();
        }
        
        int danoBase = (((2 * level) / 5 + 2) * power * atk / def) / 50 + 2;
        double typeMultiplier = TypeMachupUtils.getMultiplier(golpe.getType(), defensor.getSpecies());
        double rngFactor = (Math.random() * 16 + 85) / 100.0;
        double stab = 1.0;
        
        if (golpe.getType() == atacante.getSpecies().getPrimaryType() ||
            (atacante.getSpecies().hasSecondaryType() && golpe.getType() == atacante.getSpecies().getSecondaryType())) {
            stab = 1.5;
        } // FIM DO IF
        
        int danoFinal = (int)(danoBase * stab * typeMultiplier * rngFactor);
        
        if (danoFinal == 0 && typeMultiplier > 0) {
            danoFinal = 1;
        } else if (typeMultiplier == 0){
            danoFinal = 0;
        }
            
        return danoFinal;
    }
    
}
