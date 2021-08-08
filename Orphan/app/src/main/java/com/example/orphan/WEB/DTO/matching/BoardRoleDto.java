package com.example.orphan.WEB.DTO.matching;


public class BoardRoleDto {
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getExpect() {
        return expect;
    }

    public void setExpect(int expect) {
        this.expect = expect;
    }

    public int getEntry() {
        return entry;
    }

    public void setEntry(int entry) {
        this.entry = entry;
    }

    public BoardRoleDto(String role, int expect, int entry) {
        this.role = role;
        this.expect = expect;
        this.entry = entry;
    }

    private String role;
    private int expect;
    private int entry;
}
