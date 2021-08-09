package com.example.orphan.WEB.Thread;

import com.example.orphan.WEB.web.web;


    public class NickCheck_TaskThread  extends Thread {
        web Client = new web();
        String Nickname = null;
        int status = 0;

        public NickCheck_TaskThread(String Nickname){
            this.Nickname = Nickname;




        }
        public int getStatus(){
            return status;
        }

        @Override
        public void run(){
            status=Client.Post_Nickname_Sync(this.Nickname);
        }


    }