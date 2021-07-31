package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class matchdetail{



    String matchname;
    String matchtitle;
    String matchdate;


    public matchdetail(String matchname, String matchtitle, String matchdate) {
        this.matchname = matchname;
        this.matchtitle = matchtitle;
        this.matchdate = matchdate;
    }



    public String getMatchname() {
        return matchname;
    }

    public void setMatchname(String matchname) {
        this.matchname = matchname;
    }

    public String getMatchtitle() {
        return matchtitle;
    }

    public void setMatchtitle(String matchtitle) {
        this.matchtitle = matchtitle;
    }

    public String getMatchdate() {
        return matchdate;
    }

    public void setMatchdate(String matchdate) {
        this.matchdate = matchdate;
    }


}