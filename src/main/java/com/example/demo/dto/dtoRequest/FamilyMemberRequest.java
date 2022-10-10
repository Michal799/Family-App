package com.example.demo.dto.dtoRequest;

public class FamilyMemberRequest {

        private String familyName;
        private String givenName;
        private int age;

        public int getAge() {
                return age;
        }

        public void setAge(int age) {
                this.age = age;
        }

        public String getFamilyName() {
                return familyName;
        }

        public void setFamilyName(String familyName) {
                this.familyName = familyName;
        }

        public String getGivenName() {
                return givenName;
        }

        public void setGivenName(String givenName) {
                this.givenName = givenName;
        }

}
