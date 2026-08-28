package game.modelos.pokemon;

import game.modelos.golpes.Move;

public class MoveSet {
    
    private final MoveSlot[] slots;
    
    public MoveSet() {
        this.slots = new MoveSlot[4];
    }
    
    public void learnMove(int index, Move move) {
        if (index >= 0 && index < 4) {
            this.slots[index] = new MoveSlot(move);
        }
    }
    
    public MoveSlot[] getSlots() {return slots;}
    
    public static class MoveSlot {
        private final Move move;
        private int currentPP;
        
        public MoveSlot(Move move) {
            this.move = move;
            this.currentPP = move.getTotalPP();
        }
        
        public Move getMove() {return move;}
        public int getCurrentPP() {return currentPP;}
        
        public void decrementPP() {
            if (this.currentPP > 0) {this.currentPP--;}
        }
    }
    
}
