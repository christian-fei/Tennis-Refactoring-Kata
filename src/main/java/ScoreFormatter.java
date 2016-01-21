
public class ScoreFormatter {

	public String formatScore(int score) {
		if( score == 0 ){
			return "Love";
		}
		if( score == 1 ){
			return "Fifteen";
		}
		if( score == 2 ){
			return "Thirty";
		}
		return "Forty";
	}

}