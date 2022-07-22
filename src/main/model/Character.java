package model;

// Represents a character with a name, age, voice actor
public class Character {
    private String name;
    private int age;
    private String voiceActor;

    // REQUIRES: length of name and voice actor must be >= 1
    // EFFECTS: instantiates a Character object with a name, age, and voice actor
    public Character(String name, int age, String voiceActor) {
        this.name = name;
        this.age = age;
        this.voiceActor = voiceActor;
    }
}
