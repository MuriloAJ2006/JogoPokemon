package game.modelos.enums;

public enum Nature {
    
    ADAMANT (CoreStat.ATTACK, CoreStat.SP_ATTACK),
    BASHFUL (CoreStat.SP_ATTACK, CoreStat.SP_ATTACK),
    BOLD (CoreStat.DEFENSE, CoreStat.ATTACK),
    BRAVE (CoreStat.ATTACK, CoreStat.SPEED),
    CALM (CoreStat.SP_DEFENSE, CoreStat.ATTACK),
    CAREFUL (CoreStat.SP_DEFENSE, CoreStat.SP_ATTACK),
    DOCILE (CoreStat.DEFENSE, CoreStat.DEFENSE),
    GENTLE (CoreStat.SP_DEFENSE, CoreStat.DEFENSE),
    HARDY (CoreStat.ATTACK, CoreStat.ATTACK),
    HASTY (CoreStat.SPEED, CoreStat.DEFENSE),
    IMPISH (CoreStat.DEFENSE, CoreStat.SP_ATTACK),
    JOLLY (CoreStat.SPEED, CoreStat.SP_ATTACK),
    LAX (CoreStat.DEFENSE, CoreStat.SP_DEFENSE),
    LONELY (CoreStat.ATTACK, CoreStat.DEFENSE),
    MILD (CoreStat.SP_ATTACK, CoreStat.DEFENSE),
    MODEST (CoreStat.SP_ATTACK, CoreStat.ATTACK),
    NAIVE (CoreStat.SPEED, CoreStat.SP_DEFENSE),
    NAUGHTY (CoreStat.ATTACK, CoreStat.SP_DEFENSE),
    QUIET (CoreStat.SP_ATTACK, CoreStat.SPEED),
    QUIRKY (CoreStat.SP_DEFENSE, CoreStat.SP_DEFENSE),
    RASH (CoreStat.SP_ATTACK, CoreStat.SP_DEFENSE),
    RELAXED (CoreStat.DEFENSE, CoreStat.SPEED),
    SASSY (CoreStat.SP_DEFENSE, CoreStat.SPEED),
    SERIOUS (CoreStat.SPEED, CoreStat.SPEED),
    TIMID (CoreStat.SPEED, CoreStat.ATTACK);
    
    private final CoreStat increasedStat;   // Aumenta o Stat
    private final CoreStat decreasedStat;   // Diminui o Stat
    
    // CONSTRUTOR:
    // =========================================
    Nature (CoreStat plusStat, CoreStat minusStat) {
        
        this.increasedStat = plusStat;
        this.decreasedStat = minusStat;
        
    } // FIM DO CONSTRUTOR
    // =========================================
    
    // METODO AUXILIAR P/ CALCULO DOS BUFFS/DEBUFFS:
    // =========================================
    public double getMultiplier(CoreStat statToCheck) {
        
        if (this.increasedStat == this.decreasedStat) {return 1.0;}
        if (statToCheck == this.increasedStat) {return 1.1;}
        if (statToCheck == this.decreasedStat) {return 0.9;}
        return 1.0;
        
    } // FIM DO GET MULTIPLIER
    // =========================================
    
    // ENUM AUXILIAR P/ AS NATUREZAS:
    // =========================================
    public enum CoreStat {
        ATTACK, 
        DEFENSE, 
        SP_ATTACK, 
        SP_DEFENSE, 
        SPEED;
    }; // FIM DO ENUM AUXILIAR
    // =========================================
    
} // FIM DO ENUM/CLASSE