package game.modelos.golpes;

import game.modelos.enums.Type;
import game.modelos.enums.MoveCategory;

public class Move {
    
    private final String name;
    private final Type type;
    private final MoveCategory category;
    private final int power;
    private final int accuracy;
    private final int totalPP;
    
    public Move(String name, Type type, MoveCategory category, int power, int accuracy, int totalPP) {
        this.name = name;
        this.type = type;
        this.category = category;
        this.power = power;
        this.accuracy = accuracy;
        this.totalPP = totalPP;
    }
    
    public String getName() {return name;}
    public Type getType() {return type;}
    public MoveCategory getCategory() {return category;}
    public int getPower() {return power;}
    public int getAccuracy() {return accuracy;}
    public int getTotalPP() {return totalPP;}
    
} // FIM DA CLASSE
