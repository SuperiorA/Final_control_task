package Animals;

class HomePet extends Animal {
    public HomePet(String name, String birthDate) {
        super(name, birthDate);
    }

    @Override
    public String getAnimalType() {
        return "Домашнее животное";
    }
}
