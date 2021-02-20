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
    public static void BreadthFirstSearch() {
        startTime = System.currentTimeMillis();

        Queue<String> queue = new LinkedList<>();
        String initialMoves = game.getActions(), currMove, goalPath = "", nextMoves;
        char ch;
        for (int i = 0; i < initialMoves.length(); i++)
            queue.add(Character.toString(initialMoves.charAt(i)));
        while (!queue.isEmpty()) {
            currMove = queue.poll();
            // System.out.print(currMove + " ");
            for (int i = 0; i < currMove.length(); i++)
                game.move(currMove.charAt(i));
            if (game.checkGoal()) {
                goalPath = currMove;
                break;
            }
            nextMoves = game.getActions();
            for (int i = 0; i < nextMoves.length(); i++)
                queue.add(currMove + Character.toString(nextMoves.charAt(i)));
            for (int i = currMove.length() - 1; i >= 0; i--) {
                ch = currMove.charAt(i);
                if (ch == 'U')
                    game.move('D');
                else if (ch == 'D')
                    game.move('U');
                else if (ch == 'L')
                    game.move('R');
                else if (ch == 'R')
                    game.move('L');
            }
        }
        stopTime = System.currentTimeMillis();
        System.out.println("Moves: " + goalPath);
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
