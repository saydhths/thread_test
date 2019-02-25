## Servlet知识回顾
### Servlet的生命周期
* init():初始化
  * 只调用一次
  * 当调用一个Servlet时，就会创建一个Servlet实例，每个用户请求都会产生一个新的线程
* service(): 处理HTTP请求
  * 
* destory(): 
  * 只调用一次，在Servlet生命周期结束时被调用
  * 可以在该方法内关闭数据库链接等释放资源的操作；
  * 在调用完该方法后，Servlet对象被标记为无用对象，被垃圾回收。
### Servlet实例
~~~java
@WebServlet("/helloServlet")
public class HelloServlet extends HttpServlet{
    
    public void service(HttpServletRequest req, HttpServletResponse resp){
        // 初始化方法
        public void init() throws ServletException{
            
        }
        
        // 处理POST请求
        public void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException{
            doGet(req, resp);
        }
        
         // 处理GET请求
         // URL: http://localhost:8080/helloServlet?name=dht&country=China
         public void doGet(HttpServletRequest req, HttpServletResponse resp) 
             throws ServletException, IOException{
             // 设置响应类型
             resp.setContentType("text/html;charset=UTF-8");
             
             // 获取表单参数值
             req.getParameter("name");
             req.getParameter("country");
             
             // 获取响应输出流
             PrintWriter pw = resp.getWriter();
             pw.print("输出到页面");
                     
         }
    }
    
}
~~~
XML配置
~~~xml
<web-app>
    <servlet>
        <servlet-name>HelloServlet</servlet-name>
        <servlet-class>HelloServlet</servlet-class>
    </servlet>
    
    <servlet-mapping>
        <servlet-name>HelloServlet</servlet-name>
        <url-pattern>/helloServlet</url-pattern>
    </servlet-mapping>
</web-app>
~~~


