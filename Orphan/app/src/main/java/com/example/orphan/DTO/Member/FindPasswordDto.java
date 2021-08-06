package com.example.orphan.DTO.Member;

import androidx.annotation.NonNull;

public class FindPasswordDto {

   public FindPasswordDto(String name, String birth, String phone, String email) {
      this.name = name;
      this.birth = birth;
      this.phone = phone;
      this.email = email;
   }

   private String name;
   private String birth;
   private String phone;
   private String email;




   @NonNull
   public String getName() {
      return name;
   }

   public void setName( String name) {
      this.name = name;
   }

   @NonNull
   public String getBirth() {
      return birth;
   }

   public void setBirth( String birth) {
      this.birth = birth;
   }

   @NonNull
   public String getPhone() {
      return phone;
   }

   public void setPhone( String phone) {
      this.phone = phone;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   @Override
   public String toString() {
      return "FindPasswordDto{" +
              "name='" + name + '\'' +
              ", birth='" + birth + '\'' +
              ", phone='" + phone + '\'' +
              ", email='" + email + '\'' +
              '}';
   }
}
