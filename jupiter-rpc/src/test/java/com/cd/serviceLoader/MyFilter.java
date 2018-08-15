package com.cd.serviceLoader;/**
 * Created by DELL on 2018/8/14.
 */

import org.jupiter.rpc.JFilter;
import org.jupiter.rpc.JFilterChain;
import org.jupiter.rpc.JFilterContext;
import org.jupiter.rpc.JRequest;

/**
 * user is
 **/


public class MyFilter implements JFilter {
    @Override
    public Type getType() {
        return null;
    }

    @Override
    public <T extends JFilterContext> void doFilter(JRequest request, T filterCtx, JFilterChain next) throws Throwable {

    }
}
