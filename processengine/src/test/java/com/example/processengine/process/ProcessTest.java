package com.example.processengine.process;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

import java.util.List;

/**
 * @author zhuliangxuan
 * @date 2021/8/29 11:39
 */
public class ProcessTest {

    @Test
    public void createTable() {
        ProcessEngineConfiguration configuration = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
        configuration.setJdbcUrl("jdbc:mysql://localhost:3306/era_process?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC");
        configuration.setJdbcDriver("com.mysql.cj.jdbc.Driver");
        configuration.setJdbcUsername("root");
        configuration.setJdbcPassword("zhu123456");
        configuration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        ProcessEngine engine = configuration.buildProcessEngine();
        System.out.println(engine);
    }

    @Test
    public void createTable2() {
        ProcessEngineConfiguration configuration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml");
        ProcessEngine engine = configuration.buildProcessEngine();
        System.out.println(engine);
    }

    @Test
    public void deployTest() {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        Deployment deploy = engine.getRepositoryService()
                .createDeployment()
                .addClasspathResource("tmp/test.bpmn")
                .addClasspathResource("tmp/test.png")
                .deploy();
        System.out.println(deploy.getId());
        System.out.println(deploy.getName());
    }

    @Test
    public void processTest() {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        ProcessInstance instance = engine.getRuntimeService().startProcessInstanceById("PROCESS_1:1:4");
        System.out.println(instance.getId());
    }

    @Test
    public void taskTest() {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        List<Task> list = engine.getTaskService().createTaskQuery().list();
        list.forEach(System.out::println);
    }
}
