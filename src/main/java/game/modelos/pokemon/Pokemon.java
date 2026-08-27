package game.modelos.pokemon;

public class Pokemon {
    
    private final PokemonSpecies species;
    private final CombatStats stats;
    private String nickname;
    private final boolean isShiny;
    
    public Pokemon(PokemonSpecies species, int lvlInicial, StatsBlock ivsSorteados, boolean isShiny) {
        this.species = species;
        this.stats = new CombatStats(lvlInicial, ivsSorteados);
        this.nickname = "";
        this.isShiny = isShiny;
    }
    
    public PokemonSpecies getSpecies() {return species;}
    public CombatStats getStats() {return stats;}
    public boolean isShiny() {return isShiny;}
    
    public String getDisplayName(){
        if (this.nickname != null && !this.nickname.isEmpty()) {
            return this.nickname;
        }
        return this.species.getPokemonName();
    }
    
    public void setNickname(String newNickname) {
        this.nickname = newNickname;
    }
    
    public boolean isFainted() {
        return this.stats.getCurrentHP() <= 0;
    }
}