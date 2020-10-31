package uk.ac.reading.fv017739.CurtisBaldwin.prepwork;

/**
 * 
 */


import java.util.ArrayList;

/**
 * @author shsmchlr
 * Class for Arena of balls
 */
public class BallArena {	
	double xSize, ySize;						// size of arena
	private ArrayList<Ball> allBalls;			// array list of all balls in arena
	/**
	 * construct an arena
	 */
	BallArena() {
		this(500, 400);			// default size
	}
	/**
	 * construct arena of size xS by yS
	 * @param xS
	 * @param yS
	 */
	BallArena(double xS, double yS){
		xSize = xS;
		ySize = yS;
		allBalls = new ArrayList<Ball>();					// list of all balls, initially empty
		allBalls.add(new GameBall(xS/2, yS/2, 10, 45, 10));	// add game ball
		allBalls.add(new TargetBaLL(xS/2, 30, 15));			// add target ball
		allBalls.add(new PaddleBall(xS/2, yS-20, 20));		// add paddle
		allBalls.add(new BlockerBall(xS/3, yS/4, 15));		// add blocker
		allBalls.add(new BlockerBall(2*xS/3, yS/4, 15));	// add blocker
	}
	/**
	 * return arena size in x direction
	 * @return
	 */
	public double getXSize() {
		return xSize;
	}
	/**
	 * return arena size in y direction
	 * @return
	 */
	public double getYSize() {
		return ySize;
	}
	/**
	 * draw all balls in the arena into interface bi
	 * @param bi
	 */
	public void drawArena(BallInterface bi) {
		for (Ball b : allBalls) b.drawBall(bi);		// draw all balls
	}
	/**
	 * check all balls .. see if need to change angle of moving balls, etc 
	 */
	public void checkBalls() {
		for (Ball b : allBalls) b.checkBall(this);	// check all balls
	}
	/**
	 * adjust all balls .. move any moving ones
	 */
	public void adjustBalls() {
		for (Ball b : allBalls) b.adjustBall();
	}
	/** 
	 * set the paddle ball at x,y
	 * @param x
	 * @param y
	 */
	public void setPaddle(double x, double y) {
		for (Ball b : allBalls)
			if (b instanceof PaddleBall) b.setXY(x, y);
	}
	/**
	 * return list of strings defining each ball
	 * @return
	 */
	public ArrayList<String> describeAll() {
		ArrayList<String> ans = new ArrayList<String>();		// set up empty arraylist
		for (Ball b : allBalls) ans.add(b.toString());			// add string defining each ball
		return ans;												// return string list
	}
	/** 
	 * Check angle of ball ... if hitting wall, rebound; if hitting ball, change angle
	 * @param x				ball x position
	 * @param y				y
	 * @param rad			radius
	 * @param ang			current angle
	 * @param notID			identify of ball not to be checked
	 * @return				new angle 
	 */
	public double CheckBallAngle(double x, double y, double rad, double ang, int notID) {
		double ans = ang;
		if (x < rad || x > xSize - rad) ans = 180 - ans;
			// if ball hit (tried to go through) left or right walls, set mirror angle, being 180-angle
		if (y < rad || y > ySize - rad) ans = - ans;
			// if try to go off top or bottom, set mirror angle
		
		for (Ball b : allBalls) 
			if (b.getID() != notID && b.hitting(x, y, rad)) ans = 180*Math.atan2(y-b.getY(), x-b.getX())/Math.PI;
				// check all balls except one with given id
				// if hitting, return angle between the other ball and this one.
		
		return ans;		// return the angle
	}

	/**
	 * check if the target ball has been hit by another ball
	 * @param target	the target ball
	 * @return 	true if hit
	 */
	public boolean checkHit(Ball target) {
		boolean ans = false;
		for (Ball b : allBalls)
			if (b instanceof GameBall && b.hitting(target)) ans = true;
				// try all balls, if GameBall, check if hitting the target
		return ans;
	}
	
	public void addBall() {
		allBalls.add(new GameBall(xSize/2, ySize/2, 10, 60, 5));
	}
}