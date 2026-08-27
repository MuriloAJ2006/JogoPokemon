package game.modelos.mochila;
import game.modelos.itens.Item;
import game.modelos.itens.ItemCategory;
import java.util.ArrayList;

public class Mochila {
    
    // ATRIBUTOS: BOLSOS DA MOCHILA
    private ArrayList<Item> bolsoMedicine = new ArrayList<>();
    private ArrayList<Item> bolsoPokeballs = new ArrayList<>();
    private ArrayList<Item> bolsoBattleItems = new ArrayList<>();
    private ArrayList<Item> bolsoBerries = new ArrayList<>();
    private ArrayList<Item> bolsoHMTM = new ArrayList<>();
    private ArrayList<Item> bolsoKeyItem = new ArrayList<>();
    private ArrayList<Item> bolsoZCrystals = new ArrayList<>();
    private ArrayList<Item> bolsoMegaStones = new ArrayList<>();
    private ArrayList<Item> bolsoItems = new ArrayList<>();
    
    // =======================================================
    
    // METODO AUXILIAR PARA O LIMITE DOS BOLSOS
    private int getLimiteSlots(ItemCategory categoria) {
        
        switch(categoria){
            case Z_CRYSTALS: return 100;
            case MEGA_STONES: return 100;
            default: return 50;
        } // FIM DO SWITCH
        
    } // FIM DO GET LIMITE DE SLOTS
    
    // =======================================================
    
    // METODO DE BUSCA DE BOLSO
    public ArrayList<Item> getBolso(ItemCategory categoria) {
        switch(categoria) {
            case MEDICINES: return this.bolsoMedicine;
            case POKEBALLS: return this.bolsoPokeballs;
            case BATTLE_ITENS: return this.bolsoBattleItems;
            case BERRIES: return this.bolsoBerries;
            case HM_TM: return this.bolsoHMTM;
            case KEY_ITEMS: return this.bolsoKeyItem;
            case Z_CRYSTALS: return this.bolsoZCrystals;
            case MEGA_STONES: return this.bolsoMegaStones;
            case ITEMS: return this.bolsoItems;
            default: return null;
        }
    }
    
    
    
} // FIM DA CLASSE