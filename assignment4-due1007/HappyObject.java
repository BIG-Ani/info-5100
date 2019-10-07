package assignment4;

public class HappyObject extends MoodyObject {
    //returns a string indicating happy
    @Override
    protected String getMood() {
        return "I feel happy today!";
    }

    //print laughter string: "hehehe...hahahah...HAHAHAHAHA!!!"
    @Override
    protected void expressFeelings() {
        System.out.println("hehehe...hahahah...HAHAHAHAHA!!!");
    }

    //returns message about self: "Subject cries a lot";
    @Override
    public String toString() {
        return "Subject cries a lot";
    }
}
