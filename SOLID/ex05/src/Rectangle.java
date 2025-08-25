public class Rectangle extends Shape {
    protected int w,h;
    public void setWidth(int w){
        this.w = w; 
    }
    public void setHeight(int h){
        this.h = h;
    }

    @Override 
    public int area(){
        return w*h;
    }
}