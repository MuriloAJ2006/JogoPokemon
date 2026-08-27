package game.modelos.pokemon;

public class Pokemon {
    
    // ATRIBUTOS:
    // ======================================
    private final PokemonSpecies species;
    private final CombatStats stats;
    private String nickname;
    private final boolean isShiny;
    // ======================================
    
    // CONSTRUTOR:
    // ======================================
    public Pokemon(PokemonSpecies species, int lvlInicial, StatsBlock ivsSorteados, boolean isShiny) {
        
        this.species = species;
        this.stats = new CombatStats(lvlInicial, ivsSorteados);
        this.nickname = "";
        this.isShiny = isShiny;
        
    } // FIM DO CONSTRUTOR
    // ======================================
    
    // GETTERS BASICOS:
    // ======================================
    public PokemonSpecies getSpecies() {return species;}
    public CombatStats getStats() {return stats;}
    public boolean isShiny() {return isShiny;}
    // ======================================
    
    // TRATAMENTO DE APELIDOS (NICKNAMES):
    // ======================================
    public String getDisplayName(){
        
        // Retorna o apelido de existir.
        if (this.nickname != null && !this.nickname.isEmpty()) {
            return this.nickname;
        } // FIM DO IF
        
        // Se nao existir, retorna o nome da especie.
        return this.species.getPokemonName();
        
    } // FIM DO GET DISPLAY NAME
    
    // --------------------------------------
    
    // SETTER DO NICKNAME:
    public void setNickname(String newNickname) {this.nickname = newNickname;}
    // ======================================
    
    // ATALHO P/ BATALHA:
    // ======================================
    // Verifica se a vida do Pokemon chegou a zero.
    public boolean isFainted() {return this.stats.getCurrentHP() <= 0;}
    // ======================================

} // FIM DA CLASSE