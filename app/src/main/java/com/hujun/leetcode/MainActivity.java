package com.hujun.leetcode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayDeque;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinkedList<String> linkedList = new LinkedList<>();

        //队列接口
        //队尾添加元素
        linkedList.addLast("h");
        linkedList.offerLast("h");
        //offer和add等价
        linkedList.offer("h");
        linkedList.add("h");


        //获取但是不删除队头
        String s = linkedList.getFirst();
        s = linkedList.peekFirst();
        s = linkedList.peek();

        //获取并删除队头
        s = linkedList.poll();
        s = linkedList.pollFirst();
        s = linkedList.remove();
        s = linkedList.removeFirst();

        ArrayDeque<String> arrayDeque = new ArrayDeque<>();
        arrayDeque.addFirst("e");
    }
}
