package assignment4;

abstract public class MoodyObject {

    //returns the mood: sad or happy - depending on which object sends the message
    abstract protected String getMood();

    //each object expresses a different emotion
    abstract protected void expressFeelings();

    //an object responds according to how it feels, print "I feel happy(or sad) today!"
    public void queryMood() {

    };
}
