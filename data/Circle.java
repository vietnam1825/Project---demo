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
public class Circle extends Point{
	
	// Atributes
	private double r;
	
	// Constructors
	public Circle(){
		super();
		r = 0.0;
	}
	
	public Circle(double _x, double _y, double _r){
		super(_x, _y);
		r = _r;
	}
	
	public Circle(Circle c){
		super(c.getX(), c.getY());
		r = c.r;
	}
	
	public Circle(Point p, double _r){
		super(p);
		r = _r;
	}
	
	// Getters and Setters

	public static void main(String[] args) {
		Circle c = new Circle();
		System.out.println("c.x = " + c.getX());
		System.out.println("c.y = " + c.getY());
	}
}
