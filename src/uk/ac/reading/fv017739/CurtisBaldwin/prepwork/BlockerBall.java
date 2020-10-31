package uk.ac.reading.fv017739.CurtisBaldwin.prepwork;

/**
 * 
 */


/**
 * @author shsmchlr
 * Ball which gets in way of game ball
 */
public class BlockerBall extends Ball {

	/**
	 * 
	 */
	public BlockerBall() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param ix
	 * @param iy
	 * @param ir
	 */
	public BlockerBall(double ix, double iy, double ir) {
		super(ix, iy, ir);
		col = 'o';
	}

	/* (non-Javadoc)
	 * @see uk.ac.reading.profrichardmitchell83.Ball#checkBall(uk.ac.reading.profrichardmitchell83.BallArena)
	 */
	@Override
	protected void checkBall(BallArena b) {
		// nowt to do

	}

	/* (non-Javadoc)
	 * @see uk.ac.reading.profrichardmitchell83.Ball#adjustBall()
	 */
	@Override
	protected void adjustBall() {
		// nowt to do

	}
	protected String getStrType() {
		return "Blocker";
	}	

}
