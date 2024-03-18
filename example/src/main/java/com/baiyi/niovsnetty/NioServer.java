package com.baiyi.niovsnetty;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * @description: nio服务端
 * @author: liaozicai
 * @date: 2024/3/5 17:47
 */
public class NioServer {
	public static void main(String[] args) throws IOException {
		// 创建对应的ServerSocketChannel
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		// 设置非阻塞
		serverSocketChannel.configureBlocking(false);
		// 创建Selector
		Selector selector = Selector.open();
		// 绑定selector
		SelectionKey selectionKey = serverSocketChannel.register(selector, 0, null);
		// 设置为接收事件
		selectionKey.interestOps(SelectionKey.OP_ACCEPT);
		// 绑定端口
		serverSocketChannel.bind(new InetSocketAddress(8000));
	}
}
