package com.migu.schedule;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.migu.schedule.constants.ReturnCodeKeys;
import com.migu.schedule.info.TaskInfo;

public class ScheduleTest
    {
    /**
     * TaskSchedule实例
     */
    private Schedule schedule = new Schedule();
    
    /** 测试调度方案是否符合
     * 
     * @param expecteds 期望的测试结果
     * @param actual 实际返回结果
     */
    void assertPlanEqual(int expecteds[][], List<TaskInfo> actual)
    {
        Assert.assertEquals(expecteds.length, actual.size());
        
        for (int i = 0; i < actual.size(); i++)
        {
            Assert.assertEquals(expecteds[i][0], actual.get(i).getTaskId());
            Assert.assertEquals(expecteds[i][1], actual.get(i).getNodeId());
        }
    }
    
    @Test
    public void testInit()
    {
        int actual = schedule.init();
        Assert.assertEquals(ReturnCodeKeys.E001, actual);
    }
    
    @Test
    public void testRegisterNode1()
    {
        int actual = schedule.init();
        actual = schedule.registerNode(1);
        Assert.assertEquals(ReturnCodeKeys.E003, actual);
    }
    
    @Test
    public void testRegisterNode2()
    {
        int actual = schedule.init();
        actual = schedule.registerNode(-1);
        Assert.assertEquals(ReturnCodeKeys.E004, actual);
    }
    
    @Test
    public void testRegisterNode3()
    {
        int actual = schedule.init();
        actual = schedule.registerNode(1);
        actual = schedule.registerNode(1);
        Assert.assertEquals(ReturnCodeKeys.E005, actual);
    }
    
    @Test
    public void testUnregisterNode1()
    {
        int actual = schedule.init();
        actual = schedule.registerNode(1);
        actual = schedule.unregisterNode(1);
        Assert.assertEquals(ReturnCodeKeys.E006, actual);
    }
    
    @Test
    public void testUnregisterNode2()
    {
        int actual = schedule.init();
        actual = schedule.registerNode(1);
        actual = schedule.unregisterNode(2);
        Assert.assertEquals(ReturnCodeKeys.E007, actual);
    }
    
    @Test
    public void testAddTask0()
    {
        int actual = schedule.init();
        actual = schedule.registerNode(1);
        actual = schedule.addTask(1, 10);
        Assert.assertEquals(ReturnCodeKeys.E008, actual);
    }
    
    @Test
    public void testAddTask1()
    {
        int actual = schedule.init();
        actual = schedule.registerNode(1);
        actual = schedule.addTask(0, 10);
        Assert.assertEquals(ReturnCodeKeys.E009, actual);
    }

    @Test
    public void testAddTask2()
    {
        int actual = schedule.init();
        actual = schedule.registerNode(1);
        actual = schedule.addTask(1, 10);
        actual = schedule.addTask(1, 10);
        Assert.assertEquals(ReturnCodeKeys.E010, actual);
    }
    
    @Test
    public void testDeleteTask0()
    {
        int actual = schedule.init();
        actual = schedule.registerNode(1);
        actual = schedule.addTask(1, 10);
        actual = schedule.deleteTask(1);
        Assert.assertEquals(ReturnCodeKeys.E011, actual);
    }
    
    @Test
    public void testDeleteTask1()
    {
        int actual = schedule.init();
        actual = schedule.registerNode(1);
        actual = schedule.addTask(1, 10);
        actual = schedule.deleteTask(2);
        Assert.assertEquals(ReturnCodeKeys.E012, actual);
    }

    @Test
    public void testScheduleTask0()
    {
        int actual = schedule.init();
        schedule.registerNode(7);
        schedule.registerNode(1);
        schedule.registerNode(6);
        
        schedule.addTask(1, 2);
        schedule.addTask(2, 14);
        schedule.addTask(3, 4);
        schedule.addTask(4, 16);
        schedule.addTask(5, 6);
        schedule.addTask(6, 5);
        schedule.addTask(7, 3);
        
        actual = schedule.scheduleTask(10);
        
        Assert.assertEquals(ReturnCodeKeys.E013, actual);
        
        List<TaskInfo> tasks = new ArrayList<TaskInfo>();
        
        actual = schedule.queryTaskStatus(tasks);
        
        Assert.assertEquals(ReturnCodeKeys.E015, actual);
        
        int expecteds[][] = { 
            {1, 7}, 
            {2, 6}, 
            {3, 7}, 
            {4, 1}, 
            {5, 7}, 
            {6, 7}, 
            {7, 6}};
        
        assertPlanEqual(expecteds, tasks);
    }
    
    @Test
    public void testScheduleTask1()
    {
        int actual = schedule.init();
        actual = schedule.registerNode(1);
        actual = schedule.registerNode(3);
        
        actual = schedule.addTask(1, 30);
        actual = schedule.addTask(2, 30);
        actual = schedule.addTask(3, 30);
        actual = schedule.addTask(4, 30);
        
        actual = schedule.scheduleTask(10);
        
        Assert.assertEquals(ReturnCodeKeys.E013, actual);
        
        List<TaskInfo> tasks = new ArrayList<TaskInfo>();
        
        actual = schedule.queryTaskStatus(tasks);
        
        Assert.assertEquals(ReturnCodeKeys.E015, actual);
        
        int expecteds[][] = { 
            {1, 1}, 
            {2, 1}, 
            {3, 3}, 
            {4, 3}};
        
        assertPlanEqual(expecteds, tasks);
    }
    
    @Test
    public void testScheduleTask3()
    {
        int actual = schedule.init();
        schedule.registerNode(1);
        schedule.registerNode(2);
        
        schedule.addTask(1, 15);
        schedule.addTask(2, 10);
        schedule.addTask(3, 30);
        schedule.addTask(4, 35);
        schedule.addTask(5, 125);
        schedule.addTask(6, 115);
        
        actual = schedule.scheduleTask(10);
        schedule.deleteTask(5);
        
        actual = schedule.scheduleTask(10);
        Assert.assertEquals(ReturnCodeKeys.E014, actual);
    }
}
