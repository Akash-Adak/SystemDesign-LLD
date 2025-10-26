package SignatureRules;// Return Type Rule :
// Subtype overridden method return type should be either identical 
// or narrower than the parent method's return type.
// This is also called return type covariance.
// Java supports this out of the box.

class Animal {
    // some common Animal methods
}

class Dog extends Animal {
    // Additional Dog methods specific to Dogs.
}

class Parent2 {
    public Animal getAnimal() {
        System.out.println("Parent : Returning Animal instance");
        return new Animal();
    }
}

class Child2 extends Parent2 {
    @Override
    public Animal getAnimal() {
        System.out.println("Child : Returning Dog instance");
        return new Dog();
    }
}

class Client2 {
    private Parent2 p;

    public Client2(Parent2 p) {
        this.p = p;
    }

    public void takeAnimal() {
        p.getAnimal();
    }
}

public class ReturnTypeRule {
    public static void main(String[] args) {
        Parent2 parent = new Parent2();
        Child2 child   = new Child2();

        Client2 client = new Client2(child);
        //Client client = new Client(parent);
        client.takeAnimal();
    }
}
