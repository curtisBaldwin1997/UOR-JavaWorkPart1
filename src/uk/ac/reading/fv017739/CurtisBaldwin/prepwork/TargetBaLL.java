package uk.ac.reading.fv017739.CurtisBaldwin.prepwork;

/**
 * 
 */


/**
 * @author shsmchlr
 * The Target Ball which you are aiming at
 */
public class TargetBaLL extends Ball {
	private int score;
	/**
	 * 
	 */
	public TargetBaLL() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param ix
	 * @param iy
	 * @param ir
	 */
	public TargetBaLL(double ix, double iy, double ir) {
		super(ix, iy, ir);
		score = 0;
		col = 'g';
	}

	/** 
	 * checkBall in arena 
	 * @param b BallArena
	 */
	@Override
	protected void checkBall(BallArena b) {
		if (b.checkHit(this)) score++;			// if been hit, then increase score
	}
	/**
	 * draw Ball and display score
	 */
	public void drawBall(BallInterface bi) {
		super.drawBall(bi);
		bi.showScore(x, y, score);
	}

	/**
	 * adjustBall
	 * for moving the ball - not needed here
	 */
	@Override
	protected void adjustBall() {
				// nothing to do at the moment...
	}
	/**
	 * return string defining ball ... here as target
	 */
	protected String getStrType() {
		return "Target";
	}	
}
