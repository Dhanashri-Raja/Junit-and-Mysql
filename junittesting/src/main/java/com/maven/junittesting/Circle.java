package com.maven.junittesting;

public class Circle {

		   private double radius;  // private variable
		   public Circle(double radius) {  // Constructor
		      setRadius(radius);
		   }
		   public double getRadius() {  // Getter
		      return radius;
		   }
		   public void setRadius(double radius) {  // Setter
		      if (radius <= 0) throw new IllegalArgumentException("radius must be positive");
		      this.radius = radius;
		   }
		   public double getArea() {   // public method
		      return radius * radius * Math.PI;
		   }
		   @Override
		   public String toString() {   // toString()
		      return "Circle[radius=" + radius + "]";
		   }
		}

