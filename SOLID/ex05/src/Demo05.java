
public class Demo05 {
    static int areaAfterResize(Rectangle r){
        r.setWidth(5); r.setHeight(4); return r.area();
    }
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        System.out.println(areaAfterResize(rectangle)); // 20
        
        Square square = new Square();
        square.setSide(4);
        System.out.println(square.area()); // 16 - proper square behavior
    }
}
