// package com.xuegao.luanqibazao_1;
//
// import java.net.InetAddress;
// import java.net.UnknownHostException;
// import java.util.Map;
// import java.util.Properties;
//
// import org.hyperic.sigar.CpuInfo;
// import org.hyperic.sigar.CpuPerc;
// import org.hyperic.sigar.FileSystem;
// import org.hyperic.sigar.FileSystemUsage;
// import org.hyperic.sigar.Mem;
// import org.hyperic.sigar.NetFlags;
// import org.hyperic.sigar.NetInterfaceConfig;
// import org.hyperic.sigar.NetInterfaceStat;
// import org.hyperic.sigar.OperatingSystem;
// import org.hyperic.sigar.Sigar;
// import org.hyperic.sigar.SigarException;
// import org.hyperic.sigar.Swap;
// import org.hyperic.sigar.Who;
//
// public class OSUtils {
//
//
//     public static void main(String[] args) {
//         try {
//             // System信息，从jvm获取
//             property();
//             System.out.println("----------------------------------");
//             // cpu信息
//             cpu();
//             System.out.println("----------------------------------");
//             // 内存信息
//             memory();
//             System.out.println("----------------------------------");
//             // 操作系统信息
//             os();
//             System.out.println("----------------------------------");
//             // 用户信息
//             who();
//             System.out.println("----------------------------------");
//             // 文件系统信息
//             file();
//             System.out.println("----------------------------------");
//             // 网络信息
//             net();
//             System.out.println("----------------------------------");
//             // 以太网信息
//             ethernet();
//             System.out.println("----------------------------------");
//         } catch (Exception e1) {
//             e1.printStackTrace();
//         }
//     }
//
//     private static void property() throws UnknownHostException {
//         Runtime r = Runtime.getRuntime();
//         Properties props = System.getProperties();
//         InetAddress addr;
//         addr = InetAddress.getLocalHost();
//         String ip = addr.getHostAddress();
//         Map<String, String> map = System.getenv();
//         String userName = map.get("USERNAME");// 获取用户名
//         String computerName = map.get("COMPUTERNAME");// 获取计算机名
//         String userDomain = map.get("USERDOMAIN");// 获取计算机域名
//         System.out.println("用户名:    " + userName);
//         System.out.println("计算机名:    " + computerName);
//         System.out.println("计算机域名:    " + userDomain);
//         System.out.println("本地ip地址:    " + ip);
//         System.out.println("本地主机名:    " + addr.getHostName());
//         System.out.println("JVM可以使用的总内存:    " + r.totalMemory());
//         System.out.println("JVM可以使用的剩余内存:    " + r.freeMemory());
//         System.out.println("JVM可以使用的处理器个数:    " + r.availableProcessors());
//         System.out.println("Java的运行环境版本：    " + props.getProperty("java.version"));
//         System.out.println("Java的运行环境供应商：    " + props.getProperty("java.vendor"));
//         System.out.println("Java供应商的URL：    " + props.getProperty("java.vendor.url"));
//         System.out.println("Java的安装路径：    " + props.getProperty("java.home"));
//         System.out.println("Java的虚拟机规范版本：    " + props.getProperty("java.vm.specification.version"));
//         System.out.println("Java的虚拟机规范供应商：    " + props.getProperty("java.vm.specification.vendor"));
//         System.out.println("Java的虚拟机规范名称：    " + props.getProperty("java.vm.specification.name"));
//         System.out.println("Java的虚拟机实现版本：    " + props.getProperty("java.vm.version"));
//         System.out.println("Java的虚拟机实现供应商：    " + props.getProperty("java.vm.vendor"));
//         System.out.println("Java的虚拟机实现名称：    " + props.getProperty("java.vm.name"));
//         System.out.println("Java运行时环境规范版本：    " + props.getProperty("java.specification.version"));
//         System.out.println("Java运行时环境规范供应商：    " + props.getProperty("java.specification.vender"));
//         System.out.println("Java运行时环境规范名称：    " + props.getProperty("java.specification.name"));
//         System.out.println("Java的类格式版本号：    " + props.getProperty("java.class.version"));
//         System.out.println("Java的类路径：    " + props.getProperty("java.class.path"));
//         System.out.println("加载库时搜索的路径列表：    " + props.getProperty("java.library.path"));
//         System.out.println("默认的临时文件路径：    " + props.getProperty("java.io.tmpdir"));
//         System.out.println("一个或多个扩展目录的路径：    " + props.getProperty("java.ext.dirs"));
//         System.out.println("操作系统的名称：    " + props.getProperty("os.name"));
//         System.out.println("操作系统的构架：    " + props.getProperty("os.arch"));
//         System.out.println("操作系统的版本：    " + props.getProperty("os.version"));
//         System.out.println("文件分隔符：    " + props.getProperty("file.separator"));
//         System.out.println("路径分隔符：    " + props.getProperty("path.separator"));
//         System.out.println("行分隔符：    " + props.getProperty("line.separator"));
//         System.out.println("用户的账户名称：    " + props.getProperty("user.name"));
//         System.out.println("用户的主目录：    " + props.getProperty("user.home"));
//         System.out.println("用户的当前工作目录：    " + props.getProperty("user.dir"));
//     }
//
//     private static void memory() throws SigarException {
//         Sigar sigar = new Sigar();
//         Mem mem = sigar.getMem();
//         // 内存总量
//         System.out.println("内存总量:    " + mem.getTotal() / 1024L + "K av");
//         // 当前内存使用量
//         System.out.println("当前内存使用量:    " + mem.getUsed() / 1024L + "K used");
//         // 当前内存剩余量
//         System.out.println("当前内存剩余量:    " + mem.getFree() / 1024L + "K free");
//         Swap swap = sigar.getSwap();
//         // 交换区总量
//         System.out.println("交换区总量:    " + swap.getTotal() / 1024L + "K av");
//         // 当前交换区使用量
//         System.out.println("当前交换区使用量:    " + swap.getUsed() / 1024L + "K used");
//         // 当前交换区剩余量
//         System.out.println("当前交换区剩余量:    " + swap.getFree() / 1024L + "K free");
//     }
//
//     private static void cpu() throws SigarException {
//         Sigar sigar = new Sigar();
//         CpuInfo infos[] = sigar.getCpuInfoList();
//         CpuPerc cpuList[] = null;
//         cpuList = sigar.getCpuPercList();
//         for (int i = 0; i < infos.length; i++) {// 不管是单块CPU还是多CPU都适用
//             CpuInfo info = infos[i];
//             System.out.println("第" + (i + 1) + "块CPU信息");
//             System.out.println("CPU的总量MHz:    " + info.getMhz());// CPU的总量MHz
//             System.out.println("CPU生产商:    " + info.getVendor());// 获得CPU的卖主，如：Intel
//             System.out.println("CPU类别:    " + info.getModel());// 获得CPU的类别，如：Celeron
//             System.out.println("CPU缓存数量:    " + info.getCacheSize());// 缓冲存储器数量
//             printCpuPerc(cpuList[i]);
//         }
//     }
//
//     private static void printCpuPerc(CpuPerc cpu) {
//         System.out.println("CPU用户使用率:    " + CpuPerc.format(cpu.getUser()));// 用户使用率
//         System.out.println("CPU系统使用率:    " + CpuPerc.format(cpu.getSys()));// 系统使用率
//         System.out.println("CPU当前等待率:    " + CpuPerc.format(cpu.getWait()));// 当前等待率
//         System.out.println("CPU当前错误率:    " + CpuPerc.format(cpu.getNice()));//
//         System.out.println("CPU当前空闲率:    " + CpuPerc.format(cpu.getIdle()));// 当前空闲率
//         System.out.println("CPU总的使用率:    " + CpuPerc.format(cpu.getCombined()));// 总的使用率
//     }
//
//     private static void os() {
//         OperatingSystem OS = OperatingSystem.getInstance();
//         // 操作系统内核类型如： 386、486、586等x86
//         System.out.println("操作系统:    " + OS.getArch());
//         System.out.println("操作系统CpuEndian():    " + OS.getCpuEndian());//
//         System.out.println("操作系统DataModel():    " + OS.getDataModel());//
//         // 系统描述
//         System.out.println("操作系统的描述:    " + OS.getDescription());
//         // 操作系统类型
//         // System.out.println("OS.getName():    " + OS.getName());
//         // System.out.println("OS.getPatchLevel():    " + OS.getPatchLevel());//
//         // 操作系统的卖主
//         System.out.println("操作系统的卖主:    " + OS.getVendor());
//         // 卖主名称
//         System.out.println("操作系统的卖主名:    " + OS.getVendorCodeName());
//         // 操作系统名称
//         System.out.println("操作系统名称:    " + OS.getVendorName());
//         // 操作系统卖主类型
//         System.out.println("操作系统卖主类型:    " + OS.getVendorVersion());
//         // 操作系统的版本号
//         System.out.println("操作系统的版本号:    " + OS.getVersion());
//     }
//
//     private static void who() throws SigarException {
//         Sigar sigar = new Sigar();
//         Who who[] = sigar.getWhoList();
//         if (who != null && who.length > 0) {
//             for (int i = 0; i < who.length; i++) {
//                 // System.out.println("当前系统进程表中的用户名" + String.valueOf(i));
//                 Who _who = who[i];
//                 System.out.println("用户控制台:    " + _who.getDevice());
//                 System.out.println("用户host:    " + _who.getHost());
//                 // System.out.println("getTime():    " + _who.getTime());
//                 // 当前系统进程表中的用户名
//                 System.out.println("当前系统进程表中的用户名:    " + _who.getUser());
//             }
//         }
//     }
//
//     private static void file() throws Exception {
//         Sigar sigar = new Sigar();
//         FileSystem fslist[] = sigar.getFileSystemList();
//         try {
//             for (int i = 0; i < fslist.length; i++) {
//                 System.out.println("分区的盘符名称" + i);
//                 FileSystem fs = fslist[i];
//                 // 分区的盘符名称
//                 System.out.println("盘符名称:    " + fs.getDevName());
//                 // 分区的盘符名称
//                 System.out.println("盘符路径:    " + fs.getDirName());
//                 System.out.println("盘符标志:    " + fs.getFlags());//
//                 // 文件系统类型，比如 FAT32、NTFS
//                 System.out.println("盘符类型:    " + fs.getSysTypeName());
//                 // 文件系统类型名，比如本地硬盘、光驱、网络文件系统等
//                 System.out.println("盘符类型名:    " + fs.getTypeName());
//                 // 文件系统类型
//                 System.out.println("盘符文件系统类型:    " + fs.getType());
//                 FileSystemUsage usage = null;
//                 usage = sigar.getFileSystemUsage(fs.getDirName());
//                 switch (fs.getType()) {
//                     case 0: // TYPE_UNKNOWN ：未知
//                         break;
//                     case 1: // TYPE_NONE
//                         break;
//                     case 2: // TYPE_LOCAL_DISK : 本地硬盘
//                         // 文件系统总大小
//                         System.out.println(fs.getDevName() + "总大小:    " + usage.getTotal() + "KB");
//                         // 文件系统剩余大小
//                         System.out.println(fs.getDevName() + "剩余大小:    " + usage.getFree() + "KB");
//                         // 文件系统可用大小
//                         System.out.println(fs.getDevName() + "可用大小:    " + usage.getAvail() + "KB");
//                         // 文件系统已经使用量
//                         System.out.println(fs.getDevName() + "已经使用量:    " + usage.getUsed() + "KB");
//                         double usePercent = usage.getUsePercent() * 100D;
//                         // 文件系统资源的利用率
//                         System.out.println(fs.getDevName() + "资源的利用率:    " + usePercent + "%");
//                         break;
//                     case 3:// TYPE_NETWORK ：网络
//                         break;
//                     case 4:// TYPE_RAM_DISK ：闪存
//                         break;
//                     case 5:// TYPE_CDROM ：光驱
//                         break;
//                     case 6:// TYPE_SWAP ：页面交换
//                         break;
//                 }
//                 System.out.println(fs.getDevName() + "读出：    " + usage.getDiskReads());
//                 System.out.println(fs.getDevName() + "写入：    " + usage.getDiskWrites());
//             }
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//
//         return;
//     }
//
//     private static void net() throws Exception {
//         Sigar sigar = new Sigar();
//         String ifNames[] = sigar.getNetInterfaceList();
//         for (int i = 0; i < ifNames.length; i++) {
//             String name = ifNames[i];
//             NetInterfaceConfig ifconfig = sigar.getNetInterfaceConfig(name);
//             System.out.println("网络设备名:    " + name);// 网络设备名
//             System.out.println("IP地址:    " + ifconfig.getAddress());// IP地址
//             System.out.println("子网掩码:    " + ifconfig.getNetmask());// 子网掩码
//             if ((ifconfig.getFlags() & 1L) <= 0L) {
//                 System.out.println("!IFF_UP...skipping getNetInterfaceStat");
//                 continue;
//             }
//             NetInterfaceStat ifstat = sigar.getNetInterfaceStat(name);
//             System.out.println(name + "接收的总包裹数:" + ifstat.getRxPackets());// 接收的总包裹数
//             System.out.println(name + "发送的总包裹数:" + ifstat.getTxPackets());// 发送的总包裹数
//             System.out.println(name + "接收到的总字节数:" + ifstat.getRxBytes());// 接收到的总字节数
//             System.out.println(name + "发送的总字节数:" + ifstat.getTxBytes());// 发送的总字节数
//             System.out.println(name + "接收到的错误包数:" + ifstat.getRxErrors());// 接收到的错误包数
//             System.out.println(name + "发送数据包时的错误数:" + ifstat.getTxErrors());// 发送数据包时的错误数
//             System.out.println(name + "接收时丢弃的包数:" + ifstat.getRxDropped());// 接收时丢弃的包数
//             System.out.println(name + "发送时丢弃的包数:" + ifstat.getTxDropped());// 发送时丢弃的包数
//         }
//     }
//
//     private static void ethernet() throws SigarException {
//         Sigar sigar = null;
//         sigar = new Sigar();
//         String[] ifaces = sigar.getNetInterfaceList();
//         for (int i = 0; i < ifaces.length; i++) {
//             NetInterfaceConfig cfg = sigar.getNetInterfaceConfig(ifaces[i]);
//             if (NetFlags.LOOPBACK_ADDRESS.equals(cfg.getAddress()) || (cfg.getFlags() & NetFlags.IFF_LOOPBACK) != 0
//                     || NetFlags.NULL_HWADDR.equals(cfg.getHwaddr())) {
//                 continue;
//             }
//             System.out.println(cfg.getName() + "IP地址:" + cfg.getAddress());// IP地址
//             System.out.println(cfg.getName() + "网关广播地址:" + cfg.getBroadcast());// 网关广播地址
//             System.out.println(cfg.getName() + "网卡MAC地址:" + cfg.getHwaddr());// 网卡MAC地址
//             System.out.println(cfg.getName() + "子网掩码:" + cfg.getNetmask());// 子网掩码
//             System.out.println(cfg.getName() + "网卡描述信息:" + cfg.getDescription());// 网卡描述信息
//             System.out.println(cfg.getName() + "网卡类型" + cfg.getType());//
//         }
//     }
// }
// 1
//         2
//         3
//         4
//         5
//         6
//         7
//         8
//         9
//         10
//         11
//         12
//         13
//         14
//         15
//         16
//         17
//         18
//         19
//         20
//         21
//         22
//         23
//         24
//         25
//         26
//         27
//         28
//         29
//         30
//         31
//         32
//         33
//         34
//         35
//         36
//         37
//         38
//         39
//         40
//         41
//         42
//         43
//         44
//         45
//         46
//         47
//         48
//         49
//         50
//         51
//         52
//         53
//         54
//         55
//         56
//         57
//         58
//         59
//         60
//         61
//         62
//         63
//         64
//         65
//         66
//         67
//         68
//         69
//         70
//         71
//         72
//         73
//         74
//         75
//         76
//         77
//         78
//         79
//         80
//         81
//         82
//         83
//         84
//         85
//         86
//         87
//         88
//         89
//         90
//         91
//         92
//         93
//         94
//         95
//         96
//         97
//         98
//         99
//         100
//         101
//         102
//         103
//         104
//         105
//         106
//         107
//         108
//         109
//         110
//         111
//         112
//         113
//         114
//         115
//         116
//         117
//         118
//         119
//         120
//         121
//         122
//         123
//         124
//         125
//         126
//         127
//         128
//         129
//         130
//         131
//         132
//         133
//         134
//         135
//         136
//         137
//         138
//         139
//         140
//         141
//         142
//         143
//         144
//         145
//         146
//         147
//         148
//         149
//         150
//         151
//         152
//         153
//         154
//         155
//         156
//         157
//         158
//         159
//         160
//         161
//         162
//         163
//         164
//         165
//         166
//         167
//         168
//         169
//         170
//         171
//         172
//         173
//         174
//         175
//         176
//         177
//         178
//         179
//         180
//         181
//         182
//         183
//         184
//         185
//         186
//         187
//         188
//         189
//         190
//         191
//         192
//         193
//         194
//         195
//         196
//         197
//         198
//         199
//         200
//         201
//         202
//         203
//         204
//         205
//         206
//         207
//         208
//         209
//         210
//         211
//         212
//         213
//         214
//         215
//         216
//         217
//         218
//         219
//         220
//         221
//         222
//         223
//         224
//         225
//         226
//         227
//         228
//         229
//         230
//         231
//         232
//         233
//         234
//         235
//         236
//         237
//         238
//         239
//         240
//         241
//         242
//         243
//         244
//         245
//         246
//         247
//         248
//         249
//         250
//         251
//         252
//         253
//         254
//         255
//         256
//         257
//         258
//         259
//         260
//         261
//         262
//         263
//         264
//         265
//         266
//         267
//         268
//         269
//         270
//         271
//         272
//         273
//         274
//         275
//         276
//         277
//         278
//         279
//         280
//         281
//         282
