/*
 * Created on Mar 20, 2012
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package data;

/**
 * @author PhucSenh
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Point {
	private double x;
	private double y;
	
	
	
	/**
	 * 
	 */
	public Point() {
		x = 0.0;
		y = 0.0;
	}
	
	public Point(Point p) {
		x = p.x;
		y = p.y;
	}
	
	/**
	 * @param x
	 * @param y
	 */
	public Point(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	/**
	 * @return Returns the x.
	 */
	public double getX() {
		return x;
	}
	/**
	 * @param x The x to set.
	 */
	public void setX(double x) {
		this.x = x;
	}
	/**
	 * @return Returns the y.
	 */
	public double getY() {
		return y;
	}
	
	/*
	 * Area
	 */
	public double area(){
		return 0.0;
	}
	
	/*
	 * Move
	 */
	public void move(double dx, double dy){
		x = x + dx;
		y = y + dy;
	}
	
	/*
	 * distance
	 */
	public double distance(){
		return Math.sqrt(x * x + y * y);
	}
	
	public double distance(Point p){
		return Math.sqrt((x - p.x)*(x - p.x) + (y - p.y)*(y - p.y));
	}
	
	/*
	 * isInFirst
	 */
	public boolean isInFirst(){
		if (x>=0.0 && y>=0.0)
			return true;
		else
			return false;
	}
	
	/*
	 * Lay doi xung 1 diem qua truc Ox
	 */
	
	public Point DoiXungX()
	{
		Point a = new Point();	
		a.x = x;
		a.y = -y;
		return	a;
	}
	
	/*
	 * Lay doi xung 1 diem qua truc Oy
	 */
	
	public Point DoiXungY()
	{
		Point a = new Point(x, -y);			
//		a.x = -x;
//		a.y = y;
		return	a;
	}
	
	/**
	 * @param y The y to set.
	 */
	public void setY(double y) {
		this.y = y;
	}
	
	public static void main(String[] args) {
		
		Point x = new Point(10.0,10.0);
		
		Point y = new Point(x);
		
		Point z = new Point();
		
		System.out.println("X.x = " + x.getX());
		System.out.println("X.y = " + x.getY());
		
		System.out.println("Y.x = " + y.getX());
		System.out.println("Y.y = " + y.getY());
		
		System.out.println("Z.x = " + z.getX());
		System.out.println("Z.y = " + z.getY());
		
		z.setX(5.0);
		z.setY(5.0);
		
		System.out.println("Z.x = " + z.getX());
		System.out.println("Z.y = " + z.getY());
		
		System.out.println("d(z) = " + z.distance());
		z = x.DoiXungX();
		System.out.println("X.x = " + x.getX());
		System.out.println("X.y = " + x.getY());
		
		System.out.println("Z.x = " + z.getX());
		System.out.println("Z.y = " + z.getY());
		 
		
		System.out.println("Distance X-Z = " + x.distance(z));
	}
}
