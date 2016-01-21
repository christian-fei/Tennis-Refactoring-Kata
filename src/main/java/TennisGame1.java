
public class TennisGame1 implements TennisGame {

	private ScoreFormatter scoreFormatter;
	private int firstPlayerScore = 0;
	private int secondPlayerScore = 0;
	private String firstPlayerName;
	private String secondPlayerName;

	public TennisGame1(String firstPlayerName, String secondPlayerName) {
		this.firstPlayerName = firstPlayerName;
		this.secondPlayerName = secondPlayerName;
		this.scoreFormatter = new ScoreFormatter();
	}

	public void wonPoint(String playerName) {
		if (playerName == firstPlayerName) {
			firstPlayerScore += 1;
		} else {
			secondPlayerScore += 1;
		}
	}

	public String getScore() {
		if (isEven()) {
			return formatEvenScore();
		}
		if (isAdvantageOrWin()) {
			return formatAdvantageOrWinScore();
		}
		return formatSimpleScore();
	}

	private String formatSimpleScore() {
		return scoreFormatter.formatScore(firstPlayerScore) + '-' + scoreFormatter.formatScore(secondPlayerScore);
	}

	private String formatAdvantageOrWinScore() {
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

	private String formatEvenScore() {
		if (firstPlayerScore == 0) {
			return "Love-All";
		}
		if (firstPlayerScore == 1) {
			return "Fifteen-All";
		}
		if (firstPlayerScore == 2) {
			return "Thirty-All";
		}
		return "Deuce";
	}

	private boolean isAdvantageOrWin() {
		return firstPlayerScore >= 4 || secondPlayerScore >= 4;
	}

	private boolean isEven() {
		return firstPlayerScore == secondPlayerScore;
	}
}
