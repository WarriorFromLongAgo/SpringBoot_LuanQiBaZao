package com.xuegao.design_patterns.template;

/**
 * <br/> @PackageName：com.xuegao.design_patterns.template
 * <br/> @ClassName：TemplateMethod
 * <br/> @Description：模板方法
 * <br/> @author：feijm
 * <br/> @date：2020/6/26 18:35
 */
public class TemplateMethod {

    public static void main(String[] args) {
        Game game = new ContraGame();
        game.play();
        System.out.println();
        game = new TMNTGame();
        game.play();

    }
}

abstract class Game {

    //启动游戏
    protected abstract void runGame();

    //选择人物
    protected void choosePerson() {
    }

    //开始玩游戏
    protected abstract void startPlayGame();

    //结束游戏
    protected abstract void endPlayGame();

    //模板方法
    public final void play() {
        runGame();
        choosePerson();
        startPlayGame();
        endPlayGame();
    }

}

class ContraGame extends Game {

    @Override
    protected void runGame() {
        System.out.println("启动魂斗罗II...");
    }

    @Override
    protected void startPlayGame() {
        System.out.println("1P正在使用S弹打aircraft...");
    }

    @Override
    protected void endPlayGame() {
        System.out.println("1P被流弹打死了，游戏结束！");
    }
}

class TMNTGame extends Game {

    @Override
    protected void runGame() {
        System.out.println("启动忍者神龟III...");
    }

    @Override
    protected void choosePerson() {
        System.out.println("1P选择了Raph ！");
    }

    @Override
    protected void startPlayGame() {
        System.out.println("Raph正在使用绝技 “火箭头槌” ");
    }

    @Override
    protected void endPlayGame() {
        System.out.println("Raph 掉进井盖里死了，游戏结束了！ ");
    }
}
