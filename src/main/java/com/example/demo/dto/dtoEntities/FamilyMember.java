package com.example.demo.dto.dtoEntities;

public class FamilyMember {

        private String familyName;
        private String givenName;
        private int familyId;
        private int age;

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

        public int getFamilyId() {
                return familyId;
        }

        public void setFamilyId(int familyId) { this.familyId = familyId; }

        public int getAge() {
                return age;
        }

        public void setAge(int age) {
                this.age = age;
        }
}
