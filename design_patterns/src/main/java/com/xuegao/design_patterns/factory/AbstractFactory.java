package com.xuegao.design_patterns.factory;

/**
 * <br/> @PackageName：com.xuegao.design_patterns.factory
 * <br/> @ClassName：AbstractFactory
 * <br/> @Description：
 * <br/> @author：feijm
 * <br/> @date：2020/6/26 17:37
 */
public class AbstractFactory {

    private static final String LOL = "LOL";
    private static final String DNF = "DNF";
    private static final String WOW = "WOW";

    public static void main(String[] args) {

        ComputerFactory3 cf3 = new PVPFactory();
        cf3.playGame().play();
        cf3.playGame2().play();
        ComputerFactory3 cf4 = new PVEFactory();
        cf4.playGame().play();
        cf4.playGame2().play();
    }
}


// interface Game{
//     void play();
// }
//
//
// class LOL implements Game{
//     @Override
//     public void play() {
//         System.out.println("正在玩LOL...");
//     }
// }
//
// class DNF implements Game{
//     @Override
//     public void play() {
//         System.out.println("正在玩DNF...");
//     }
// }
//
// class WOW  implements Game{
//     @Override
//     public void play() {
//         System.out.println("正在玩WOW...");
//     }
// }


interface ComputerFactory3 {
    Game playGame();

    Game playGame2();
}

class PVPFactory implements ComputerFactory3 {

    @Override
    public Game playGame() {
        return new LOL();
    }

    @Override
    public Game playGame2() {
        return new WOW();
    }
}

class PVEFactory implements ComputerFactory3 {

    @Override
    public Game playGame() {
        return new DNF();
    }

    @Override
    public Game playGame2() {
        return new WOW();
    }

}