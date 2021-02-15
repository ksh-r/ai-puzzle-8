/* Environment for Puzzle 8:

Functions:
    newGame: Creates a random solvable state
    getActions: Returns a string of possible moves of the empty space
    
*/

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class tileGame {

    public char[][] state;
    public int[] emptyCoords;

    tileGame() {
        state = new char[3][3];
        emptyCoords = new int[2];

        // Creating starting state
        newGame();

        emptyCoords = getEmptyCoords();
    }

    String getActions() {
        String actions = "";
        if(emptyCoords[0] > 0)
            actions += 'U';
        if(emptyCoords[0] < 2)
            actions += 'D';
        if(emptyCoords[1] > 0)
            actions += 'L';
        if(emptyCoords[1] < 2)
            actions += 'R';
        return actions;
    }

    void move(char ch) {
        if(ch == 'L') {
            state[emptyCoords[0]][emptyCoords[1]] = state[emptyCoords[0]][emptyCoords[1] - 1];
            state[emptyCoords[0]][--emptyCoords[1]] = ' ';
        } else if (ch == 'R') {
            state[emptyCoords[0]][emptyCoords[1]] = state[emptyCoords[0]][emptyCoords[1] + 1];
            state[emptyCoords[0]][++emptyCoords[1]] = ' ';
        } else if(ch == 'U') {
            state[emptyCoords[0]][emptyCoords[1]] = state[emptyCoords[0] - 1][emptyCoords[1]];
            state[--emptyCoords[0]][emptyCoords[1]] = ' ';
        } else {
            state[emptyCoords[0]][emptyCoords[1]] = state[emptyCoords[0] + 1][emptyCoords[1]];
            state[++emptyCoords[0]][emptyCoords[1]] = ' ';
        }
    }

    void newGame() {
        Integer[] initial = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        // Randomizing the starting position
        List<Integer> initialList = Arrays.asList(initial);
        Collections.shuffle(initialList);
        initialList.toArray(initial);

        // Checking if impossible
        initial = makeSolvable(initial);

        // Filling state array
        int temp = 0;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(initial[temp] == 9) {
                    state[i][j] = ' ';
                } else {
                    state[i][j] = Character.forDigit(initial[temp], 10);
                }
                temp++;
            }
        }
    }

    Integer[] makeSolvable(Integer[] arr) {
        int inversion = 0;
        for(int i = 0; i < 8; i++) {
            for(int j = i+1; j < 9; j++) {
                if(arr[i] == 9 || arr[j] == 9)
                    continue;
                if(arr[i] > arr[j])
                    inversion++;
            }
        }
        if(inversion % 2 == 1) {
            inversion = arr[8];
            arr[8] = arr[7];
            arr[7] = inversion;
        }
        return arr;
    }

    int[] getEmptyCoords() {
        int[] coords = {0, 0};
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(state[i][j] == ' ') {
                    coords[0] = i;
                    coords[1] = j;
                }
            }
        }
        return coords;
    }

    void printCurrentState() {
        System.out.println("Current state:");
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                System.out.print(state[i][j] + " ");
            }
            System.out.println();
        }
    }
}