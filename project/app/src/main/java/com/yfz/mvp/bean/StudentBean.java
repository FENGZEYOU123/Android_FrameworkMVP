package com.yfz.mvp.bean;

/**
 * 学生信息Bean
 */
public class StudentBean {
   private String name;
   private String gender;
   public StudentBean(String name, String gender){
      this.name = name;
      this.gender = gender;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }

   public String getGender() {
      return gender;
   }

   public void setGender(String gender) {
      this.gender = gender;
   }
}
