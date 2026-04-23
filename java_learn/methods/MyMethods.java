package java_learn.methods;

public class MyMethods {
    void getThisThing() {
        System.out.println("This is a method");
    }

    public static void main(String[] args) {
        InVoice a = new InVoice();
        a.getInvoice();
    }
}

class InVoice {
    void getInvoice() {
        System.out.println("This is an invoice");
    }
}

class JobPortal {
    String getJob() {
        return "This is a job portal";
    }
}
