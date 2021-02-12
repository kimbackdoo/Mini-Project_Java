package bowling;

public class Game {
	private int itsCurrentFrame = 1;
	private boolean firstThrowInFrame = true;
	private Scorer itsScorer = new Scorer();
	
	public int score() {
		return scoreForFrame(itsCurrentFrame);
	}
	
	public void add(int pins) {
		itsScorer.addThrow(pins);
		adjustCurrentFrame(pins);
	}
	
	private int cnt=1;
	private void adjustCurrentFrame(int pins) {
		if((firstThrowInFrame && pins == 10) || (!firstThrowInFrame)) {
			firstThrowInFrame = true;
			advanceFrame();
		}
		else
			firstThrowInFrame = false;
		System.out.println(cnt + " 번 투구, itsCurrentFrame : " + itsCurrentFrame);
		cnt++;
	}

//	if(lastBallInFrame(pins)) advanceFrame();
//	else firstThrowInFrame = false;	
	
//	private boolean strike(int pins) {
//		return (firstThrowInFrame && pins == 10);
//	}
//	
//	private boolean lastBallInFrame(int pins) {
//		return strike(pins) || !firstThrowInFrame;
//	}
	
	private void advanceFrame() {
		itsCurrentFrame = Math.min(10, itsCurrentFrame + 1);
	}
	
	public int scoreForFrame(int theFrame) {
		return itsScorer.scoreForFrame(theFrame);
	}
}