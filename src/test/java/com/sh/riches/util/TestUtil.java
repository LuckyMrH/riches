/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sh.riches.util;

/**
 *
 * @author Steve
 */
public class TestUtil {

    public static String createTestTitle(String title) {
        StringBuilder sb = new StringBuilder("========== ");
        sb.append("Test ").append(title);
        sb.append("========== ");
        return sb.toString();
    }

    private TestUtil() {
    }
}
