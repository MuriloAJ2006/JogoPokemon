package game.modelos.pokemon;

import game.modelos.enums.Type;
import game.modelos.enums.GrowthRate;
import java.util.List;
import java.util.ArrayList;

public class PokemonSpecies {
    
    // ATRIBUTOS:
    // ======================================
    // 1. IDENTIFICACAO BASICA
    // ======================================
    private int pokedexNumber;
    private String pokemonName;
    // ======================================
    // 2. TIPAGEM
    // ======================================
    private Type primaryType;
    private Type secondaryType;
    // ======================================
    // 3. BASE STATS
    // ======================================
    private int baseHP;
    private int baseAttack;
    private int baseDefense;
    private int baseSpAttack;
    private int baseSpDefense;
    private int baseSpeed;
    // ======================================
    // 4. METADADOS DO SISTEMA E PROGRESSAO
    // ======================================
    private int baseExpYield;
    private int catchRate;
    private float genderRatio;
    private GrowthRate growthRate;
    // ======================================
    // 5. HABILIDADES
    // ======================================
    private List<String> possibleAbilities;
    // ======================================
    
    // CONSTRUTOR:
    // ======================================
    public PokemonSpecies() {
        this.possibleAbilities = new ArrayList<>();
    } // FIM DO CONSTRUTOR
    // ======================================
    
    // GETTERS:
    // ======================================
    public int getPokedexNumber() {return pokedexNumber;}
    public String getPokemonName() {return pokemonName;}
    
    public Type getPrimaryType() {return primaryType;}
    public Type getSecondaryType() {return secondaryType;}
    
    public int getBaseHP() {return baseHP;}
    public int getBaseAttack() {return baseAttack;}
    public int getBaseDefense() {return baseDefense;}
    public int getBaseSpAttack() {return baseSpAttack;}
    public int getBaseSpDefense() {return baseSpDefense;}
    public int getBaseSpeed() {return baseSpeed;}
    
    public int getBaseExpYield() {return baseExpYield;}
    public int getCatchRate() {return catchRate;}
    public float getGenderRatio() {return genderRatio;}
    public GrowthRate getGrowthRate() {return growthRate;}
    
    public List<String> getPossibleAbilities() {return possibleAbilities;}
    // ======================================
    
    // METODOS UTILITARIOS
    // ======================================
    public boolean hasSecondaryType(){return this.secondaryType != null;}
    
} // FIM DA CLASSE
