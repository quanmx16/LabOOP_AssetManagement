/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bmlt.lib;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Dell
 */
public class CurrentTime {

    public static LocalDateTime getCurrentTime() {
        LocalDateTime current = LocalDateTime.now();

        return current;
    }
}
