/*
 * Copyright (c) 2016 The Jupiter Project
 *
 * Licensed under the Apache License, version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jupiter.example.generic;

import org.jupiter.rpc.DefaultClient;
import org.jupiter.rpc.JClient;
import org.jupiter.rpc.model.metadata.ServiceMetadata;
import org.jupiter.transport.Directory;
import org.jupiter.transport.JConnector;
import org.jupiter.transport.channel.CopyOnWriteGroupList;
import org.jupiter.transport.channel.JChannel;
import org.jupiter.transport.channel.JChannelGroup;
import org.jupiter.transport.exception.ConnectFailedException;
import org.jupiter.transport.netty.JNettyTcpConnector;

import java.util.List;

/**
 * jupiter
 * org.jupiter.example.generic
 *
 * @author jiachun.fjc
 */
public class GenericJupiterClient {

    public static void main(String[] args) {
        Directory directory = new ServiceMetadata("test", "GenericServiceTest", "1.0.0.daily");

        JClient client = new DefaultClient().withConnector(new JNettyTcpConnector());
        // 连接RegistryServer
        client.connectToRegistryServer("127.0.0.1:20011");
        // 自动管理可用连接
        JConnector.ConnectionWatcher watcher = client.watchConnections(directory);
        // 等待连接可用
        if (!watcher.waitForAvailable(3000)) {
            throw new ConnectFailedException();
        }

        System.out.println("连接已经可用");
        CopyOnWriteGroupList directory1 = client.connector().directory(directory);
        JChannelGroup[] snapshot =directory1.getSnapshot();
        if(snapshot.length>0){
            JChannelGroup jChannelGroup = snapshot[0];
            List<? extends JChannel> channels = jChannelGroup.channels();
            System.out.println(channels.size());
        }

//        GenericInvoker invoker = GenericProxyFactory.factory()
//                .client(client)
//                .directory(directory)
//                .invokeType(InvokeType.ASYNC)
//                .newProxyInstance();
//
//        try {
//            Object result = invoker.$invoke("sayHello", "Luca");
//            System.out.println(result);
//            InvokeFuture<Object> future = InvokeFutureContext.future(Object.class);
//            System.out.println(future.getResult());
//            System.out.println("结果来了");
//        } catch (Throwable e) {
//            e.printStackTrace();
//        }
//


    }
}
