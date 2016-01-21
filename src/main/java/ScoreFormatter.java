
public class ScoreFormatter {

	public String formatSingleScore(int score) {
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

	public String formatSimpleScore(int firstPlayerScore, int secondPlayerScore) {
		return formatSingleScore(firstPlayerScore) + '-' + formatSingleScore(secondPlayerScore);
	}

	public String formatAdvantageOrWinScore(int firstPlayerScore, int secondPlayerScore) {
		int scoreDifference = firstPlayerScore - secondPlayerScore;
		if (scoreDifference == 1) {
			return "Advantage player1";
		}
		if (scoreDifference == -1) {
			return "Advantage player2";
		}
		if (scoreDifference >= 2) {
			return "Win for player1";
		}
		return "Win for player2";
	}

	String formatEvenScore(int score) {
		if (score == 0) {
			return "Love-All";
		}
		if (score == 1) {
			return "Fifteen-All";
		}
		if (score == 2) {
			return "Thirty-All";
		}
		return "Deuce";
	}

}