package com.testinstanfit.daniel;

import com.testinstanfit.app.utils.TYPE_VIEW_LIST;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class TestInstanFit {
    @Test
    public void addition_isCorrect() throws Exception {
        TYPE_VIEW_LIST typeList = TYPE_VIEW_LIST.LIST;
        TYPE_VIEW_LIST typeGrid = TYPE_VIEW_LIST.GRID;
        assertEquals("LIST",typeList.name());

        assertEquals("GRID",typeGrid.name());


    }
}