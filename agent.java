import java.util.LinkedList;
import java.util.Queue;

class agent {

    static tileGame game;
    
    public static void main(String args[]) {
        game = new tileGame();
        game.newDepthGame(15);
        game.printCurrentState("Initial State :");
        // char[][] startState = copyState();
        BreadthFirstSearch();
        game.printCurrentState("Final State :");
    }

}
