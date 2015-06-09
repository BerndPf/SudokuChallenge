At the founders forum, a private network of digital and technology entrepreneurs, Singapores prime minister talked about his vision of Singapore becoming a Smart Nation [http://www.pmo.gov.sg/mediacentre/transcript-speech-prime-minister-lee-hsien-loong-founders-forum-smart-nation-singapore]. He stated that the last programme he wrote was a Sudoku solver and later on published his code [https://drive.google.com/folderview?id=0B2G2LjIu7WbdfjhaUmVzc1lCR2hUdk5fZllCOHdtbFItbU5qYzdqZGVxdmlnRkJyYVQ4VU0]. Are you fit for the Smart Nation [https://en.wikipedia.org/wiki/Smart_Nation]? Prove it by developing your own Sudoku Solver.


===============


Sudoku [https://en.wikipedia.org/wiki/Sudoku]:
Sudoku; originally called Number Place, is a logic-based, combinatorial number-placement puzzle. The objective is to fill a 9×9 grid with digits so that each column, each row, and each of the nine 3×3 sub-grids that compose the grid (also called "boxes", "blocks", "regions", or "sub-squares") contains all of the digits from 1 to 9. The puzzle setter provides a partially completed grid, which for a well-posed puzzle has a unique solution.

Completed puzzles are always a type of Latin square with an additional constraint on the contents of individual regions. For example, the same single integer may not appear twice in the same row, column or in any of the nine 3×3 subregions of the 9x9 playing board.

Although French newspapers featured variations of the puzzles in the 19th century, the modern sudoku only started to become mainstream in 1986 by the Japanese puzzle company Nikoli, under the name Sudoku, meaning single number. It only became officially recognized as being common in western media publications in 2005.


===============


Sudoku Challenge:
Develop you own Sudoku Solver. Do so by implementing a solve() and a verify() method. Both methods need to be implemented as the given code structure uses a solve-verify-pattern.
The solve() method takes a Sudoku object as a parameter. A Sudoku can be accessed via its get() and set() methods. The first two parameters specify the row and the column of the sudoku, where row and column in {1,2,...,9}. Beware of IndexOutOfBound exceptions. set() has an additional paramter, that is the value you want to set at a specified location. Any value in the range of an signed byte is legal. If you try to overwrite an initial terminal value set() returns false and does nothing to the sudoku. Feel free to take a look at the Sudoku class for implementation details.
Use the verify() method to verify your solution. If you're 100% sure that solve() yields the correct solution to a sudoku your verify() method may look like this:
   static boolean verify(){
      return verified=true;
    }
Note that intentionally there is no verification but your verify() method. As it may be too easy to depict a solver from an efficient verifier.
Further note that the execution time is bound by a time-limit. The maximum execution time is set to be the Guinness World Record time it took to complete a sudoku, that is 1m 23.93s [http://www.sudoku.com/how-to-play/who-has-the-guinness-world-record-for-fastest-sudoku-player/].
The variable sudokuAtLine in the Sudoku class allows you to specify a sudoku from the Sudokus.csv.
