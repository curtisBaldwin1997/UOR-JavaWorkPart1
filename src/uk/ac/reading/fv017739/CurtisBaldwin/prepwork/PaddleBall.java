package uk.ac.reading.fv017739.CurtisBaldwin.prepwork;

/**
 * 
 */


/**
 * @author shsmchlr
 *
 */
public class PaddleBall extends Ball {

	/**
	 * Set up the paddle controlled by the user
	 */
	public PaddleBall() {
		// TODO Auto-generated constructor stub
	}

	/**Set paddle ball size ir at ix,iy
	 * @param ix
	 * @param iy
	 * @param ir
	 */
	public PaddleBall(double ix, double iy, double ir) {
		super(ix, iy, ir);
		col = 'b';
		// TODO Auto-generated constructor stub
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
	/**
	 *  return string description as paddle
	 */
	protected String getStrType() {
		return "Paddle";
	}	
}
