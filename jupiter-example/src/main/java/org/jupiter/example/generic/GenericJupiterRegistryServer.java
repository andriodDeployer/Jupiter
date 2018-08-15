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

import org.jupiter.monitor.MonitorServer;
import org.jupiter.registry.RegistryServer;

/**
 * jupiter
 * org.jupiter.example.generic
 *
 * @author jiachun.fjc
 */
public class GenericJupiterRegistryServer {

    public static void main(String[] args) {
        RegistryServer registryServer = RegistryServer.Default.createRegistryServer(20011, 1);      // 注册中心
        MonitorServer monitor = new MonitorServer(19998);                                           // 监控服务
        try {
            monitor.setRegistryMonitor(registryServer);
            monitor.start();
            registryServer.startRegistryServer();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
