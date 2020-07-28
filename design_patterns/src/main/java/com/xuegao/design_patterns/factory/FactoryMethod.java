package com.xuegao.design_patterns.factory;

/**
 * <br/> @PackageName：com.xuegao.design_patterns.factory
 * <br/> @ClassName：AbstractFactory
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/6/26 17:30
 */
public class FactoryMethod {
    private static final String LOL = "LOL";
    private static final String DNF = "DNF";
    private static final String WOW = "WOW";

    public static void main(String[] args) {

        Game game3 = new LOLFactory().playGame();
        Game game4 = new DNFFactory().playGame();
        Game game5 = new WOWFactory().playGame();
        game3.play();
        game4.play();
        game5.play();
    }
}

// interface Game {
//     void play();
// }


// class LOL implements Game {
//     @Override
//     public void play() {
//         System.out.println("正在玩LOL...");
//     }
// }
//
// class DNF implements Game {
//     @Override
//     public void play() {
//         System.out.println("正在玩DNF...");
//     }
// }

class WOW implements Game {
    @Override
    public void play() {
        System.out.println("正在玩WOW...");
    }
}


interface ComputerFactory2 {
    Game playGame();
}

class LOLFactory implements ComputerFactory2 {
    @Override
    public Game playGame() {
        return new LOL();
    }
}

class DNFFactory implements ComputerFactory2 {
    @Override
    public Game playGame() {
        return new DNF();
    }
}

class WOWFactory implements ComputerFactory2 {
    @Override
    public Game playGame() {
        return new WOW();
    }
}