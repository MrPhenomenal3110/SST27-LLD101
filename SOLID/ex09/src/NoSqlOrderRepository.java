public class NoSqlOrderRepository implements OrderRepository {
    @Override
    public void save(String id){
        System.out.println("Saved order " + id + " to NoSQL");
    }
}
