package ru.psyfabriq;

import ru.psyfabriq.part1.PingPong;
import ru.psyfabriq.part2.CounterExample;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // Part 1
        PingPong ping = new PingPong("PING");
        PingPong pong = new PingPong("PONG");

        // ping.start();
        // pong.start();

        // Part 2

        new CounterExample();

    }

}
