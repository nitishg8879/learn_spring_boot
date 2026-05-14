public class CovieranceTest {
    public static void main(String[] args) {
        CovieranceTestB a = new CovieranceTestB();
        a.hello();
    }
}

class CovieranceTestA {
    CovieranceTestA hello() {
        return new CovieranceTestA();
    }
}

class CovieranceTestB extends CovieranceTestA {
    @Override
    CovieranceTestB hello() {
        return new CovieranceTestB();
    }
}
