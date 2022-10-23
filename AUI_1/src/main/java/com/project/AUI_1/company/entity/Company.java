package com.project.AUI_1.company.entity;


public class Company {

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder {


        private String name;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Company create() {
            return new Company(name);
        }
    }

    private Company(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
