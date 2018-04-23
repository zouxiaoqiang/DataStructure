package application.queue;

import queue.LinkQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BankSimulation {
    // 累计客户逗留时间, 客户数
    private static int totalTime, customerNum;

    // 事件类
    private class Event {
        int occurTime;  // 事件发生时刻
        /*事件类型
         * 0 新的客户到达
         * 1 1号窗口客户离开
         * 2 2号窗口客户离开
         * 3 3号窗口客户离开
         * 4 4号窗口客户离开
         * */
        int eventType;

        Event(int t, int et) {
            occurTime = t;
            eventType = et;
        }
    }

    // 客户类
    private class Customer {
        int arrivalTime;  // 客户到达时间
        int duration;  // 办理事务时间

        Customer(int at, int dt) {
            arrivalTime = at;
            duration = dt;
        }
    }

    // 当前事件
    Event en;
    // 事件表
    list.List<Event> eventList;
    // 4个窗口队列
    List<queue.LinkQueue<Customer>> queues;

    private void orderInsertEvent(Event event) {
        for (int i = 1; i <= eventList.length(); i++) {
            if (event.occurTime < ((Event) eventList.get(i)).occurTime) {
                eventList.add(i, event);
                return;
            }
        }
        eventList.add(event);
    }

    private void openForDay() {
        queues = new ArrayList<>();
        for (int i = 0; i < 4; i++)
            queues.add(new queue.LinkQueue<>());
        totalTime = 0;
        customerNum = 0;
        eventList = new list.LinkList<>();
        // 将事件按照发生的时间顺序插入到事件表中
        orderInsertEvent(new Event(0, 0));
    }

    private int minQueueLength(List<LinkQueue<Customer>> list) {
        int min = list.get(0).length();
        int res = 0;
        for (int i = 1; i < list.size(); i++) {
            if (min > list.get(i).length()) {
                min = list.get(i).length();
                res = i;
            }
        }
        return res;
    }

    private void customerArrived(int closetime, int maxDurtime, int maxIntertime) {
        customerNum++;
        // 模拟客户处理事务时间和下一个客户到来的时间间隔
        Random rand=  new Random();
        int durtime = rand.nextInt(maxDurtime);
        int intertime = rand.nextInt(maxIntertime);
        int t = en.occurTime + intertime;
        if (t < closetime)
            orderInsertEvent(new Event(t, 0));
        int i = minQueueLength(queues);  // 选择人数最少的队列
        queues.get(i).push(new Customer(en.occurTime, durtime));
        if (queues.get(i).length() == 1)
            orderInsertEvent(new Event(en.occurTime + durtime, i + 1));
    }

    private void customerDeparture() {
        int i = en.eventType - 1;  // 第i+1个窗口客户即将离开
        Customer customer = queues.get(i).pop();
        totalTime += en.occurTime - customer.arrivalTime;
        if (!queues.get(i).isEmpty()) {
            Customer cus = queues.get(i).peek();
            orderInsertEvent(new Event(en.occurTime + cus.duration, i + 1));
        }
    }

    /*closetime 银行关闭时间
     * maxDurtime 客户办理业务的时间上限
     * maxIntertime 两个相邻到达银行客户的最大时间间隔
     * 时间单位为分钟
     *
     * */
    public void bankSimulation(int closetime, int maxDurtime, int maxIntertime) {
        openForDay();  // 初始化
        while (!eventList.isEmpty()) {
            en = eventList.remove(1);
            if (en.eventType == 0) {
                // 客户到达事件
                customerArrived(closetime, maxDurtime, maxIntertime);
            } else {
                // 客户离开事件
                customerDeparture();
            }
        }
        System.out.printf("The average time is %.1f", (double) totalTime / customerNum);
    }

    public static void main(String[] args) {
        new BankSimulation().bankSimulation(1000, 5, 2);
    }
}
