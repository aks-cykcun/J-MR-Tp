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
package com.alipay.sofa.rpc.boot.test.mesh;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.junit4.SpringRunner;

import com.alipay.sofa.rpc.boot.test.ActivelyDestroyTest;
import com.alipay.sofa.rpc.boot.test.bean.SampleService;
import com.alipay.sofa.rpc.boot.test.bean.invoke.HelloSyncService;
import com.alipay.sofa.rpc.core.exception.SofaRpcException;

/**
 * @author zhiyuan.lzy
 * @version $Id: MeshTest.java, v 0.1 2018-06-25 19:26 zhiyuan.lzy Exp $$
 * you should change mesh address to test
 */
@SpringBootApplication
@SpringBootTest(properties = { "com.alipay.sofa.rpc.registries.mesh=mesh://127.0.0.1:13330",
                              "com.alipay.sofa.rpc.enable.mesh=bolt" }, classes = MeshTest.class)
@RunWith(SpringRunner.class)
@ImportResource("/spring/test_only_mesh.xml")
@Ignore
public class MeshTest extends ActivelyDestroyTest {

    @Resource(name = "helloSyncConsumerMesh")
    private HelloSyncService helloSyncConsumerMesh;

    @Autowired
    private SampleService    sampleService;

    @Test
    @Ignore("????????? mesh ??????")
    public void testInvokeWithMesh() throws InterruptedException {

        try {
            String result = sampleService.echoStr("sync");
            System.out.println("mesh:" + result);
        } catch (Exception e) {
            e.printStackTrace();
            assertEquals(SofaRpcException.class, e.getClass());
        }
    }

}
