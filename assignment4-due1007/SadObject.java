package assignment4;

public class SadObject extends MoodyObject {
    //returns a string indicating sad
    @Override
    protected String getMood() {
        return "I feel sad today!";
    }

    //print crying string: " 'wah' 'boo hoo' 'weep' 'sob' 'weep' "
    @Override
    protected void expressFeelings() {
        System.out.println("'wah' 'boo hoo' 'weep' 'sob' 'weep'");
    }

    //returns message about self: "Subject cries a lot";
    @Override
    public String toString() {
        return "Subject cries a lot";
    }
}
