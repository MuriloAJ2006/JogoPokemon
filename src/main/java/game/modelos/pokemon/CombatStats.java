package game.modelos.pokemon;

import game.modelos.enums.StatusCondition;

public class CombatStats {
    
    // ATRIBUTOS:
    // ======================================
    private int level;
    private int currentEXP;
    private int currentHP;
    private final StatsBlock ivs;
    private final StatsBlock evs;
    private StatsBlock actualStats;
    private StatusCondition condition;
    // ======================================
    
    // CONSTRUTOR:
    // ======================================
    public CombatStats(int levelInicial, StatsBlock ivsGerados){
        
        this.level = levelInicial;
        this.currentEXP = 0;
        this.ivs = ivsGerados;
        this.evs = new StatsBlock();
        this.condition = StatusCondition.NONE;
        
    } // FIM DO CONSTRUTOR
    // ======================================
    
    // GETTERS:
    // ======================================
    public int getLevel() {return level;}
    public int getCurrentEXP() {return currentEXP;}
    public int getCurrentHP() {return currentHP;}
    public StatsBlock getIvs() {return ivs;}
    public StatsBlock getEvs() {return evs;}
    public StatsBlock getActualStats() {return actualStats;}
    public StatusCondition getCondition() {return condition;}
    // ======================================
    
    // METODOS DE GERENCIAMENTO DE VIDA/STATUS:
    // ======================================
    public void setCondition(StatusCondition newCondition) {
        
        if (this.condition == StatusCondition.NONE || newCondition == StatusCondition.NONE) {
            this.condition = newCondition;
        } // FIM DO IF
    
    } // FIM DO SET CONDITION
    // --------------------------------------
    public void takeDamage(int damage) {
        
        this.currentHP -= damage;
        if (this.currentHP < 0){this.currentHP = 0;}
        
    } // FIM DO TAKE DAMAGE
    // --------------------------------------
    public void heal(int amount) {
        
        this.currentHP += amount;
        int maxHP = this.actualStats.getHp();
        if (this.currentHP > maxHP) {
            this.currentHP = maxHP;
        } // FIM DO IF
        
    } // FIM DO HEAL
    // ======================================
    
    // METODOS DE PROGRESSO (XP/LVL):
    // ======================================
    public void addExp(int amount) {
        
        if (this.level >= 100) {return;}
        if (amount > 0) {this.currentEXP += amount;}
        
    } // FIM DO ADD XP
    // --------------------------------------
    public void levelUp() {
        
        if (this.level < 100) {this.level++;}
        
    } // FIM DO LEVEL UP
    // ======================================
    
    // METODOS DE TREINAMENTO E ATRIBUTOS (EVs):
    // ======================================
    private int calcTotalEVs(){
        
        return this.evs.getHp() + this.evs.getAttack() +
               this.evs.getDefense() + this.evs.getSpAttack() +
               this.evs.getSpDefense() + this.evs.getSpeed();
    
    } // FIM DO CALCULO DE EVs TOTAIS
    // --------------------------------------
    private int processSingleEV(int valorAtual, int ganhoRecebido) {
        
        int limiteStatus = 252; // Limite de pontos que um Stats pode ter.
        int limiteGlobal = 510; // Limite de pontos totais de Stats que um Pokemon pode ter.
        
        // Verifica quantos pontos totais ainda posso ganhar.
        int espacoGlobalLivre = limiteGlobal - calcTotalEVs();
        
        // Verifica quantos pontos o meu Stats ainda pode receber.
        int espacoNesteStatus = limiteStatus - valorAtual;
        
        // Se o oponente nao deu EV, nao faz nada.
        if (ganhoRecebido <= 0) {return valorAtual;}
        
        // Se o limite total foi atingido, bloqueia novos ganhos.
        if (espacoGlobalLivre <= 0) {return valorAtual;}
        
        // Se o Stats teve seu limite atingido, nao recebe mais nada.
        if (espacoNesteStatus <= 0) {return valorAtual;}
        
        // O ganho real eh o MENOR valor entre:
        // 1. A quantidade de EV que o inimigo deu (ganhoRecebio);
        // 2. A quantidade que falta para atingir o limite do Stats (espacoNesteStatus);
        // 3. A quantidade que falta para atingir o limite do Pokemon (espacoGlobalLivre).
        int ganhoReal = Math.min(ganhoRecebido, Math.min(espacoNesteStatus, espacoGlobalLivre));
        
        // O Status atual recebe os pontos de EVs.
        return valorAtual + ganhoReal;
        
    } // FIM DO PROCESSAMENTO DO EV
    // --------------------------------------
    public void addEvs(StatsBlock ganhos) {
        
        this.evs.setHp(processSingleEV(this.evs.getHp(), ganhos.getHp()));
        this.evs.setAttack(processSingleEV(this.evs.getAttack(), ganhos.getAttack()));
        this.evs.setDefense(processSingleEV(this.evs.getDefense(), ganhos.getDefense()));
        this.evs.setSpAttack(processSingleEV(this.evs.getSpAttack(), ganhos.getSpAttack()));
        this.evs.setSpDefense(processSingleEV(this.evs.getSpDefense(), ganhos.getSpDefense()));
        this.evs.setSpeed(processSingleEV(this.evs.getSpeed(), ganhos.getSpeed()));
        
    } // FIM DO ADD EVs
    // ======================================
    
    // METODO DE ATUALIZACAO DOS STATUS:
    // ======================================
    public void updateActualStats(StatsBlock statusCalculados) {
        
        // HP Max Antigo a ser usado na atualizacao do HP Atual.
        int hpMaxAntigo = 0;
        if (this.actualStats != null) {hpMaxAntigo = this.actualStats.getHp();}
        
        // Atualiza todos os Status atuais.
        this.actualStats = statusCalculados;
        
        // Ajustando o HP Atual.
        if (hpMaxAntigo > 0) {
            // Calcula o quanto o HP Max aumentou.
            int diferencaHP = this.actualStats.getHp() - hpMaxAntigo;
            // Cura o HP atual com a diferenca.
            if (diferencaHP > 0) {this.currentHP += diferencaHP;}
        } else {
            // HP Antigo = 0 significa que o Pokemon acabou de ser construido.
            // No caso, deve ser construido com a vida cheia.
            this.currentHP = this.actualStats.getHp();
        } // FIM DO IF-ELSE
        
        // Previne que HP Atual > HP Max apos recalculo (caso de bug).
        if (this.currentHP > this.actualStats.getHp()) {
            this.currentHP = this.actualStats.getHp();
        } // FIM DO IF
        
    } // FIM DA ATUALIZACAO DO STATS ATUAL   
    
} // FIM DA CLASSE
