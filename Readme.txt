1.这个是使用maven整合spring，spring mvc，security的项目，里面的简单配置可以初步使用。
2.2017.5.20：在项目运行的时候报出了NoClassDefFoundError.（Could not initialize class org.springframework.jdbc.core.StatementCreatorUtils ），解决方法是把spring-jdbc-3.2.2.RELEASE.jar这个包放到lib目录下面，这个可能是maven的问题。
3.2017.5.20：问题遗留：spring secutity中的form-login标签的作用，以及标签中login-processing-url属性的作用。(未解决)
4.2017.5.21: 自定义了登陆页面，并且将只能访问webapp下的login.jsp改成了可以访问WEB-INF目录下的login.jsp的方式。（注意：使用了spring mvc或者其它的框架，就不能够直接在浏览器上面直接输入路径访问WEB-INF目录下面的资源，需要通过后台来跳转，struts2也是这个情况）