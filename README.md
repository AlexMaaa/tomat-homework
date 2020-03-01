# tomat-homework

打好了demo1.jar包，方在server下的webapps文件夹中； 需要将webapps文件夹放置在E盘下，或者修改server.xml中的appBase属性为demo1的绝对路径

访问路径为：http://localhost:8080/demo1/demo1

封装的Mapper等在Mapper下 封装Mapper代码在Bootstrap.loadServlet()的213行开始，这里读取了jar包中的web.xml
