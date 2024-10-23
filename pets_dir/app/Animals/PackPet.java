package Animals;

class PackPets extends Animal {
    private String[] commands;

    public PackPets(String name, String birthDate) {
        super(name, birthDate);
    }

    @Override
    public String getAnimalType() {
        return "Вьючное животное";
    }
}
