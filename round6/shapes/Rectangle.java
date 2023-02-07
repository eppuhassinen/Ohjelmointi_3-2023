

public class Rectangle implements IShapeMetrics{
    
private double width = 0;
private double height = 0;
    
    public Rectangle(double height, double width) {
        this.width = width;
        this.height = height;
    }
    
    @Override
    public String toString(){
        return String.format("Rectangle with height %.2f and width %.2f",
                this.height, this.width);
    }
    
    @Override
    public String name(){
        return "rectangle";
    }
    
    @Override
    public double area(){
        return this.height * this.width;
    }
    
    @Override
    public double circumference(){
        return (2 * this.height) + (2 * this.width);
    }
    
    
}
