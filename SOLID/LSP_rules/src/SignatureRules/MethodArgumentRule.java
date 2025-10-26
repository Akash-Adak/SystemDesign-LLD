package SignatureRules;// Method Argument Rule :
// Subtype method arguments can be identical or wider than the supertype
// Java enforces this by requiring the same method signature for overrides

class Parent1 {
    public void print(String msg) {
        System.out.println("Parent: " + msg);
    }
}

class Child1 extends Parent1 {
    @Override
    public void print(String msg) {
        System.out.println("Child: " + msg);
    }
}

// Client that passes a String msg as the client expects.
class Client1 {
    private Parent1 p;

    public Client1(Parent1 p) {
        this.p = p;
    }

    public void printMsg() {
        p.print("Hello");
    }
}

public class MethodArgumentRule {
    public static void main(String[] args) {
        Parent1 parent = new Parent1();
        Parent1 child  = new Child1();

        Client1 client = new Client1(parent);
        //Client client = new Client(child);

        client.printMsg();
    }
}
