
public class Square extends Shape {
    protected int side;

    public void setSide(int s){
        side = s; 
    }

    @Override
    public int area(){
        return side*side; 
    }
}