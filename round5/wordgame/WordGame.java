
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class WordGame {
    
    private ArrayList<String> words = new ArrayList<String>();
    private WordGameState gameState;
    private static boolean isActive = false;
    

    public WordGame(String wordFileName) {
        try {
      BufferedReader wordFile = new BufferedReader(new FileReader(wordFileName));
      String w;
      while((w = wordFile.readLine()) != null) {
                words.add(w);
            }
        }
        catch (IOException e) {
            System.out.println(e);
        }

    }
    
    public void initGame(int wordIndex, int mistakeLimit) {
        gameState = new WordGameState();
        gameState.wordToGuess = words.get(wordIndex);
        gameState.word = "_".repeat(gameState.wordToGuess.length());
        gameState.mistakes = 0;
        gameState.mistakeLimit = mistakeLimit;
        gameState.missingChars = gameState.word.length();
        isActive = true;
        
    }
    
    public boolean isGameActive() {
        return isActive;
    }
    
    /**
     *
     * @return
     * @throws GameStateException
     */
    public WordGameState getGameState() throws GameStateException {
        if (!isActive) {
            throw new GameStateException("There is currently no active word game!");
        }
        
        return gameState;
    }
    
    public WordGameState guess(char c) throws GameStateException {
        if (!isActive) {
            throw new GameStateException("There is currently no active word game!");
        }
        
        
        
        if (gameState.word.contains(String.valueOf(c).toLowerCase())) {
            gameState.mistakes++;
            if (gameState.mistakes > gameState.mistakeLimit) {
                gameState.word = gameState.wordToGuess;
                isActive = false;
            }
            
            return gameState;
        }
        
        if (gameState.wordToGuess.contains(String.valueOf(c).toLowerCase())) {
            
            String newWord = "";
            
            for (int i = 0; i < gameState.wordToGuess.length(); i++) {
                if (String.valueOf(gameState.wordToGuess.charAt(i)).equalsIgnoreCase(String.valueOf(c))) {
                    newWord += String.valueOf(c).toLowerCase();
                    gameState.missingChars--;
                    
                    if (gameState.missingChars == 0) {isActive = false;}
                    
                }
                else
                {
                    newWord += gameState.word.charAt(i);
                }
            }
            
            gameState.word = newWord;
            return gameState;
        }
        
        gameState.mistakes++;
        if (gameState.mistakes > gameState.mistakeLimit) {
                gameState.word = gameState.wordToGuess;
                isActive = false;
            }

        return gameState;
        
    }
    
    /**
     *
     * @param word
     * @return
     * @throws GameStateException
     */
    public WordGameState guess(String word) throws GameStateException {
        if (!isActive) {
            throw new GameStateException("There is currently no active word game!");
        }
        
        if (gameState.wordToGuess.equalsIgnoreCase(word)) {
            gameState.word = word.toLowerCase();
            gameState.missingChars = 0;
            isActive = false;
        } else {
            gameState.mistakes++;
            if (gameState.mistakes > gameState.mistakeLimit) {
                gameState.word = gameState.wordToGuess;
                isActive = false;
            }
        }
        return gameState;
    }


static class WordGameState {
    private String word;
    private String wordToGuess;
    private int mistakes;
    private int mistakeLimit;
    private int missingChars;
    

        public String getWord() {
            return word;
        }

        public int getMistakes() {
            return mistakes;
        }

        public int getMistakeLimit() {
            return mistakeLimit;
        }

        public int getMissingChars() {
            return missingChars;
        }
    
    
}
    
    
}
