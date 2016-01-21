
public class TennisGame1 implements TennisGame {

	private int firstPlayerScore = 0;
	private int secondPlayerScore = 0;
	private String firstPlayerName;
	private String secondPlayerName;

	public TennisGame1(String firstPlayerName, String secondPlayerName) {
		this.firstPlayerName = firstPlayerName;
		this.secondPlayerName = secondPlayerName;
	}

	public void wonPoint(String playerName) {
		if (playerName == firstPlayerName) {
			firstPlayerScore += 1;
		} else {
			secondPlayerScore += 1;
		}
	}

	public String getScore() {
		if (isEven(firstPlayerScore, secondPlayerScore)) {
			return formatEvenScore(firstPlayerScore, secondPlayerScore);
		}
		if (isAdvantageOrWin(firstPlayerScore, secondPlayerScore)) {
			return formatAdvantageOrWinScore(firstPlayerScore, secondPlayerScore);
		} 
		return formatSimpleScore(firstPlayerScore, secondPlayerScore);
	}

	private String formatSimpleScore(int firstPlayerScore, int secondPlayerScore) {
		String score = "";
		int tempScore;
		for (int i = 1; i < 3; i++) {
			if (i == 1)
				tempScore = firstPlayerScore;
			else {
				score += "-";
				tempScore = secondPlayerScore;
			}
			switch (tempScore) {
			case 0:
				score += "Love";
				break;
			case 1:
				score += "Fifteen";
				break;
			case 2:
				score += "Thirty";
				break;
			case 3:
				score += "Forty";
				break;
			}
		}
		return score;
	}

	private String formatAdvantageOrWinScore(int firstPlayerScore, int secondPlayerScore) {
		int scoreDifference = firstPlayerScore - secondPlayerScore;
		if (scoreDifference == 1){
			return "Advantage player1";
		}
		if (scoreDifference == -1){
			return "Advantage player2";
		}
		if (scoreDifference >= 2) {
			return "Win for player1";
		}
		return "Win for player2";
	}

	private String formatEvenScore(int firstPlayerScore, int secondPlayerScore) {
		if( firstPlayerScore == 0 ){
			return "Love-All";
		}
		if( firstPlayerScore == 1 ){
			return "Fifteen-All";
		}
		if( firstPlayerScore == 2 ){
			return "Thirty-All";
		}
		return "Deuce";
	}

	private boolean isAdvantageOrWin(int firstPlayerScore, int secondPlayerScore) {
		return firstPlayerScore >= 4 || secondPlayerScore >= 4;
	}

	private boolean isEven(int firstPlayerScore, int secondPlayerScore) {
		return firstPlayerScore == secondPlayerScore;
	}
}
