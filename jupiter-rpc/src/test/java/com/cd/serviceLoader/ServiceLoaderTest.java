package com.cd.serviceLoader;/**
 * Created by DELL on 2018/8/14.
 */

import org.junit.Test;
import org.jupiter.common.util.JServiceLoader;
import org.jupiter.rpc.JFilter;

import java.util.List;

/**
 * user is lwb
 **/


public class ServiceLoaderTest {

    @Test
    public void loadeFilter(){
        List<JFilter> sortedList = JServiceLoader.load(JFilter.class).sort();
        System.out.println(sortedList);
    }

}
