
public class TennisGame1 implements TennisGame {

	private ScoreFormatter scoreFormatter;
	int firstPlayerScore = 0;
	int secondPlayerScore = 0;
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
			return scoreFormatter.formatEvenScore(firstPlayerScore);
		}
		if (isAdvantageOrWin()) {
			return scoreFormatter.formatAdvantageOrWinScore(firstPlayerScore, secondPlayerScore);
		}
		return scoreFormatter.formatSimpleScore(firstPlayerScore, secondPlayerScore);
	}

	private boolean isAdvantageOrWin() {
		return firstPlayerScore >= 4 || secondPlayerScore >= 4;
	}

	private boolean isEven() {
		return firstPlayerScore == secondPlayerScore;
	}
}
