package com.example.processengine.controller;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhuliangxuan
 * @date 2021/8/29 21:56
 */
@RestController
public class ProcessController {

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @GetMapping("/process")
    public void test() {
        // 部署流程
         Deployment deploy = repositoryService.createDeployment().addClasspathResource("process/test3.bpmn").deploy();

        // 获取流程定义
        ProcessDefinition definition = repositoryService.createProcessDefinitionQuery().deploymentId(deploy.getId()).singleResult();

        // 启动流程实例
        ProcessInstance instance = runtimeService.startProcessInstanceById(definition.getId());
        String id = instance.getId();
        String name = instance.getName();
        System.out.println("流程创建成功，流程id="+id+",name="+name);

        Task task = taskService.createTaskQuery().processInstanceId(id).singleResult();
        System.out.println("第一次执行前，任务名称="+task.getName());
        taskService.complete(task.getId());

        task = taskService.createTaskQuery().processInstanceId(id).singleResult();
        System.out.println("第二次执行前，任务名称="+task.getName());
        taskService.complete(task.getId());

        task = taskService.createTaskQuery().processInstanceId(id).singleResult();
        System.out.println("任务执行完成，task="+task);
    }

    public static void main(String[] args) {

    }
}
