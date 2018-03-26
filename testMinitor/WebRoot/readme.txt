springmvc项目创建步骤：
①导入springmvcjar包
②配置web.xml：
  1、 <servlet>
     <servlet-name>welcome</servlet-name>
     <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
     <!-- 指servlet配置文件启动的优先顺序，写大于0的正整数，越小越优先 -->
     <load-on-startup>1</load-on-startup>
     </servlet>
     
      <servlet-mapping>
      <servlet-name>welcome</servlet-name>
      <!-- 这里写/是指，根目录下所有请求都将被DispatcherServlet拦截 -->
      <url-pattern>/</url-pattern>
      </servlet-mapping>
  2、新建springmvc配置文件
     META-INF下新建xml文件，命名规则：要以web.xml里面<servlet-name>里写的名字开头
     ，如果写的是welcome，那么名字就命名为welcome-servlet.xml,web.xml里写的
     <load-on-startup>就是优先加载此文件
  3、编辑springmvc配置文件
      ①在spring-framework-3.2.1.RELEASE\docs\spring-framework-reference\html
      下的mvc.html里找到配置xml配置文件的代码
      <?xml version="1.0" encoding="UTF-8"?>
      <beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:p="http://www.springframework.org/schema/p"
    xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="
        http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd">
        </beans>
        ②除此之外，还要加上mvc的配置，在上面的文档上找到
        xmlns:mvc="http://www.springframework.org/schema/mvc
             还有下面的：
        http://www.springframework.org/schema/mvc
        http://www.springframework.org/schema/mvc/spring-mvc.xsd
             加到刚刚配置的springmvc的配置文件中
  4、配置handlerMapping,如果是myeclipse，在navigate点击open type，搜索
      HandlerMapping，一定是spring-webmvc-3.2.1.RELEASE.jar里的，查看源码
  5、现在用springmvc默认的BeanNameUrlHandlerMapping来开发（此方法已启用），
     在springmvc配置文件(welcome-servlet.xml)里配置:
     <bean class="org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping"></bean> 
  6、在配置文件 welcome-servlet.xml里配置bean name，配置url，找到对应的control
  <bean name="/welcome" class="com.will.controller.WelcomeController"></bean>
  7、新建controller类WelcomeController,继承AbstractController,重写handleRequest方法，返回一个
     逻辑视图名
     public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("welcome,springMVC!");
		return new ModelAndView("welcome");  //这里返回一个逻辑视图名
		
	}
   8、   在welcome-servlet.xml中配置试图解析器，在open type里搜索InternalResourceViewResolver，
    进而配置  
  
        
        
        
        
        
        
        
        
        