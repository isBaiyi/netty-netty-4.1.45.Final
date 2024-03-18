package com.baiyi.niovsnetty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @description: netty服务端
 * @author: liaozicai
 * @date: 2024/3/5 17:52
 */
public class NettyServer {
	public static void main(String[] args) {
		// 创建ServerBootStrap
		ServerBootstrap serverBootstrap = new ServerBootstrap();
		// 绑定NioServerSocketChannel相当于绑定了ServerSocketChannel
		serverBootstrap.channel(NioServerSocketChannel.class);
		// 设置NioEventLoopGroup，用于处理连接和读写请求
        serverBootstrap.group(new NioEventLoopGroup());
		// 绑定channelHandler
		serverBootstrap.childHandler(new ChannelInitializer<NioSocketChannel>() {
			@Override
			protected void initChannel(NioSocketChannel ch) throws Exception {
				System.out.println("客户端连接进来了");
			}
		});
		// 绑定端口，开始接收进来的连接
		serverBootstrap.bind(8000);
	}
}
