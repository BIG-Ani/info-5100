package Ass5;

public enum SexEnum {

    MALE        ("MALE",1),
    FEMALE      ("FEMALE",2),
    SPAYED      ("SPAYED",3),
    NEUTERED    ("NEUTERED",4);

    public final int sexId;
    public final String sex;

    SexEnum(String sex, int sexId) {
        this.sex = sex;
        this.sexId = sexId;
    }
}
