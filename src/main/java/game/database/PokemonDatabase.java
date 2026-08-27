package game.database;

import game.modelos.pokemon.PokemonSpecies;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class PokemonDatabase {
    private static PokemonDatabase instance;
    private final Map<String, PokemonSpecies> especiesMap;
    
    private PokemonDatabase() {
        this.especiesMap = new HashMap<>();
    }
    
    public static PokemonDatabase getInstance() {
        if (instance == null) {
            instance = new PokemonDatabase();
        }
        return instance;
    }
    
    public void carregarDados() {
        Gson gson = new Gson();
        try {
            Reader reader = new InputStreamReader(
            Objects.requireNonNull(getClass().getResourceAsStream("/data/pokemon_species.json")));
            
            Type listType = new TypeToken<List<PokemonSpecies>>(){}.getType();
            List<PokemonSpecies> lista = gson.fromJson(reader, listType);
            
            for (PokemonSpecies especie : lista) {
                especiesMap.put(especie.getPokemonName().toUpperCase(), especie);
            }
            System.out.println("Banco de Dados carregado! Total de especies: " + especiesMap.size());
        } catch (Exception e) {
            System.out.println("Erro ao carregar bando de dados: " + e.getMessage());
        }
    }
    public PokemonSpecies getEspecie(String nome) {
        return especiesMap.get(nome.toUpperCase());
    }
}
