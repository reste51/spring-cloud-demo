namespace java com.imooc.thrift.message
namespace py message.api  #   python / Java 的代码， 放到 对应的包名

service MessageService {
    # 1: 第一个参数，  参数类型   参数名
    bool sendMobileMessage(1:string mobile, 2:string message);

    bool sendEmailMessage(1:string email, 2:string message);

}
