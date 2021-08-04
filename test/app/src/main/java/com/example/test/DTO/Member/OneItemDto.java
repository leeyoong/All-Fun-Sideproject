package com.example.test.DTO.Member;

public class OneItemDto {
    public OneItemDto(String item) {
        this.item = item;
    }

    private String item;


    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "OneItemDto{" +
                "item='" + item + '\'' +
                '}';
    }


}
