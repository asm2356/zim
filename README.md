# zim
netty 集群 即时通讯https://github.com/asm2356/zim

web端地址说明 :https://github.com/asm2356/zim-web

**功能说明:**

1. 点对点聊天
2. 普通文本和小文件传输
3. 上下线通知，聊天记录保存，好友添加验证，登录账号冲突监测，聊天消息提醒通知，登录重试机制

**产品技术选型：**

1. **前端:**  vue,iview,protobufjs,axios
2. **后端:**  mysql, redis, netty,springboot,rabbitmq
3. **部署**:  nginx

**模块说明:**

1. **zim-client:**  java 客户端 (正在开发，主要是为了支持android)
2. **zim-common**: 通用模块
3. **zim-file-client**：连接文件服务器的客户端
4. **zim-file-server**: 文件服务器
5. **zim-server**: 通信的服务
6. **zim-web**: websocket 前端



