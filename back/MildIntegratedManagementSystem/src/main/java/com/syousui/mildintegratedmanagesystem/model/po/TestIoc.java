package com.syousui.mildintegratedmanagesystem.model.po;

import org.springframework.stereotype.Component;

/**
 * @author : acmaker
 * @version : 1.0.0
 * @ClassName : TestIoc.java
 * @PackageLoaction : com.syousui.mildintegratedmanagesystem.model.po
 * @createTime : 2020-11-19 10:41:00 星期四
 * @Description : TODO
 */

@Component ()
public class TestIoc {
    private String string = "testIoc";
    private Integer integer = 1111;

    public TestIoc ( ) { }
    public TestIoc ( String string, Integer integer ) { this.string = string; this.integer = integer; }
    public String getString ( ) {
        return string;
    }
    public void setString ( String string ) {
        this.string = string;
    }
    public Integer getInteger ( ) {
        return integer;
    }
    public void setInteger ( Integer integer ) {
        this.integer = integer;
    }
    @Override
    public String toString ( ) {
        return "[ string: " + string + ", " + "integer: " + integer + " .]";
    }
}
