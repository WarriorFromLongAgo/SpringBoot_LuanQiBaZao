package com.xuegao.video_conver.filedeal;

public class OldMacdonald {
    public static void main(String[] args) {
        Song song = new Song();
        song.lyrics();
    }
}

interface Farm {
    public String getName();

    public String getNoise();
}

class Dog implements Farm {
    String name;
    String noise;

    public Dog(String name, String noise) {
        name = name;
        noise = noise;
    }

    public String getName() {
        return name;
    }

    public String getNoise() {
        return noise;
    }
}

class Cat implements Farm {
    String name;
    String noise;

    public Cat(String name, String noise) {
        name = name;
        noise = noise;
    }

    public String getName() {
        return name;
    }

    public String getNoise() {
        return noise;
    }
}

class Duck implements Farm {
    String name;
    String noise;

    public Duck(String name, String noise) {
        name = name;
        noise = noise;
    }

    public String getName() {
        return name;
    }

    public String getNoise() {
        return noise;
    }

}

class Cow implements Farm {
    String name;
    String noise;

    public Cow(String name, String noise) {
        name = name;
        noise = noise;
    }

    public String getName() {
        return name;
    }

    public String getNoise() {
        return noise;
    }

}

class Pig implements Farm {
    String name;
    String noise;

    public Pig(String name, String noise) {
        name = name;
        noise = noise;
    }

    public String getName() {
        return name;
    }

    public String getNoise() {
        return noise;
    }

}

class Song {
    private Farm[] animal = new Farm[5];

    Song() {
        animal[0] = new Dog("dog", "woof");
        animal[1] = new Cat("cat", "meow");
        animal[2] = new Duck("duck", "quack");
        animal[3] = new Cow("cow", "moo");
        animal[4] = new Pig("pig", "oink");
    }

    public void lyrics() {
        int i;

        for (i = 0; i < animal.length; i++) {
            System.out.println("Old MacDonald had a farm, E I E I O,\r\n" +
                    "And on his farm he had a " + animal[i].getName() + ", E I E I O.\r\n" +
                    "With a " + animal[i].getNoise() + " " + animal[i].getNoise() + " here and a " + animal[i].getNoise() + " " + animal[i].getNoise() + " there,\r\n" +
                    "Here a " + animal[i].getNoise() + ", there a " + animal[i].getNoise() + ", evrywhere a " + animal[i].getNoise() + " " + animal[i].getNoise() + ".\r\n" +
                    "Old MacDonald had a farm, E I E I O.\r\n\r\n");
        }
    }
}