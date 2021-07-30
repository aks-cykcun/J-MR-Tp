/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alipay.sofa.healthcheck.bean;

import com.alipay.sofa.healthcheck.startup.SofaBootApplicationAfterHealthCheckCallback;
import org.springframework.boot.actuate.health.Health;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author liangen
 * @version $Id: AfterHealthCheckCallbackA.java, v 0.1 2018年03月11日 下午2:40 liangen Exp $
 */
public class AfterHealthCheckCallbackB implements SofaBootApplicationAfterHealthCheckCallback {

    private static boolean mark = false;

    @Override
    public Health onHealthy(ApplicationContext applicationContext) {
        mark = true;
        return Health.up().withDetail("port", "port is ok").build();

    }

    public static boolean isMark() {
        return mark;
    }

    public static void setMark(boolean mark) {
        AfterHealthCheckCallbackB.mark = mark;
    }
}