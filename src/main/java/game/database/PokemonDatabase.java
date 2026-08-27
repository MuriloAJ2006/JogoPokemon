package game.database;

import game.modelos.pokemon.PokemonSpecies;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class PokemonDatabase {
    private static PokemonDatabase instance;                // Instancia unica da classe (Singleton).
    private final Map<String, PokemonSpecies> especiesMap;  // Dicionario para busca rapida.
    
    // CONSTRUTOR:
    // ======================================
    // Privado para impedir 'new' fora da classe.
    private PokemonDatabase() {this.especiesMap = new HashMap<>();}
    // ======================================
    
    public static PokemonDatabase getInstance() {
        
        // Retorna a instancia, sendo criada na 1ª vez que for chamada.
        if (instance == null) {instance = new PokemonDatabase();}
        return instance;
        
    } // FIM DO GET INSTANCE
    
    // Leh o arquivo JSON e preenche o dicionario na RAM.
    public void carregarDados() {
        
        Gson gson = new Gson(); // Instancia o 'tradutor' (JSON -> Java).
        
        try {
            
            // Abre o JSON em Resources e prepara o fluxo de leitura.
            Reader reader = new InputStreamReader(
            Objects.requireNonNull(getClass().getResourceAsStream("/data/pokemon_species.json")));
            
            // Avisa o Gson que o arquivo contem uma LISTA, e nao apenas um objeto.
            Type listType = new TypeToken<List<PokemonSpecies>>(){}.getType();
            List<PokemonSpecies> lista = gson.fromJson(reader, listType);
            
            // Popula o HashMap padronizando as chaves em MAIUSCULO.
            for (PokemonSpecies especie : lista) {
                especiesMap.put(especie.getPokemonName().toUpperCase(), especie);
            } // FIM DO FOR
            
            // Imprime mensagem se BD for carregado.
            System.out.println("Banco de Dados carregado! Total de especies: " + especiesMap.size());
        
        } catch (JsonIOException | JsonSyntaxException e) {
            
            // Imprime mensagem se der erro para carregar o BD.
            System.out.println("Erro ao carregar bando de dados: " + e.getMessage());
        
        } // FIM DO TRY-CATCH
        
    } // FIM DO CARREGAMENTO DE DADOS
    
    // Busca um Pokemon no dicionario.
    public PokemonSpecies getEspecie(String nome) {
        return especiesMap.get(nome.toUpperCase());
    } // FIM DO GET ESPECIE
    
} // FIM DA CLASSE