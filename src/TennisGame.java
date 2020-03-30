public class TennisGame {

    public static final java.lang.String LOVE = "Love";
    public static final java.lang.String ALL = "All";
    public static final java.lang.String FIFTEEN = "Fifteen";
    public static final java.lang.String THIRTY = "Thirty";
    public static final java.lang.String FORTY = "Forty";
    public static final java.lang.String DEUCE = "Deuce";
    public static final String ADVANTAGE = "Advantage";
    public static final String PLAYER_1 = "player1";
    public static final String PLAYER_2 = "player2";
    public static final String WIN_FOR = "Win for";

    public static String getScore(int scoreOfFirstPlayer, int scoreOfSecondPlayer) {
        String score = "";
        if (scoreOfFirstPlayer == scoreOfSecondPlayer)
        {
            score = getDrawScore(scoreOfFirstPlayer);
        }
        else if (scoreOfFirstPlayer>=4 || scoreOfSecondPlayer>=4)
        {
            score = getPlayerAdvantageOrWin(scoreOfFirstPlayer, scoreOfSecondPlayer);
        }
        else {
            score = getPlayerScore(scoreOfFirstPlayer, scoreOfSecondPlayer);
        }
        return score;
    }

    private static String getPlayerAdvantageOrWin(int scoreOfFirstPlayer, int scoreOfSecondPlayer) {
        String score;
        int minusResult = scoreOfFirstPlayer-scoreOfSecondPlayer;
        if (minusResult==1) score = ADVANTAGE + PLAYER_1;
        else if (minusResult ==-1) score = ADVANTAGE + PLAYER_2;
        else if (minusResult>=2) score = WIN_FOR + PLAYER_1;
        else score = WIN_FOR + PLAYER_2;
        return score;
    }

    private static String getDrawScore(int scoreOfFirstPlayer) {
        String score;
        switch (scoreOfFirstPlayer)
        {
            case 0:
                score = LOVE + "-" + ALL;
                break;
            case 1:
                score = FIFTEEN + "-" + ALL;
                break;
            case 2:
                score = THIRTY + "-" + ALL;
                break;
            case 3:
                score = FORTY + "-" + ALL;
                break;
            default:
                score = DEUCE;
                break;

        }
        return score;
    }

    private static String getPlayerScore(int player1Score, int player2Score) {
        String score = "";
        int tempScore;
        for (int i = 1; i<3; i++)
        {
            if (i==1) tempScore = player1Score;
            else { score+="-"; tempScore = player2Score;}
            switch(tempScore)
            {
                case 0:
                    score+= LOVE;
                    break;
                case 1:
                    score+= FIFTEEN;
                    break;
                case 2:
                    score+= THIRTY;
                    break;
                case 3:
                    score+= FORTY;
                    break;
            }
        }
        return score;
    }
}
