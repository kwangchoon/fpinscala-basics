
class Optional<T> {
    private T value;

    public Optional(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }

    public T getOrElse(T defaultValue) {
        return value != null ? value : defaultValue;
    }

    public void set(T value) {
        this.value = value;
    }

}

class OptionalDemo {
    public static <T> T get(Optional<? extends T> opt) {
        return opt.get();
    }

    public static <T> T getOrElse(Optional<T> opt, T defaultValue) {
        return opt.getOrElse(defaultValue);
    }

    public static <T> void set(Optional<? super T> opt, T value) {
        opt.set(value);
    }

    // public static void main(String[] args) {

    // Optional<Animal> optAnimal = new Optional<Animal>(new Animal());
    // Optional<Dog> optDog = new Optional<Dog>(new Dog());
    // Optional<Cat> optCat = new Optional<Cat>(new Cat());

    // // get
    // Animal animal = get(optDog);
    // // Dog dog = get(optAnimal);

    // // getOrElse
    // Animal animal2 = getOrElse(optAnimal, new Dog());
    // Dog dog2 = getOrElse(optDog, new Dog());
    // Cat cat2 = getOrElse(optCat, new Cat());

    // // set
    // set(optAnimal, new Animal());
    // // set(optDog, new Animal());
    // set(optAnimal, new Cat());
    // }

}

class Animal {
}

class Dog extends Animal {
    public void bark() {
        System.out.println("Woof!");
    }
}

class Cat extends Animal {
    public void meow() {
        System.out.println("Meow!");
    }
}
