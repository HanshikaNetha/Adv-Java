package org.example.bean_scope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class BeanScopeMain {
    public static void main(String[] args){
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(BeanScopeConfig.class);
        SingletonBean singletonBean=context.getBean(SingletonBean.class);
        SingletonBean singletonBean1=context.getBean(SingletonBean.class);
        System.out.println(singletonBean);
        System.out.println(singletonBean1);
        System.out.println(singletonBean1==singletonBean);

        PrototyoeBean prototyoeBean=context.getBean(PrototyoeBean.class);
        PrototyoeBean prototyoeBean1=context.getBean(PrototyoeBean.class);
        System.out.println(prototyoeBean);
        System.out.println(prototyoeBean1);
        System.out.println(prototyoeBean==prototyoeBean1);
    }
}
