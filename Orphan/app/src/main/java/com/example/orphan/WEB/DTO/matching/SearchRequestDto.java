package com.example.orphan.WEB.DTO.matching;


public class SearchRequestDto {
    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public SearchRequestDto(String search) {
        this.search = search;
    }

    private String search; //제목 검색명
}
