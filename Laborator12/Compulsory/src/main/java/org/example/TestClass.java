package org.example;

import annotations.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tudor Onofrei
 */
public class TestClass {

    @Test
    public static void firstMethod() {
        throw new RuntimeException("Here comes a crash,be ready! BOOM!");
    }

    public static void secondMethod() {
    }

    @Test
    public static void thirdMethod() {
        throw new RuntimeException("Another crash,you ok?");
    }

    public static void forthMethod() {
    }

    @Test
    public static void fifthMethod() {

    }

    public static void sixthMethod() {
    }

    @Test
    public static void sevenMethod() {

    }

    public static void eighthMethod() {
        throw new RuntimeException("BAAM! You've done it again! -.-'");
    }
}
