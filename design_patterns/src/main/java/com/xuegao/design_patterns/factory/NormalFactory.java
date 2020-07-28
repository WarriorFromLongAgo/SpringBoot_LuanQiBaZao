package com.xuegao.design_patterns.factory;

/**
 * <br/> @PackageName：com.xuegao.design_patterns.factory
 * <br/> @ClassName：NormalFactory
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/6/26 17:30
 */
public class NormalFactory {
    private static final String LOL = "LOL";
    private static final String DNF = "DNF";

    public static void main(String[] args) {
        Game lol = ComputerFactory.playGame(LOL);
        Game dnf = ComputerFactory.playGame(DNF);
        lol.play();
        dnf.play();
    }
}


interface Game {
    void play();
}

class LOL implements Game {
    @Override
    public void play() {
        System.out.println("正在玩LOL...");
    }
}

class DNF implements Game {
    @Override
    public void play() {
        System.out.println("正在玩DNF...");
    }
}


class ComputerFactory {
    private static final String LOL = "LOL";
    private static final String DNF = "DNF";

    public static Game playGame(String game) {
        if (LOL.equalsIgnoreCase(game)) {
            return new LOL();
        } else if (DNF.equalsIgnoreCase(game)) {
            return new DNF();
        }
        return null;
    }
}