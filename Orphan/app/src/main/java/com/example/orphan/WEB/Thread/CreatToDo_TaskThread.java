package com.example.orphan.WEB.Thread;

import com.example.orphan.WEB.DTO.dashBoard.todo.CreateToDoDto;
import com.example.orphan.WEB.DTO.mainPage.MyToDoDto;
import com.example.orphan.WEB.web.web;

import java.util.List;

    public class  CreatToDo_TaskThread extends Thread {
        web Client = new web();
        private CreateToDoDto DTO;
        private Long groupId;
        private int status = 0;

        public CreatToDo_TaskThread(Long groupId , CreateToDoDto dto) {
            this.groupId = groupId;
            this.DTO = dto;
        }


        @Override
        public void run(){
            status =  Client.Post_Creat_todo(groupId,DTO);
            if(status != 204){
                System.out.println("터짐 ㅎ");
            }
        }


    }