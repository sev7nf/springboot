package com.example.demo02.controller.VO;

import java.math.BigDecimal;


public class SalaryDTO {

    private String salaryId;

    private BigDecimal salary;

    public String getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(String salaryId) {
        this.salaryId = salaryId;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
