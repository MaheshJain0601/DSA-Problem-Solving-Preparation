/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int low = 1, high = n, guess_no;

        int response;

        while (low <= high) {
            guess_no = low + (high - low)/2;

            response = guess(guess_no);

            if (response == 0) return guess_no;
            else if (response == -1) high = guess_no - 1;
            else low = guess_no + 1;
        }
        return -1;
    }
}