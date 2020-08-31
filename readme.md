## Spring基础1

### IOC: 控制反转  

将创建类的权力交给spring  

### DI: 依赖注入  

依赖注入的前提是IOC  

### 工厂类介绍
BeanFactory 老版本的工厂类,懒加载    

ApplicationContext 新版本的工厂类，非懒加载  

### bean的作用范围
@Scope 的使用   

singleton  
prototype  
request  
session  
globalsession  

### @Configuration @Component的区别

在配置类的方法间调用时，如果类时@component标注的，每次调用获取的都是新的；而如果是@configuration标注的话，每次调用返回的是同一个实体Bean。其他方面都是相同，可以无差别使用（装配注入等）  

哪是什么原因造成的呢？  
	因为@Configuration标注下的@Bean调用函数使用都是代理对象，获取的都是从IOC容器里获取的bean，因此都是同一个。而@Component标注下的@Bean下只是普通的函数方法调用。下面来看一下@configuration注册@Bean生成代理的过程    

详细请看 --->> https://blog.csdn.net/qq_38951372/article/details/89345134  




  