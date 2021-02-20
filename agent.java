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
    static char[][] copyState() {
        char[][] arr = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = game.state[i][j];
            }
        }
        return arr;
    }
}
