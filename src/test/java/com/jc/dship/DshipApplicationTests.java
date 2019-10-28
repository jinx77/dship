package com.jc.dship;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class DshipApplicationTests {

    @Test
    public void contextLoads() throws IOException {

        //建立tcp的服务
        //Socket socket  = new Socket(InetAddress.getLocalHost(),9090);
        Socket socket  = new Socket("183.62.75.68",22);
        //获取到Socket的输出流对象
        OutputStream outputStream = socket.getOutputStream();
        //利用输出流对象把数据写出即可。
        String s="<?xml version=\"1.0\" encoding=\"GBK\"?>\n" +
                "<Result>\n" +
                "    <OrderNumber>ZXLKF0320160326TV001</OrderNumber>\n" +
                "    <AcctNo>11014891204004</AcctNo>\n" +
                "    <BusiType>00000</BusiType>\n" +
                "    <CorpId>E000070730</CorpId>\n" +
                "    <CcyCode>RMB</CcyCode>\n" +
                "    <TranAmount>30</TranAmount>\n" +
                "    <InAcctNo>6216262000015318974</InAcctNo>\n" +
                "    <InAcctName>PA测试38735</InAcctName>\n" +
                "    <InAcctBankName>平安银行</InAcctBankName>\n" +
                "    <InAcctBankNode></InAcctBankNode>\n" +
                "    <Mobile></Mobile>\n" +
                "    <Remark>代发工资</Remark>\n" +
                "</Result>\n";
        outputStream.write(s.getBytes());
        //获取到输入流对象，读取服务端回送的数据。
        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int length = inputStream.read(buf);
        System.out.println("客户端接收到的数据："+ new String(buf,0,length));
        //关闭资源
        socket.close();
    }


    @Test
    public void contextLoads2() {

        String url="http://183.62.75.68:22/FILE01";
        RestTemplate restTemplate=new RestTemplate();
        String response= restTemplate.getForObject(url, String.class);
        log.info(response);
    }


}
