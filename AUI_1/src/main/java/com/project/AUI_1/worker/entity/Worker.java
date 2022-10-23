package com.project.AUI_1.worker.entity;

import com.project.AUI_1.company.entity.Company;

public class Worker {
    private int id;
    private String name;
    private Company company;


    private Worker(String name, Company company) {
        this.name = name;
        this.company = company;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String name;
        private Company company;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder company(Company company) {
            this.company = company;
            return this;
        }

        public Worker create() {
            return new Worker(name, company);
        }
    }

    public int getId() {
        return id;
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", company=" + company +
                '}';
    }
}
