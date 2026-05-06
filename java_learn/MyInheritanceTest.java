public class MyInheritanceTest {
    public static void main(String[] args) {
        Order order = new OnlineOrder();
        order.order();   
    }
}

class Order {
    void order() {
        System.out.println("Order from Order class");
    }
}

class OnlineOrder extends Order {

    @Override
    void order() {
        System.out.println("Order from OnlineOrder class");
    }

    public void onlineOrder() {
        System.out.println("Online order method");
    }
}

class OfflineOrder extends Order {

    @Override
    void order() {
        System.out.println("Order from OfflineOrder class");
    }
}
