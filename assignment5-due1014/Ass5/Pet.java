package Ass5;

public class Pet {

    private String ownerName;
    private String petName;
    private String color;
    protected int sex;

    public Pet() {
    }

    public Pet(String ownerName, String petName, String color) {
        this.ownerName = ownerName;
        this.petName = petName;
        this.color = color;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getPetName() {
        return petName;
    }

    public String getColor() {
        return color;
    }

    public String getSex() {
        if(sex == SexEnum.MALE.sexId)
            return SexEnum.MALE.sex;

        if(sex == SexEnum.FEMALE.sexId)
            return SexEnum.FEMALE.sex;

        if(sex == SexEnum.SPAYED.sexId)
            return SexEnum.SPAYED.sex;

        if(sex == SexEnum.NEUTERED.sexId)
            return SexEnum.NEUTERED.sex;

        return "Sex is out of bound";
    }

    @Override
    public String toString() {
        String str1 = "\n" + petName + " owned by " + ownerName + "\n\n";
        String str2 = "Color: " + color + "\n\n";
        String str3 = "Sex: " + getSex();

        return str1 + str2 + str3;
    }

    //@Test
//    public static void main(String[] args) {
//        Pet pet = new Pet("Mary", "Spot", "Black and White");
//        pet.setSex(SexEnum.MALE.sexId);
//
//        System.out.println(pet);
//    }
}
