package com.jy.designpattern.demo.factorypattern;

/**
 * 抽象工厂设计模式
 */
public class AbstractFactoryPattern {

    public static void main(String[] args) {
        ComputerEngineer engineer = new ComputerEngineer();
        Computer intelComputer = engineer.makeIntelComputer();
        Computer amdComputer = engineer.makeAmdComputer();
        System.out.println(intelComputer);
        System.out.println(amdComputer);
    }

}


/**
 * 电脑装配工程师
 * */
class ComputerEngineer {

    /**
     * 组装Intel系列电脑
     * */
    public Computer makeIntelComputer() {
        Cpu cpu = intelFactory.createCpu();
        //测试配件是否好用
        cpu.calculate();
        MainBoard mainBoard = intelFactory.createMainBoard();
        //安装CPU
        mainBoard.installCpu(cpu);
        return new Computer(cpu, mainBoard);
    }

    /**
     * 组装AMD系列电脑
     * */
    public Computer makeAmdComputer() {
        Cpu cpu = amdFactory.createCpu();
        //测试配件是否好用
        cpu.calculate();
        MainBoard mainBoard = amdFactory.createMainBoard();
        //安装CPU
        mainBoard.installCpu(cpu);
        return new Computer(cpu, mainBoard);
    }

    private AbstractFactory intelFactory = new IntelFactory();

    private AbstractFactory amdFactory = new AmdFactory();

}


/**
 * 电脑
 * */
class Computer {

    private Cpu cpu;
    private MainBoard mainBoard;

    public Computer(Cpu cpu, MainBoard mainBoard) {
        this.cpu = cpu;
        this.mainBoard = mainBoard;
    }

    public Cpu getCpu() {
        return cpu;
    }

    public void setCpu(Cpu cpu) {
        this.cpu = cpu;
    }

    public MainBoard getMainBoard() {
        return mainBoard;
    }

    public void setMainBoard(MainBoard mainBoard) {
        this.mainBoard = mainBoard;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu=" + cpu.getClass().getSimpleName() +
                ", mainBoard=" + mainBoard.getClass().getSimpleName() +
                '}';
    }
}

/**
 * 抽象工厂类
 * */
interface AbstractFactory {

    /**
     * 创建CPU
     * */
    Cpu createCpu();

    /**
     * 创建主板
     * */
    MainBoard createMainBoard();

}

/**
 * Intel Factory
 * */
class IntelFactory implements AbstractFactory {

    public Cpu createCpu() {
        return new IntelCpu();
    }

    public MainBoard createMainBoard() {
        return new IntelMainBoard();
    }
}

/**
 * AMD Factory
 * */
class AmdFactory implements AbstractFactory {
    public Cpu createCpu() {
        return new AmdCpu();
    }

    public MainBoard createMainBoard() {
        return new AmdMainBorad();
    }
}

/**
 * CPU 接口
 * */
interface Cpu {
   void calculate();
}

/**
 * Intel CPU
 * */
class IntelCpu implements Cpu {
    public void calculate() {
        System.out.println("Intel CPU calculate");
    }
}

/**
 * AMD CPU
 * */
class AmdCpu implements Cpu{
    public void calculate() {
        System.out.println("AMD CPU calculate");
    }
}

/**
 * 主板
 * */
interface MainBoard {
    void installCpu(Cpu cpu);
}

/**
 * Intel MainBoard
 * */
class IntelMainBoard implements MainBoard {

    public void installCpu(Cpu cpu) {
        System.out.println("IntelMainBoard install a " + cpu.getClass().getSimpleName());
    }
}

/**
 * AMD MainBoard
 * */
class AmdMainBorad implements MainBoard {
    public void installCpu(Cpu cpu) {
        System.out.println("AMDMainBoard install a " + cpu.getClass().getSimpleName());
    }
}