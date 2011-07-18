package mps.sxs.jderiv.util.pattern;

import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.lang.reflect.Method;

import junit.framework.TestCase;

/**
 * 
 * @author admin_2
 *
 * @param <RetT>
 */
public abstract class VisitorImpl1 implements ReflectionVisitor{

	
	
	@Override
	public Object visit(Object obj) {
		Class<?> objClass = obj.getClass();
		while(!objClass.equals(Object.class)){
			try {
				Method dispatchedMethod = this.getClass().getMethod("visit", objClass);
				return dispatchedMethod.invoke(this, obj);
			} catch (Exception e) {}
			objClass = objClass.getSuperclass();
		}
		
		objClass = obj.getClass();
		while(!objClass.equals(Object.class)){
			Class<?>[] objInterfaces = objClass.getInterfaces();
			for(Class<?> objI : objInterfaces){
				try {
					Method dispatchedMethod = this.getClass().getMethod("visit", objI);
					return dispatchedMethod.invoke(this, obj);
				} catch (Exception e) {}
			}
			objClass = objClass.getSuperclass();
		}
		String msg = "U have to define a method visit(" + obj.getClass() + ") in " + this.getClass();
		System.err.println(msg);
		return null;
	}

	
	static class ShapeVisitor extends VisitorImpl1{
		public Object visit(Shape shape){
			System.out.println("VisitorImpl1.deVext.ShapeVisitor.visit(Shape)");
			return shape;
		}
		public Object visit(Rectangle2D rect){
			System.out.println("VisitorImpl1.deVext.ShapeVisitor.visit(Rectangle2D)");
			return rect;
		}
		public Object visit(String str){
			System.out.println(str);
			return str;
		}
	}
	public static class deVext extends TestCase{
		
		public static void testVisitor1(){
			ShapeVisitor v1 = new ShapeVisitor();
			Object[] shapes = new Object[]{
					new Rectangle(), new Rectangle2D.Double(), new Ellipse2D.Double(), "hoge-"
			};
			for(Object s : shapes){
				v1.visit(s);
			}
		}
	}
	
}
