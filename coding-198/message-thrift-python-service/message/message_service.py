# coding: utf-8
from message.api import MessageService
from thrift.transport import TSocket
from thrift.transport import TTransport
from thrift.protocol import TBinaryProtocol
from thrift.server import TServer

import smtplib
from email.mime.text import MIMEText
from email.header import Header

sender = 'imoocd@163.com'
authCode = 'aA111111'
class MessageServiceHandler:

    # 发送短信
    def sendMobileMessage(self, mobile, message):
        print ("sendMobileMessage, mobile:"+mobile+", message:"+message)
        return True

    # 发送邮件
    def sendEmailMessage(self, email, message):
        print ("sendEmailMessage, email:"+email+", message:"+message)
        messageObj = MIMEText(message, "plain", "utf-8")
        messageObj['From'] = sender
        messageObj['To'] = email
        messageObj['Subject'] = Header('慕课网邮件', 'utf-8')
        try:
            smtpObj = smtplib.SMTP('smpt.163.com')
            smtpObj.login(sender, authCode)
            smtpObj.sendmail(sender, [email], messageObj.as_string())
            print ("send mail success")
            return True
        except smtplib.SMTPException:
            print ("send mail failed!")
            return False

if __name__ == '__main__':
    # 对接 thrift 通讯
    handler = MessageServiceHandler()
    processor = MessageService.Processor(handler)
    # 监听端口号为 9090
    transport = TSocket.TServerSocket(None, "9090")
    # 传输方式_ 帧方式
    tfactory = TTransport.TFramedTransportFactory()
    # 二进制的传输协议
    pfactory = TBinaryProtocol.TBinaryProtocolFactory()

    #  服务器的实例
    server = TServer.TSimpleServer(processor, transport, tfactory, pfactory)
    print ("python thrift server start")
    server.serve()
    print ("python thrift server exit")
