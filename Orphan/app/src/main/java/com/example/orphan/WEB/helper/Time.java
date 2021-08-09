package com.example.orphan.WEB.helper;

public class Time {
    String Time;
    int Year;
    int Month;
    int Day;

    public String getTime(){
        return Time;

    }
    public int getYear() {
        return Year;
    }

    public int getMonth() {
        return Month;
    }

    public int getDay() {
        return Day;
    }

    public  Time(){

    }


    public  void setTime(String time){

        //yyyy-mm-ddT00:"00:00.000000

        this.Time = time;
        String[] YearMonth = Time.split("-");
        this.Year = Integer.parseInt(YearMonth[0]);
        this.Month = Integer.parseInt(YearMonth[1]);
        String[] DaySec = YearMonth[2].split("T");
        this.Day = Integer.parseInt(DaySec[0]);


    }


    public void setTime(int year, int month, int day){

        String Syear = String.format("%04d", year);
        String Smonth = String.format("%02d", month);
        String Sday = String.format("%02d", day);

        this.Year = year;
        this.Month = month;
        this.Day = day;

        //yyyy-mm-dd 00:00:00.
        this.Time = Syear +"-"+Smonth +"-"+Sday +" 00:00:00";

    }


    public  boolean isEqual(String time,int year, int month, int day){

        //yyyy-mm-ddT00:"00:00.000000
        boolean output = true;

        this.Time = time;
        String[] YearMonth = Time.split("-");
        this.Year = Integer.parseInt(YearMonth[0]);
        this.Month = Integer.parseInt(YearMonth[1]);
        String[] DaySec = YearMonth[2].split("T");
        this.Day = Integer.parseInt(DaySec[0]);

        if(Year != year){
            output = false;
        }

        if(Month != month){
            output = false;
        }

        if(Day != day){
            output = false;
        }




        return output;


    }





}





