## 1、加载报错
> ### IllegalStateException: ApplicationEventMulticaster not initialized
>> 16:55:00.355 [main] ERROR org.springframework.beans.factory.support.DefaultListableBeanFactory - Destroy method on bean with name 'org.springframework.boot.autoconfigure.internalCachingMetadataReaderFactory' threw an exception
  java.lang.IllegalStateException: ApplicationEventMulticaster not initialized - call 'refresh' before multicasting events via the context: org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@4233e892: startup date [Thu Nov 29 16:55:00 CST 2018]; root of context hierarchy
  Error creating bean with name 'org.springframework.context.annotation.internalConfigurationAnnotationProcessor'
>>> a.在pom.xml中，parent和dependencyManagement配置了重复的启动依赖
  
>>> 集成日志输出组件出错 ：http://www.spring4all.com/article/257